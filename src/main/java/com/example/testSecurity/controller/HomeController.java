package com.example.testSecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {


    @GetMapping(value = "/")
    public String homePage(){
        return "main";
    }

    @GetMapping(value = "/sign-in")
    public String loginPage(){
        return "login";
    }
}
