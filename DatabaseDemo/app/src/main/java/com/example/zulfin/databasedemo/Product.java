package com.example.zulfin.databasedemo;

import java.io.Serializable;

public class Product implements Serializable {
    long id;
    long shopingid;
    String name;
    double price;
    double quantity;

    public Product() {
        id = shopingid = 0;
        name = "Not Added";
        price = quantity = 0;
    }

    public Product(long id, long shopingid, String name, double price, double quantity) {
        this.id = id;
        this.shopingid = shopingid;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", shopingid=" + shopingid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
