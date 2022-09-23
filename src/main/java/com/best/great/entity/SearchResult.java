package com.best.great.entity;


import lombok.Data;


@Data
public class SearchResult {
    private String title;
    private String link;
    private String text;
    private int freq;
}
