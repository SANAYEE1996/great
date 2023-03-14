package com.best.great.service;


import com.best.great.entity.SearchResult;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class Crawling {

    private static final Logger log = LoggerFactory.getLogger(Crawling.class);

    public List<SearchResult> searchCrawling(String keyword){
        List<SearchResult> list = new ArrayList<>();
        String url = "https://www.google.com/search?q=" + keyword + "&oq=" + keyword;
        log.info("받은 구글 검색 url : {}", url);
        putSearchResultToList(keyword,url,list);
        return list;
    }

    private void putSearchResultToList(String keyword,String url, List<SearchResult> list){
        Connection conn = Jsoup.connect(url);
        String title;
        String link;
        String text;
        int freq;
        int minSize;
        try{
            Document document = conn.get();
            Elements allTitle = document.select("div.jtfYYd div.yuRUbf h3.LC20lb.MBeuO.DKV0Md");
            Elements allLink = document.select("div.jtfYYd div.yuRUbf>a");
            Elements allText = document.select("div.jtfYYd div.NJo7tc.Z26q7c.uUuwM");
            minSize = Math.min(allText.size(),(Math.min(allTitle.size(), allLink.size())));
            for(int i = 0; i < minSize; i++){
                title = allTitle.get(i).text();
                link = allLink.get(i).attr("abs:href");
                text = allText.get(i).text();
                freq = getFrequency(keyword,text);
                list.add(new SearchResult(title, link, text, freq ));
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    private int getFrequency(String keyword, String text){
        int count = 0;
        int size = keyword.length();
        for(int i = 0; i < text.length()-size; i++){
            if(text.charAt(i) == keyword.charAt(0) && text.substring(i,i+size).equals(keyword)){
                count++;
                i+=size;
            }
        }
        return count;
    }
}
