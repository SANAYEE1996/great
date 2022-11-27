package com.best.great.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shopping")
public class UrlHandleController {

    @GetMapping("/login")
    public String login(){
        return "shopping/login.html";
    }

    @GetMapping("/main")
    public String loginBuyer(){
        return "shopping/main.html";
    }

    @GetMapping("/seller")
    public String loginSeller(){
        return "shopping/sell/main.html";
    }
}
