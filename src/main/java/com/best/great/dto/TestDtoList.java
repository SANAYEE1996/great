package com.best.great.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class TestDtoList {

    private List<TestDto> testList;

    public TestDtoList(List<TestDto> testList){
        this.testList = testList;
    }
}
