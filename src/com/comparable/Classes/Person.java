package com.comparable.Classes;

public class Person {
    private String name;
    private  int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int compareTo(Person differentPerson) {
        return differentPerson.age - this.age;
    }
}
