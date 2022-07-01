package com.best.great.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity(name = "advideo")
@Data
public class Advideo {
    private String ad_url;

}
