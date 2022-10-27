package com.scu.scedu_cerebral_hemorrhage_platform_java.model;

import com.scu.scedu_cerebral_hemorrhage_platform_java.tool.ListTool;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class UtilRequest {
    public UtilRequest() {

    }

    public UtilRequest(String time, String bundles, String[] trail) {
        this.time = time;
        this.bundles = bundles;
        this.trail = ListTool.removeBlank(Arrays.asList(trail));
    }

    //时间
    String time;
    //脑区
    String bundles;
    //所选轨迹
    List<String> trail;
}
