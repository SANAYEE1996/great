package com.best.great.unit.service;

import com.best.great.service.CompareService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class CompareServiceTest {

    @Autowired
    private CompareService cs;


    @Test
    public void testCase01() throws Exception{
        assertEquals(17,cs.getSearchResult("ㅇㅇㄱ").size());
    }
}
