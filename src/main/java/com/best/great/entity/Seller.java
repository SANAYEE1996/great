package com.best.great.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "seller")
@Data
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seller_id;

    private String corpo_id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private String regdate;
}
