package com.scu.scedu_cerebral_hemorrhage_platform_java.tool;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ListTool {
    public static List<String> removeBlank(List<String> in) {
        List<String> out = new ArrayList<>();
        for (String s : in) {
            if (!StringUtils.isBlank(s)) {
                out.add(s);
            }
        }
        return out;
    }
}
