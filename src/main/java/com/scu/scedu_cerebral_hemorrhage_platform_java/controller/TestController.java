package com.scu.scedu_cerebral_hemorrhage_platform_java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping
    public String test(){
        return "server is running";
    }
}
