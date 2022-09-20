package com.best.great.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "adcomment")
@Data
public class AdvideoComment {
    @Id
    private String url;

    private String comment;

}
