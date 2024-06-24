package com.generics;

public class Main {
    public static void main(String[] args) {
        Account admin = new Account<Integer, Double>(1313, 123.23);
        Account guest = new Account<String, Double>("23/2313", 123.23);

        System.out.println(admin.getId());
        System.out.println(admin.getSum());
    }
}
