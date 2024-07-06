package com.fight;

import com.fight.Account.Account;
import com.fight.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;

        // TODO check Q problem.
        String[] MENU_POINTERS_BY_DEFAULT = {"a", "b", "c", "i"};
        String[] MENU_ITEMS_BY_DEFAULT = {"New game", "Load game", "Game log", "Quit"};

        //Entities
        HashMap<String, String> menu = new HashMap<>();
        // if user created an account it go to the ArrayList
        ArrayList<Account> usersDB = new ArrayList<>();


        Utils.fillMenuItems(MENU_ITEMS_BY_DEFAULT, MENU_POINTERS_BY_DEFAULT, menu);


        while (isRunning) {
            Utils.showMenuItems(menu);

            String menuPointer = scanner.nextLine();

            switch (menuPointer) {
                case "a":
                    newGame();
//                    If user starts a new game -> "Create account" or "Log in"

//                      "Create account" => register. Email with @ and .
//                       . should be after @
//                         email length and special symbols: [!,$,%,&] ... etc.
//                         password length and special symbols: [!,$,%,&] ... etc.
//                          Name shouldn't have spaces

//                      "Log in"
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
