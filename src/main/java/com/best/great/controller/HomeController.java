package com.best.great.controller;


import com.best.great.entity.SearchResult;
import com.best.great.service.Crawling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {

    @Autowired


    @GetMapping(value = "/join")
    public String join(Model models) {
        System.out.println("회원 가입 화면");



        return "join.html";
    }

    @GetMapping("/searchPage")
    public String searchPage(Model models) {
        System.out.println("회원 가입 화면");
        return "search.html";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam("keyword") String keyword, Model models){

        Crawling craw = new Crawling();
        ArrayList<SearchResult> list = new ArrayList<>(craw.searchCrawling(keyword));

        keyword = "입력 받은 검색어 : " + keyword;
        models.addAttribute("keyword", keyword);
        models.addAttribute("list",list);


        return "search.html";
    }

}
