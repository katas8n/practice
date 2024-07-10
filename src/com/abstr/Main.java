package com.abstr;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("John", "Privat24");
        Employee employee = new Employee("Jim", "Privat24");

        employee.sayHello();
        client.sayHello();
    }
}
