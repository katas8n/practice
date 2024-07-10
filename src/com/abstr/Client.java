package com.abstr;

public class Client extends Person {
    private String bank;

    public Client(String name, String bank) {
        super(name);
        this.bank = bank;

    }

    @Override
    void sayHello() {
        System.out.println("Zdarov!");
    }
}
