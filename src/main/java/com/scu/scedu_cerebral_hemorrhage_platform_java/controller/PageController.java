package com.scu.scedu_cerebral_hemorrhage_platform_java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class PageController {

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    @GetMapping("/cell_subtype_identification")
    public String analysisPage() {
        return "cell_subtype_identification";
    }

    @GetMapping("/similar_cell_type_search")
    public String meshPage() {
        return "similar_cell_type_search";
    }

    @GetMapping("/cell_subtype_similarity_computing")
    public String similarityPage() {
        return "cell_subtype_similarity_computing";
    }

    @GetMapping("/cell_cell_communication_analysis")
    public String communicationPage() {
        return "cell_cell_communication_analysis";
    }
}
