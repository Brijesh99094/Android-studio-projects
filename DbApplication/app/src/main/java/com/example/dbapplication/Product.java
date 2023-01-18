package com.example.dbapplication;

import java.io.Serializable;

public class Product implements Serializable {


    long id;
    double quantity;
    long shopping_id;
    String name;
    double price;

    public Product() {
        id = shopping_id = 0;
        name = "Not Added";
        price = quantity = 0;
    }


    public Product(long id, double quantity, long shopping_id, String name, double price) {
        this.id = id;
        this.quantity = quantity;
        this.shopping_id = shopping_id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", shopping_id=" + shopping_id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
