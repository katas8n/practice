package com.InnerClasses;

import com.InnerClasses.Classes.Outerclass;

public class Main {
    public static void main(String[] args) {
        Outerclass outerclass = new Outerclass();

        Outerclass.InnerClass innerClass = outerclass.createInnerClassObject();

        innerClass.showOuterField();
    }
}
