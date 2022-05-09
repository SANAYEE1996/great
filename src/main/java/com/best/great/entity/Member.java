package com.best.great.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "member")
@Data
public class Member {

    @Id
    private String id;
    private String pw;
    private String name;
    private String email;

}
