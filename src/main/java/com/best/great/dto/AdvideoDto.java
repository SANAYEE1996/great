package com.best.great.dto;

import lombok.Getter;

@Getter
public class AdvideoDto {


    private Long id;

    private String adUrl;

    private String channelUrl;

    private String name;
    private String upday;
    private String category;
    private int likecnt;
    private int dislike;
    private double ratio;
    private int click;
    private int comment;
    private String hashtag;
    private String descript;
    private Double foreign;


    public AdvideoDto(Long id, String adUrl, String channelUrl, String name, String upday, String category, int likecnt, int dislike, double ratio, int click, int comment, String hashtag, String descript, Double foreign) {
        this.id = id;
        this.adUrl = adUrl;
        this.channelUrl = channelUrl;
        this.name = name;
        this.upday = upday;
        this.category = category;
        this.likecnt = likecnt;
        this.dislike = dislike;
        this.ratio = ratio;
        this.click = click;
        this.comment = comment;
        this.hashtag = hashtag;
        this.descript = descript;
        this.foreign = foreign;
    }
}
