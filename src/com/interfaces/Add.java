package com.interfaces;

public class Add {
    private String title;
    private String author;
    int price;
    Add(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void showInfo() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}
