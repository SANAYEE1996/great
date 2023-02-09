package com.best.great.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "channel")
@Getter
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "channelUrl")
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

}
