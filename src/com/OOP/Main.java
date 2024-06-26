package com.OOP;

import com.OOP.Entites.Boss;
import com.OOP.Entites.Clerk;
import com.OOP.Entites.Person;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Person person = new Person("John", 23, true, true, new ArrayList<Person>());
        Clerk clerk = new Clerk("Mike", 23, true, true, new ArrayList<Person>(), "232313");
        Boss boss = new Boss("Mike", 23, true, true, new ArrayList<Person>(), "232313", true);

        ArrayList<Person> team = new ArrayList<Person>();

        team.add(person);
        team.add(clerk);
        team.add(boss);

        clerk.showPersonView();
        person.showPersonView();
        clerk.reading();
        person.reading();

        clerk.cry();
        System.out.println(Clerk.getCounter());

        for(Person partOfTeam : team) {
            Entities.CLERK.name().equals(partOfTeam);
        }
    }
}
