package com.best.great.shopping.entity.customer;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "product")
@Data
public class Product {

    @Id
    private String product_id;
    private String name;
    private int price;
    private String info;

    private String seller_id;
    private String thumbnail_path;
    private int delivery_charge;
    private String option;
}
