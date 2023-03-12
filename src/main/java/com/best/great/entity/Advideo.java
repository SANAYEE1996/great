package com.best.great.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity(name = "advideo")
@Getter
public class Advideo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ad_url")
    private String adUrl;
    @Column(name = "name")
    private String name;
    @Column(name = "upday")
    private String upday;
    @Column(name = "category")
    private String category;
    @Column(name = "likecnt")
    private int likeCount;
    @Column(name = "dislike")
    private int dislike;
    @Column(name = "ratio")
    private double ratio;
    @Column(name = "click")
    private int click;
    @Column(name = "comment")
    private int comment;
    @Column(name = "hashtag")
    private String hashtag;
    @Column(name = "descript")
    private String description;
    @Column(name = "foreign")
    private Double foreign;

    @OneToOne(mappedBy = "advideo")
    private AdvideoComment advideoComment;

    @ManyToOne
    @JoinColumn(name = "channel_url")
    private Channel channel;

    public Advideo(String adUrl, String name, String upday, String category, int likeCount, int dislike, double ratio, int click, int comment, String hashtag, String description, Double foreign, AdvideoComment advideoComment, Channel channel) {
        this.adUrl = adUrl;
        this.name = name;
        this.upday = upday;
        this.category = category;
        this.likeCount = likeCount;
        this.dislike = dislike;
        this.ratio = ratio;
        this.click = click;
        this.comment = comment;
        this.hashtag = hashtag;
        this.description = description;
        this.foreign = foreign;
        this.advideoComment = advideoComment;
        this.channel = channel;
    }

    public Advideo() {

    }
}
