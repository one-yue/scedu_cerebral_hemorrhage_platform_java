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

        List<GeneTrajectory> data = dataService.getTop30(request.getTrail(), request.getTime(), request.getBundles(), 1);
        for (GeneTrajectory geneTrajectory : data) {
            text.append(fileName);
            text.append("\t");
            text.append(geneTrajectory.getGene());
            text.append("\t");
            text.append(geneTrajectory.getScore());
            text.append("\t");
            text.append(geneTrajectory.getPValue());
            text.append("\n");
        }

        exportTxt(response, text.toString(), fileName.toString());

    }

    @GetMapping("/testFile")
    public void testFile(HttpServletResponse response) {
        StringBuilder text = new StringBuilder();
        text.append("hello world");

        exportTxt(response, text.toString(), "data");
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
