package com.best.great.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "member")
@Data
public class Member {

    @Id
    private String id;

    @Column(name = "pw")
    private String pw;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;

}
