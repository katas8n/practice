package com.lesson10.utils;

import java.util.HashMap;

public class Utils {
    public static void fillMenuItems (String[] MENU_ITEMS_BY_DEFAULT, String[] MENU_POINTERS_BY_DEFAULT, HashMap menu) {
        for(int i = 0; i < MENU_ITEMS_BY_DEFAULT.length; i++) {
            menu.put(MENU_POINTERS_BY_DEFAULT[i], MENU_ITEMS_BY_DEFAULT[i]);
        }
    }

    public static void showMenuItems(HashMap items) {
        for(Object item : items.keySet()) {
            System.out.println(item + ") " + items.get(item));
        }
    }
}
