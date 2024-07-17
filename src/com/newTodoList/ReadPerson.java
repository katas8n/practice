package com.newTodoList;

import java.io.*;

public class ReadPerson implements Serializable {
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("people.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Person copyOfJohn = (Person) ois.readObject();
        System.out.println(copyOfJohn.name);
    }
}
