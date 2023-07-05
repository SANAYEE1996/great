package com.best.great.entity;

import lombok.Getter;

import jakarta.persistence.*;

@Entity(name = "adcomment")
@Getter
public class AdvideoComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private String commentId;

    private String comment;

    @OneToOne
    @JoinColumn(name = "ad_url")
    private Advideo advideo;
}
