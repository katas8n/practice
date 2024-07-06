package com.fight;

import com.fight.utils.Utils;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // TODO check Q problem.
        String[] MENU_POINTERS_BY_DEFAULT = {"a", "b", "c", "i"};
        String[] MENU_ITEMS_BY_DEFAULT = {"New game", "Load game", "Game log", "Quit"};

        boolean isRunning = true;

        HashMap<String, String> menu = new HashMap<>();

        Utils.fillMenuItems(MENU_ITEMS_BY_DEFAULT, MENU_POINTERS_BY_DEFAULT, menu);


        while (isRunning) {
            Utils.showMenuItems(menu);

            String menuPointer = scanner.nextLine();

            switch (menuPointer) {
                case "a":
                    newGame();
                    break;
                case "b":
                    loadGame();
                    break;
                case "c":
                    gameLog();
                    break;
                case "i":
                    isRunning = quit();
                    break;
            }

        }

    }


    public static void newGame() {
        System.out.println("New game");
    }

    public static void loadGame() {
        System.out.println("New loadGame");

    }
    public static void gameLog() {
        System.out.println("Game log");
    }
    public static boolean quit() {
        return false;
    }
}
