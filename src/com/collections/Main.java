package com.collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        ArrayList<Integer> list = new ArrayList<Integer>();
        Set<Integer> noDuplicatedArr = new HashSet<>();
        ArrayDeque<String> group = new ArrayDeque<>();
        //
        Map<Integer, String> table = new HashMap<Integer, String>();

        table.put(1, "Ukraine");
        table.put(2, "Slovakia");
        table.put(3, "Belgium");
        table.put(4, "Romania");

        table.remove(4, "Romania");
        table.replace(3, "Poland");
        System.out.println(table);

        System.out.println(table.keySet());
        System.out.println(table.values());

        group.addLast("Jim");
        group.addFirst("Bob");
        group.addFirst("John");

        System.out.println(group.getFirst());
        System.out.println(group.getLast());
        noDuplicatedArr.add(13);
        noDuplicatedArr.add(13);
        noDuplicatedArr.add(13);
        noDuplicatedArr.add(13);
        noDuplicatedArr.add(23);
        noDuplicatedArr.add(32);

        list.add(23);
        list.add(13);
        list.add(18);


        list.set(1, 23);

        System.out.println(list);
        System.out.println(noDuplicatedArr);
    }
}
