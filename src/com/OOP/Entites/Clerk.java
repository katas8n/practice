package com.OOP.Entites;

import com.OOP.interfaces.IClerk;

public class Clerk<T, Y>  extends Person implements IClerk {
    T ID;
    static int counter = 0;
    public Clerk(String name, int age, boolean isAlive, boolean hasMoney, Y children, T ID) {
        super(name, age, isAlive, hasMoney, children);
        counter++;
        this.ID = ID;
        this.getMoney();
    }

    // final
    public void cry() {
        System.out.println("I'm disappointed cause my hucking life");
    }

    public static int getCounter() {
        return counter;
    }
}
