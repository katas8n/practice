//package com.lesson10;
//
//class Person extends Human{
//    private String name = "Michel";
//    private String surname;
//    private int age;
//    public Person(String name, String surname, int age) {
//        System.out.println("There is a parent constructor");
//
//        this.name = name;
//        this.surname = surname;
//        this.age = age;
//    }
//    public Person(String surname, int age) {
//
//        System.out.println(this.getName());
//        this.surname = surname;
//        this.age = age;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    @Override
//    public int getAge() {
//        return age;
//    }
//}