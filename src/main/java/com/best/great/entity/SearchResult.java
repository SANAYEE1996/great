package com.best.great.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class SearchResult {
    private String title;
    private String link;
    private String text;
    private int freq;
}
