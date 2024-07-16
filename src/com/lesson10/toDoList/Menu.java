package com.lesson10.toDoList;

import com.fight.utils.Utils;

import java.util.HashMap;

public class Menu {
    private static String[] MENU_ITEMS_DEFAULT = {
            "Add a task to ToDoList",
            "Remove a task from ToDoList",
            "Mark task as done",
            "Show all tasks",
            "Show all pending tasks",
            "Show all done tasks",
            "Exit"
    };

    private static String[] MENU_POINTERS_DEFAULT = { "1", "2", "3", "4", "5", "6", "7"};
    private static HashMap<String, String> defaultMenu = new HashMap<>();

    static {
        Utils.fillMenuItems(MENU_ITEMS_DEFAULT, MENU_POINTERS_DEFAULT, defaultMenu);
    }

    public static void showDefaultMenu() {
        Utils.showMenuItems(defaultMenu);
    }

    public static <T> HashMap<String, String> generateMenu(T[] menuList) {
        int menuSize = menuList.length;

        String[] menuListString = new String[menuSize];
        String[] pointers = new String[menuSize];
        HashMap<String, String> menu = new HashMap<>();

        for (int i = 0; i < menuSize; i++) {
            pointers[i] = Integer.toString(i + 1);
            menuListString[i] = menuList[i].toString();
        }

        Utils.fillMenuItems(menuListString, pointers, menu);

        return menu;
    }

    public static void showMenu(HashMap<String, String> menu) {
        Utils.showMenuItems(menu);
    }
}
