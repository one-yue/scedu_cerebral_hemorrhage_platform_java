package com.scu.scedu_cerebral_hemorrhage_platform_java.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GeneTrajectory {
    String start;
    String end;
    String id;
    String gene;
    Double score;
    @JsonProperty("pValue")
    Double pValue;
    //"IVH_1d","IVH_3d","IVH_7d","IVH_Sham"
    String time;
    //"Trajectory bundle I", "Trajectory bundle II","Trajectory bundle III"
    String bundles;
    //"负向驱动基因:0","正向驱动基因:1"
    Integer type;
}
