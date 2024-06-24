package com.interfaces;

public class Book implements Info{
    private String title;
    private String author;
    int price;
    Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
        Info.getDescription();
    }

    public void showInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", Price: " + price);
    }
}
