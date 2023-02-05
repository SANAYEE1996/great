package com.best.great.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "channel")
@Getter
public class Channel {

    @Id
    private String channelUrl;

    private int monthView;
    private String ch_name;
    private int sub;
    private String regdate;
    private Double totview;
    private String category;
    private String contact;
    private String fan;
    private int insta;
    private int upload;
    private String img;
    private String tag;
    private int clust;
    private Double adavgview;
    private int adcount;
}
