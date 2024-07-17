package com.newTodoList;

import java.io.Serializable;

public class Car implements Serializable {

    String name;
    Integer year;
    Integer vinCode;

    public Car(String name, Integer year, Integer vinCode) {
        this.name = name;
        this.year = year;
        this.vinCode = vinCode;
    }
}
