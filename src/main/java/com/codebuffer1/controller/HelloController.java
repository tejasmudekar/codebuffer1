package com.codebuffer1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class HelloController {

    @GetMapping("/")
    public String helloworld()
    {
        return "Welcome to daily code";
    }


}
