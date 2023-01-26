package com.best.great.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompareServiceTest {

    private CompareService cs;

    @BeforeEach
    public void setup(){
        cs = new CompareService();
    }

    @Test
    public void testCase01(){
        assertEquals(17,cs.getSearchResult("ㅇㅇㄱ").size());
    }
}
