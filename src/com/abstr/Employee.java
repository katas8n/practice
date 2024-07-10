package com.abstr;

public class Employee extends Person {
    private String company;

    public Employee(String name, String company) {
        super(name);
        this.company = company;
    }

    @Override
    void sayHello() {
        System.out.println("Welcome to the ...");
    }
}
