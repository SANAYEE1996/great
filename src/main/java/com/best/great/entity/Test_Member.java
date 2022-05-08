package com.best.great.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "members")
@Data
public class Test_Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "email")
    private String email;

    protected Test_Member(){

    }

    public Test_Member(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

}
