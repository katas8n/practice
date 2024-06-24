package com.enums.Main;

import com.enums.DaysOfWeek;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a day of a week where we will build our plans: ");

                                        // returns values as an array
        for (DaysOfWeek dayOfWeek : DaysOfWeek.values()) {
            System.out.println(dayOfWeek.ordinal()); // returns position of element
            System.out.println(dayOfWeek.name()); // returns string which will represent
        }

        System.out.println("Enter the name of a day: ");
        String chosenDayOfWeek = scanner.nextLine();

        for(int i = 0; i < DaysOfWeek.values().length; i++) {
            DaysOfWeek currentDay =  DaysOfWeek.values()[i];
            String parsedCurrentDay = currentDay.name();

            if(parsedCurrentDay.equals(DaysOfWeek.SUNDAY.name())
                    || parsedCurrentDay.equals(DaysOfWeek.SATURDAY.name()) )  {
                System.out.println("It's a weekend day!");
            }
        }

    }
}
