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
@RequestMapping("/search")
public class SearchController {


    @Autowired
    public Crawling craw;

    @GetMapping("")
    public String searchPage() {
        return "search.html";
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String search(@RequestParam("keyword") String keyword, Model models){

        ArrayList<SearchResult> list = new ArrayList<>(craw.searchCrawling(keyword));

        models.addAttribute("keyword", keyword);
        models.addAttribute("list",list);


        return "search.html";
    }

}
