package com.best.great.dto;

import lombok.Getter;

@Getter
public class ChannelDto {
    private final Long id;

    private final String channelUrl;

    private final int monthView;

    private final String ch_name;

    private final int sub;
    private final String regdate;
    private final Double totview;
    private final String category;
    private final String contact;
    private final String fan;
    private final int insta;
    private final int upload;
    private final String img;
    private final String tag;
    private final int clust;
    private final Double adavgview;
    private final int adcount;

    public ChannelDto(Long id, String channelUrl, int monthView, String chName, int sub, String regdate, Double totview, String category, String contact, String fan, int insta, int upload, String img, String tag, int clust, Double adavgview, int adcount) {
        this.id = id;
        this.channelUrl = channelUrl;
        this.monthView = monthView;
        ch_name = chName;
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
}
