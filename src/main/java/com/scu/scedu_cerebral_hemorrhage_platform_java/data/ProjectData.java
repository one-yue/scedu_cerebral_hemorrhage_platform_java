package com.scu.scedu_cerebral_hemorrhage_platform_java.data;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.scu.scedu_cerebral_hemorrhage_platform_java.model.GeneTrajectory;
import com.scu.scedu_cerebral_hemorrhage_platform_java.model.TrailData;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Component
public class ProjectData {
    @Bean
    public List<GeneTrajectory> getGeneData() throws IOException {
        Resource resource = new ClassPathResource("data.json");
        InputStream is = resource.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String data = null;
        if((data = br.readLine()) != null) {
            return JSONArray.parseArray(data, GeneTrajectory.class);
        }

        return null;
    }

    @Bean
    public List<TrailData> getTrainData() throws IOException {
        Resource resource = new ClassPathResource("trail.json");
        InputStream is = resource.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String data = null;
        if((data = br.readLine()) != null) {
            return JSONArray.parseArray(data, TrailData.class);
        }

        return null;
    }

    @Bean
    public JSONObject getSubtypeData() throws IOException {
        Resource resource = new ClassPathResource("subtype_data.json");
        InputStream is = resource.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String data = null;
        if((data = br.readLine()) != null) {
            return JSONObject.parseObject(data);
        }

        return null;
    }
}
