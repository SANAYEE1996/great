package com.best.great.controller;

import com.best.great.dto.TestDtoList;
import com.best.great.dto.TestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping("/save")
    public void test(@RequestBody TestDtoList gogoList){
        List<TestDto> testDtoList = gogoList.getTestList();
        for(TestDto testDto : testDtoList){
            System.out.println(testDto.getTestName());
        }
    }
}
