package com.OOP.Entites;

import com.OOP.interfaces.IPerson;

import java.util.ArrayList;

//import java.util.List;

public class Person<T> implements IPerson {
    String name;
    int age;
    boolean isAlive;
    boolean hasMoney;
    T children;
    public Person(String name,int age,boolean isAlive,boolean hasMoney,T children) {
        this.name = name;
        this.age = age;
        this.isAlive = isAlive;
        this.hasMoney = hasMoney;
        this.children = children;

        this.getMoney();
    }

    public void showPersonView() {
        System.out.printf("[NAME]: %s", name + "\n");
    }

    protected boolean getMoney() {
        return this.hasMoney;
    }
}

