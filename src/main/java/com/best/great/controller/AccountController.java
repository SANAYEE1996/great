package com.best.great.controller;

import com.best.great.entity.User;
import com.best.great.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public String login(){

        return "account/login.html";
    }

    @GetMapping("/register")
    public String register(){

        return "account/register.html";
    }

    @PostMapping(value = "/register")
    public String register(User user){
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        userService.save(user);
        return "redirect:/";
    }

}
