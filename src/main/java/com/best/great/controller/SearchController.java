package com.best.great.controller;


import com.best.great.entity.SearchResult;
import com.best.great.service.Crawling;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final Crawling craw;

    public SearchController(Crawling craw) {
        this.craw = craw;
    }


    @PostMapping(value = "/result")
    public ArrayList<SearchResult> search(@RequestParam("keyword") String keyword){
        return new ArrayList<>(craw.searchCrawling(keyword));
    }

}
