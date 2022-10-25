package com.scu.scedu_cerebral_hemorrhage_platform_java.model;

import lombok.Data;

import java.util.List;

@Data
public class UtilRequest {
    //时间
    String time;
    //脑区
    String bundles;
    //所选轨迹
    List<String> trail;
}
