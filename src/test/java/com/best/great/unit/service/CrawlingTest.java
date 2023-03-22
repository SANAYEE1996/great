package com.best.great.unit.service;


import com.best.great.entity.SearchResult;
import com.best.great.service.Crawling;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CrawlingTest {

    private Crawling crawling;

    @BeforeEach
    public void setup(){
        crawling = new Crawling();
    }

    @Test
    public void testCase01(){
        List<SearchResult> list = crawling.searchCrawling("google");
        assertEquals("",list.get(0));
        System.out.println(list.get(0));
    }

}
