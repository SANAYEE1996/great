package com.best.great.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompareServiceTest {

    private CompareService cs;

    @BeforeEach
    public void setup(){
        cs = new CompareService();
    }

    @Test
    public void testCase01(){
        System.out.println(cs.getSearchResult("ㅇㅇㄱ"));
    }
}
