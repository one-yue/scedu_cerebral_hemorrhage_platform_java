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

    @GetMapping("/cell_subtype_analysis")
    public String analysisPage() {
        return "cell_subtype_analysis";
    }

    @GetMapping("/cell_mesh")
    public String meshPage() {
        return "CellMeSH";
    }

    @GetMapping("/similarity_analysis")
    public String similarityPage() {
        return "similarity_analysis";
    }

    @GetMapping("/cell_communication")
    public String communicationPage() {
        return "cell_communication";
    }
}
