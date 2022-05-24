package com.best.great.controller;


import com.best.great.entity.SearchResult;
import com.best.great.service.Crawling;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("/search")
public class SearchController {



    @GetMapping("")
    public String searchPage() {
        System.out.println("기본 검색 화면");
        return "search.html";
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String search(@RequestParam("keyword") String keyword, Model models){

        Crawling craw = new Crawling();
        ArrayList<SearchResult> list = new ArrayList<>(craw.searchCrawling(keyword));

        keyword = "입력 받은 검색어 : " + keyword;
        models.addAttribute("keyword", keyword);
        models.addAttribute("list",list);


        return "search.html";
    }

}
