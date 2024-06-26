package com.OOP.interfaces;

public interface IPerson {
    public default void eat() {
        System.out.println("I'm eating");
    }
    public default void talking() {
        System.out.println("I'm talking");
    }
    public default void hearing() {
        System.out.println("I hear");
    }
    public default void reading() {
        System.out.println("I'm reading");
    }
}
