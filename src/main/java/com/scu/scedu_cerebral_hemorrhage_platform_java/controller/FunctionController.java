package com.scu.scedu_cerebral_hemorrhage_platform_java.controller;

import com.scu.scedu_cerebral_hemorrhage_platform_java.model.GeneTrajectory;
import com.scu.scedu_cerebral_hemorrhage_platform_java.model.UtilRequest;
import com.scu.scedu_cerebral_hemorrhage_platform_java.model.UtilResponse;
import com.scu.scedu_cerebral_hemorrhage_platform_java.service.DataService;
import com.scu.scedu_cerebral_hemorrhage_platform_java.tool.ListTool;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

@RestController
@RequestMapping("/cell_subtype_analysis")
public class FunctionController {

    @Autowired
    DataService dataService;


    /**
     * 根据time和bundles返回对应的轨迹图片的地址
     *
     * @param time    时间
     * @param bundles 脑区
     * @return 图片地址
     */
    @GetMapping("/image")
    public UtilResponse getImage(@RequestParam String time,
                                 @RequestParam String bundles) {
        String fileName = time + "_" + bundles + ".tif";

        return success("/static/image/fileName");
    }

    /**
     * 获取time和bundles条件下的所有轨迹列表
     *
     * @param time    时间
     * @param bundles 脑区
     * @return 轨迹列表
     */
    @GetMapping("/trail_info")
    public UtilResponse getTrailInfo(@RequestParam String time,
                                     @RequestParam String bundles) {

        return success(dataService.getTrailForAll(time, bundles));
    }

    @GetMapping("/next_point")
    public UtilResponse getNextPoint(@RequestParam String lastPoint,
                                     @RequestParam String time,
                                     @RequestParam String bundles) {

        if (StringUtils.isBlank(lastPoint)) {
            return success(new ArrayList<>());
        }
        List<List<String>> trails = dataService.getTrailForAll(time, bundles);
        Set<String> nextPoints = new HashSet<>();

        for (List<String> trail : trails) {
            for (int i = 0; i < trail.size() - 1; i++) {
                if ("head".equals(lastPoint)) {
                    nextPoints.add(trail.get(i));
                } else if (trail.get(i).equals(lastPoint)) {
                    nextPoints.add(trail.get(i + 1));
                }
            }
        }


        return success(nextPoints);
    }

    /**
     * 获取前三十的正/负基因
     *
     * @param request time bundles 轨迹
     * @return 前三十的正/负基因
     */
    @PostMapping("/data")
    public UtilResponse getData(@RequestBody UtilRequest request) {
        Map<String, List<GeneTrajectory>> result = new HashMap<>();
        List<String> trail = ListTool.removeBlank(request.getTrail());
        result.put("up", dataService.getTop30(trail, request.getTime(), request.getBundles(), 1));
        result.put("down", dataService.getTop30(trail, request.getTime(), request.getBundles(), 0));
        return success(result);
    }

    @PostMapping("/simData")
    public UtilResponse simData(@RequestBody List<UtilRequest> request) {
        if (request.size() != 2) {
            return fail("数据传输错误", null);
        }

        UtilRequest request1 = request.get(0);
        List<String> trail1 = ListTool.removeBlank(request1.getTrail());
        List<GeneTrajectory> data1 = new ArrayList<>();
        //拿出第一个轨迹，time，脑区 拿出基因
        data1.addAll(dataService.getTop30(trail1, request1.getTime(), request1.getBundles(), 1));
        data1.addAll(dataService.getTop30(trail1, request1.getTime(), request1.getBundles(), 0));

        UtilRequest request2 = request.get(1);
        List<String> trail2 = ListTool.removeBlank(request1.getTrail());
        List<GeneTrajectory> data2 = new ArrayList<>();
        //拿出第一个轨迹，time，脑区 拿出基因
        data2.addAll(dataService.getTop30(trail2, request2.getTime(), request2.getBundles(), 1));
        data2.addAll(dataService.getTop30(trail2, request2.getTime(), request2.getBundles(), 0));

        //对比
        int intersection = 0;
        for (GeneTrajectory gene1 : data1) {
            for (GeneTrajectory gene2 : data2) {
                if (gene1.getGene().equals(gene2.getGene())) {
                    if (Objects.equals(gene1.getType(), gene2.getType())) {
                        intersection++;
                    } else {
                        intersection--;
                    }
                }
            }
        }

        return success((intersection / (data1.size() + data2.size()) + 1) / 2);
    }

    @PostMapping("/simDataq")
    public UtilResponse dbSelect(@RequestBody List<UtilRequest> request) {
        //todo 查库

        //todo 转换数据

        return null;
    }


    /**
     * 获取制表数据
     *
     * @param request time bundles 轨迹
     * @return 制表数据
     */
    @PostMapping("/tableData")
    public List<List<String>> generateTableData(@RequestBody UtilRequest request) {
        List<String> trail = ListTool.removeBlank(request.getTrail());
        return dataService.getTableData(trail, request.getTime(), request.getBundles());
    }


    /**
     * 生成文件
     *
     * @param time
     * @param bundles
     * @param trail
     * @param response
     */
    @GetMapping("/file")
    public void getFile(@RequestParam("time") String time,
                        @RequestParam("bundles") String bundles,
                        @RequestParam("point") String[] trail, HttpServletResponse response) {
        UtilRequest request = new UtilRequest(time, bundles, trail);

        StringBuilder text = new StringBuilder();
        //表头
        StringBuilder fileName = new StringBuilder(request.getTrail().get(0));
        for (int i = 1; i < request.getTrail().size(); i++) {
            fileName.append("->").append(request.getTrail().get(i));
        }

        text.append(fileName.toString());
        text.append("\t");
        text.append("gene");
        text.append("\t");
        text.append("score");
        text.append("\t");
        text.append("p-value");
        text.append("\n");

        List<List<String>> data = dataService.getTableData(ListTool.removeBlank(request.getTrail()), request.getTime(), request.getBundles());
        for (List<String> geneTrajectory : data) {
            text.append(geneTrajectory.get(0));
            text.append("\t");
            text.append(geneTrajectory.get(1));
            text.append("\t");
            text.append(geneTrajectory.get(2));
            text.append("\t");
            text.append(geneTrajectory.get(3));
            text.append("\n");
        }

        exportTxt(response, text.toString(), fileName.toString());

    }

    /* 导出txt文件
     * @author
     * @param	response
     * @param	text 导出的字符串
     * @return
     */
    public void exportTxt(HttpServletResponse response, String text, String filename) {
        response.setCharacterEncoding("utf-8");
        //设置响应的内容类型
        response.setContentType("text/plain");
        //设置文件的名称和格式
        response.addHeader("Content-Disposition", "attachment;filename="
                + "data"//设置名称格式，没有这个中文名称无法显示
                + ".txt");
        BufferedOutputStream buff = null;
        ServletOutputStream outStr = null;
        try {
            outStr = response.getOutputStream();
            buff = new BufferedOutputStream(outStr);
            buff.write(text.getBytes(StandardCharsets.UTF_8));
            buff.flush();
            buff.close();
        } catch (Exception e) {
            //LOGGER.error("导出文件文件出错:{}",e);
        } finally {
            try {
                buff.close();
                outStr.close();
            } catch (Exception e) {
            }
        }
    }


    private UtilResponse success(Object body) {
        return new UtilResponse(true, "success", body);
    }

    private UtilResponse fail(String msg, Object body) {
        return new UtilResponse(false, msg, body);
    }

}
