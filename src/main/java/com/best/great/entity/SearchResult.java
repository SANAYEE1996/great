package com.best.great.entity;


public class SearchResult {
    private String title;
    private String link;
    private String text;
    private int freq;

    public SearchResult(String title, String link, String text, int freq){
        this.title = title;
        this.link = link;
        this.text = text;
        this.freq = freq;
    }
}
