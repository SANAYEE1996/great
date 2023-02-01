package com.best.great.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "adcomment")
@Data
public class AdvideoComment {

    @Id
    private String url;

    private String comment;

    @OneToOne
    @JoinColumn(name = "ad_url")
    private Advideo advideo;
}
