package com.comparable;

import com.comparable.Classes.Person;

public class Main {
    public static void main(String[] args) {
        Person person1 =  new Person("John", 23);
        Person person2 =  new Person("John", 23);

        System.out.println(person2.equals(person1));
    }
}
