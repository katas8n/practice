package com.interfaces;

public interface Info {
    void showInfo();

    static void read() {
        System.out.println("There is a process of reading!");
    }

    static void getDescription() {
        System.out.println("There is a text which you able to read");
    }
}
