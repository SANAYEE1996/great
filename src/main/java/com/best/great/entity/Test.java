package com.best.great.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity(name = "Test")
@Table(name = "Test1")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Test {

    @Id
    private String id;

    private String pw;
    private String name;

    @Builder
    public Test(String id,String pw, String name){
        this.id = id;
        this.pw = pw;
        this.name = name;
    }


}
