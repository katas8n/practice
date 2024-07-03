package com.collections;

import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class LinkedListClass {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        Vector<String> victor = new Vector<>();
        TreeSet<Integer> sortedSet = new TreeSet<>();
        TreeMap<Integer, String> group = new TreeMap<>();

        group.put(2, "Alex");
        group.put(1, "Hannah");
        group.put(3, "Vlad");
        group.put(4, "Dmytro");
        group.put(6, "Mykita");
        System.out.println(group);

        sortedSet.add(2);
        sortedSet.add(23);
        sortedSet.add(28);
        sortedSet.add(28);
        sortedSet.add(28);
        sortedSet.add(28);
        sortedSet.add(25);
        System.out.println(sortedSet);

        victor.add("Apple");
        victor.add("Banana");
        victor.add("Cola");


        linkedList.add("Item1");
        linkedList.add("Item2");
        linkedList.add("Item3");

        System.out.println(linkedList);
        for(String item : linkedList) {
            System.out.println(item);
        }
    }

}
