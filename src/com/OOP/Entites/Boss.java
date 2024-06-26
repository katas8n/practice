package com.OOP.Entites;

public class Boss<T, Y> extends Clerk<T, Y> {
    private boolean hasKeys;

    public Boss(String name, int age, boolean isAlive, boolean hasMoney, Y children, T ID, boolean hasKeys) {
        super(name, age, isAlive, hasMoney, children, ID);
        this.hasKeys = hasKeys;
    }

    @Override
    public void cry() {
        System.out.println("Why am I not in top-100 most reach people of year!");
    }
}
