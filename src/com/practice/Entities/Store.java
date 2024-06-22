package com.practice.Entities;

import java.util.ArrayList;
import java.util.Arrays;

public class Store {
    private String title;
    private ArrayList<Product> products;

    public Store(String title, ArrayList<Product> products) {
        this.title = title;
        this.products = products;

        System.out.println("STORE WAS CREATED: " + this.title);
    }

    @Override
    public String toString() {
        return "Store: " +
                "title='" + title + '\'' +
                ", products=" + products;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addNewProduct(Product product) {
        products.add(product);
    }
}
