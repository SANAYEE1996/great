package com.best.great.shopping.entity;

import lombok.Data;

@Data
public class Product {
    private long product_code;
    private String name;
    private long price;
    private int count;
}
