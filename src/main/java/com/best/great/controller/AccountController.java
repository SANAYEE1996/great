package com.best.great.controller;

import com.best.great.entity.User;
import com.best.great.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {


    private final UserService userService;

    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){

        return "account/login.html";
    }

    @GetMapping("/register")
    public String register(){

        return "account/register.html";
    }

    @PostMapping("/register")
    public String register(User user){
        userService.save(user);
        return "redirect:/";
    }

}
