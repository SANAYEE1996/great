package com.best.great.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TestDto {

    private String testName;

    private int testAge;

    public TestDto(String testName, int testAge) {
        this.testName = testName;
        this.testAge = testAge;
    }
}
