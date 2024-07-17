package com.newTodoList;

import java.io.*;

public class Person implements Serializable {
    public String name;
    private int age;
    private static final long serialVersionUID = 1;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Person person = new Person("John", 23);
        Person person1 = new Person("Mike", 32);

        FileOutputStream fileOutputStream = new FileOutputStream("people.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(person);
    }

}
