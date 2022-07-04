package com.best.great.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity(name = "advideo")
@Data
public class Advideo {
    private String ad_url;
    private String ch_url;
    private String name;
    private String upday;
    private String category;
    private int likeCnt;
    private int dislike;
    private double ratio;
    private int click;
    private int comment;
    private String hashtag;
    private String descript;
    private Double foreign;
}
