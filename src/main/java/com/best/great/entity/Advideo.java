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

    @OneToOne(mappedBy = "advideo")
    private AdvideoComment advideoComment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "channel_url")
    private Channel channel;
}
