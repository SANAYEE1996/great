package com.best.great.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "advideo")
@Data
public class Advideo {

    @Id
    private String ad_url;

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
}
