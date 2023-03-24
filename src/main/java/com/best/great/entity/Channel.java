package com.best.great.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "channel")
@Getter
public class Channel{
    @Id
    @Column(name = "channel_url")
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

    @OneToMany(mappedBy = "channel")
    private List<Advideo> advideoList = new ArrayList<>();

    public Channel(String channelUrl, int monthView, String ch_name, int sub, String regdate, Double totview, String category, String contact, String fan, int insta, int upload, String img, String tag, int clust, Double adavgview, int adcount) {
        this.channelUrl = channelUrl;
        this.monthView = monthView;
        this.ch_name = ch_name;
        this.sub = sub;
        this.regdate = regdate;
        this.totview = totview;
        this.category = category;
        this.contact = contact;
        this.fan = fan;
        this.insta = insta;
        this.upload = upload;
        this.img = img;
        this.tag = tag;
        this.clust = clust;
        this.adavgview = adavgview;
        this.adcount = adcount;
    }

    public Channel() {

    }
}
