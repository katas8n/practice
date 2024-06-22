package com.practice.Entities;

import java.util.ArrayList;
import java.util.Arrays;

public class Cart {
    static int amountOfCarts = 0;
    private ArrayList<Product> products;
    private int ID;

    public Cart(ArrayList<Product> products, int ID) {
        amountOfCarts++;
        this.products = products;
        this.ID = ID;

        System.out.println("THERE IS A CART WITH ID: " + this.ID);
        System.out.println("THERE IS A CART WITH FOLLOWING PRODUCTS: " + this.products);
    }

    @Override
    public String toString() {
        return "Cart: " +
                "products=" + products +
                ", ID=" + ID +
                '}';
    }
    public static int getAmountOfCarts() {
        return amountOfCarts;
    }
    public void takeOutProduct(int index) {
        this.products.remove(index);
    }

    public void buyProduct(Product product) {
        this.products.add(product);
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    public ArrayList<Product> getProducts() {
        return products;
    }
}
