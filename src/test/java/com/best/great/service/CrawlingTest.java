package com.best.great.service;


import com.best.great.entity.SearchResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CrawlingTest {

    private Crawling crawling;

    @BeforeEach
    public void setup(){
        crawling = new Crawling();
    }

    @Test
    public void testCase01(){
        List<SearchResult> list = new ArrayList<>();
        list = crawling.searchCrawling("google");

    }

}
