//package com.lesson10;
//
//public class Developer extends Person {
//    String name;
//    String surname;
//    int age;
//    boolean hasMoney;
//    Computer device;
//
//    public Developer(String name, String surname, int age, boolean hasMoney, Computer computer) {
//        super(name, surname, age);
//        System.out.println(this.getName());
//        System.out.println("Child constructor");
//        this.hasMoney = hasMoney;
//        this.device = new Computer<Integer, Detail>("Asus",
//                232,
//                323,
//                new Detail[]{
//                        new Detail("Aser", 23),
//                        new RAM("Nvidia", 32)
//                });
//    }
//
//    public void writeCleanCode() {
//        System.out.println("I write clean code as a Developer!");
//    }
//
//    public Computer getDevice() {
//        return device;
//    }
//}
