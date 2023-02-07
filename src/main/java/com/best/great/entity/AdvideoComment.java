package com.best.great.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "adcomment")
public class AdvideoComment {

    @Id
    private String url;

    private String comment;

    @OneToOne
    @JoinColumn(name = "ad_url")
    private Advideo advideo;
}
