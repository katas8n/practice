package com.practice.Entities;

public class Product {
    private String label;
    private double price;
    private double discount;

    public Product(String label, double price, double discount) {
        this.label = label;
        this.price = price;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product" +
                "label='" + label + '\'' +
                ", price=" + price +
                ", discount=" + discount;
    }

    public Product(String label, double price) {
        this.label = label;
        this.price = price;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}
