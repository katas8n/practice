package com.InnerClasses.Classes;

public class Outerclass {
    private int outerField = 13;

    // nested class
    public class InnerClass {
        public void showOuterField() {
            System.out.println("Here we keep outer field : " + outerField);
        }
    }

    @Override
    public String toString() {
        return "Outerclass{" +
                "outerField=" + outerField +
                '}';
    }

    public InnerClass createInnerClassObject() {
        return new InnerClass();
    }
}
