package com.best.great.shopping.entity.customer;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "buyer")
@Data
public class Buyer {
    @Id
    private String buyer_id;

    private String password;
    private String name;
    private String number;
    private String birthdate;
    private char auth_yn;
}
