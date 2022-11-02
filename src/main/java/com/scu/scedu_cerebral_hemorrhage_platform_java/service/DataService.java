package com.scu.scedu_cerebral_hemorrhage_platform_java.service;

import com.scu.scedu_cerebral_hemorrhage_platform_java.model.GeneTrajectory;
import com.scu.scedu_cerebral_hemorrhage_platform_java.model.TrailData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DataService {

    @Autowired
    List<GeneTrajectory> geneData;

    @Autowired
    List<TrailData> trailData;

    //根据条件筛选数据
    public List<TrailData> getQueryGeneData(String time, String bundles) {
        List<TrailData> result = new ArrayList<>();
        for (TrailData singleTrailData : trailData) {
            if (time.equals(singleTrailData.getTime()) && bundles.equals(singleTrailData.getBundles())) {
                result.add(singleTrailData);

            }
        }
        return result;
    }

    //考虑区域为All，查询所有轨迹
    public List<List<String>> getTrailForAll(String time, String bundles) {
        if ("All".equals(bundles)) {
            List<List<String>> list1 = getTrail(time, "Trajectory_bundle_1");
            List<List<String>> list2 = getTrail(time, "Trajectory_bundle_2");
            List<List<String>> list3 = getTrail(time, "Trajectory_bundle_3");
            List<List<String>> result = new ArrayList<>();
            result.addAll(list1);
            result.addAll(list2);
            result.addAll(list3);
            return result;
        }
        return getTrail(time, bundles);

    }

    //根据数据找到所有轨迹
    private List<List<String>> getTrail(String time, String bundles) {
        List<TrailData> upData = getQueryGeneData(time, bundles);
        //1 找到轨迹的起始点，起始点满足没有end等于该点
        List<TrailData> startPoints = new ArrayList<>();
        for (TrailData startPoint : upData) {
            boolean flag = true;
            for (TrailData endPoint : upData) {
                if (startPoint.getStart().equals(endPoint.getEnd())) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                startPoints.add(startPoint);
            }
        }
        //2 根据起始点，生成轨迹全路径
        List<String> resultListStr = new ArrayList<>();
        for (TrailData startPoint : startPoints) {
            String trail = startPoint.getStart();
            generateTrail(startPoint, upData, trail, resultListStr);
        }

        List<List<String>> result = new ArrayList<>();
        for (String resultStr : resultListStr) {
            String[] trailList = resultStr.split("-");
            result.add(Arrays.stream(trailList).collect(Collectors.toList()));
        }

        return result;
    }

    private void generateTrail(TrailData startPoint, List<TrailData> points, String trail, List<String> resultList) {
        boolean isNext = false;
        for (TrailData point : points) {
            //是否还有下一个节点
            if (startPoint.getEnd().equals(point.getStart())) {
                //找到了下一个节点
                isNext = true;
                String newTrail = trail + "-" + point.getStart();
                generateTrail(point, points, newTrail, resultList);
            }
        }
        if (!isNext) {
            //没有下一个节点了，则输出
            String newTrail = trail + "-" + startPoint.getEnd();
            resultList.add(newTrail);
        }
    }

    //根据轨迹筛选top30的正向数据
    public List<GeneTrajectory> getTop30(List<String> trail, String time, String bundles, Integer type) {
        List<GeneTrajectory> queryList = new ArrayList<>();
        //1 筛选出符合条件的数据
        for (GeneTrajectory geneTrajectory : geneData) {
            if (geneTrajectory.getTime().equals(time) &&
                    geneTrajectory.getBundles().equals(bundles) &&
                    Objects.equals(geneTrajectory.getType(), type)) {
                for (int i = 0; i < trail.size() - 1; i++) {
                    if (geneTrajectory.getStart().equals(trail.get(i)) &&
                            geneTrajectory.getEnd().equals(trail.get(i + 1))) {
                        queryList.add(geneTrajectory);
                    }
                }
            }

        }
        return queryList;
    }

    //筛选出每两点之间的top30
    public List<GeneTrajectory> get2PointData(String start, String end, String time, String bundles) {
        //筛选出所有符合条件的数据
        List<GeneTrajectory> queryList = new ArrayList<>();
        for (GeneTrajectory geneTrajectory : geneData) {
            if (geneTrajectory.getTime().equals(time) &&
                    geneTrajectory.getBundles().equals(bundles) &&
                    geneTrajectory.getStart().equals(start) &&
                    geneTrajectory.getEnd().equals(end)) {
                //检查当前列表里是否已经有该基因的数据了
                Integer index = getDataByGeneName(geneTrajectory.getGene(), queryList);
                if (index != null) {
                    //出现重复的
                    Double oldScore = queryList.get(index).getScore() * queryList.get(index).getScore();
                    Double newScore = geneTrajectory.getScore() * geneTrajectory.getScore();
                    //如果新的更大则替换
                    queryList.add(index, geneTrajectory);
                }
                queryList.add(geneTrajectory);
            }
        }

        //2 排序，输出top30
        return ascending(queryList);
    }

    public List<List<String>> getTableData(List<String> trail, String time, String bundles) {
        List<GeneTrajectory> up = new ArrayList<>();
        List<GeneTrajectory> down = new ArrayList<>();
        for (int i = 0; i < trail.size() - 1; i++) {
            //遍历每两点轨迹
            List<GeneTrajectory> upAndDownData = get2PointData(trail.get(i), trail.get(i + 1), time, bundles);
            up.addAll(upAndDownData.subList(0, 30));
            down.addAll(upAndDownData.subList(31, 60));
        }

        //生成制表数据
        List<List<String>> result = new ArrayList<>();
        for (GeneTrajectory upGene : up) {
            result.add(Arrays.asList(
                    upGene.getStart() + "->" + upGene.getEnd(),
                    upGene.getGene() + "(+)",
                    upGene.getScore() + "",
                    upGene.getPValue() + ""));
        }
        for (GeneTrajectory downGene : down) {
            result.add(Arrays.asList(
                    downGene.getStart() + "->" + downGene.getEnd(),
                    downGene.getGene() + "(-)",
                    downGene.getScore() + "",
                    downGene.getPValue() + ""));
        }

        return result;
    }

    private Integer getDataByGeneName(String name, List<GeneTrajectory> currentList) {
        for (int i = 0; i < currentList.size(); i++) {
            if (name.equals(currentList.get(i).getGene())) {
                return i;
            }
        }
        return null;
    }

    //升序
    private List<GeneTrajectory> ascending(List<GeneTrajectory> in) {
        for (int i = 1; i < in.size(); i++) {
            //挖出一个要用来插入的值,同时位置上留下一个可以存新的值的坑
            Double x = in.get(i).getScore();
            GeneTrajectory xData = in.get(i);
            int j = i - 1;
            //在前面有一个或连续多个值比x大的时候,一直循环往前面找,将x插入到这串值前面
            while (j >= 0 && in.get(j).getScore() < x) {
                //当arr[j]比x大的时候,将j向后移一位,正好填到坑中
                in.set(j + 1, in.get(j));
                j--;
            }
            //将x插入到最前面
            in.set(j + 1, xData);
        }

        List<GeneTrajectory> result = in.subList(0, 30);
        result.addAll(in.subList(in.size() - 30, in.size()));

        return result;
    }

    //降序
    private List<GeneTrajectory> descending(List<GeneTrajectory> in) {
        for (int i = 1; i < in.size(); i++) {
            //挖出一个要用来插入的值,同时位置上留下一个可以存新的值的坑
            Double x = in.get(i).getScore();
            GeneTrajectory xData = in.get(i);
            int j = i - 1;
            //在前面有一个或连续多个值比x大的时候,一直循环往前面找,将x插入到这串值前面
            while (j >= 0 && in.get(j).getScore() > x) {
                //当arr[j]比x小的时候,将j向后移一位,正好填到坑中
                in.set(j + 1, in.get(j));
                j--;
            }
            //将x插入到最前面
            in.set(j + 1, xData);
        }

        return in.subList(0, 30);
    }
}
