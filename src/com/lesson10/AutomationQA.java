//package com.lesson10;
//
//import java.util.Objects;
//
//public class AutomationQA extends Developer {
//    String name;
//    String surname;
//    int age;
//    boolean hasMoney;
//
//    public AutomationQA(String name, String surname, int age, boolean hasMoney, Computer computer) {
//        super(name, surname, age, hasMoney, computer);
//        System.out.println("There is an AutomationQA constructor!");
//    }
//
//    @Override
//    public void writeCleanCode() {
//        System.out.println("I write enough clean code as a AQA!");
//    }
//
//    @Override
//    public String toString() {
//       return  "[NAME]: " + this.getName();
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//       if(obj instanceof AutomationQA) {
//           Person person = (AutomationQA) obj;
//
//           return this.getName().equals(person.getName()) && this.getAge() == person.getAge();
//       } else {
//           return false;
//       }
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, surname, age, hasMoney);
//    }
//}
