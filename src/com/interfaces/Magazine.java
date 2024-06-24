package com.interfaces;

public class Magazine implements Info {
    private String title;
    private String author;
    int price;

    Magazine(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void showInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", Price: " + price);
    }
}
