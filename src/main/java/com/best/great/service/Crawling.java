package com.best.great.service;


import com.best.great.entity.SearchResult;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class Crawling {
    public List<SearchResult> searchCrawling(String keyword){
        List<SearchResult> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder("https://www.google.com/search?q=");
        sb.append(keyword);
        sb.append("&oq=");
        sb.append(keyword);
        String url = sb.toString();
        //System.out.println("받은 구글 검색 url : " +url);
        Connection conn = Jsoup.connect(url);
        String title = "";
        String link = "";
        String text = "";
        int freq = 0;
        try{
            Document document = conn.get();
            Elements allTitle = document.select("div.jtfYYd div.yuRUbf h3.LC20lb.MBeuO.DKV0Md");
            Elements allLink = document.select("div.jtfYYd div.yuRUbf>a");
            Elements allText = document.select("div.jtfYYd div.NJo7tc.Z26q7c.uUuwM");
            int[] arr = {allTitle.size(), allLink.size(), allText.size()};
            Arrays.sort(arr);
            for(int i = 0; i < arr[0]; i++){
                SearchResult sr = new SearchResult();
                title = allTitle.get(i).text().toString();
                link = allLink.get(i).attr("abs:href");
                text = allText.get(i).text().toString();
                freq = getFrequency(keyword,text);
                sr.setTitle(title);
                sr.setLink(link);
                sr.setText(text);
                sr.setFreq(freq);
                list.add(sr);
            }

        }
        catch(IOException e){
            e.printStackTrace();
        }
        /*
        for(SearchResult i : list){
            System.out.println(i);
        }
        */

        return list;
    }



    public static int getFrequency(String keyword, String text){
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
