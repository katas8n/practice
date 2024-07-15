package com.fight;

import com.fight.Account.Account;
import com.fight.Fighter.Fighter;
import com.fight.Fighter.FighterClass;
import com.fight.Fighter.Paladin;
import com.fight.Skill.OuterSkill;
import com.fight.Weapon.Weapon;
import com.fight.utils.Utils;

import java.util.*;

public class Main {
    public  static  Account currentUser;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;

        // TODO check Q problem.
        String[] MENU_POINTERS_BY_DEFAULT = {"a", "b", "c", "i"};
        String[] MENU_ITEMS_BY_DEFAULT = {"New game", "Load game", "Game log", "Quit"};
        ArrayList<Fighter> HEROES_BY_DEFUALT = new ArrayList<>();

        HEROES_BY_DEFUALT.add(new Paladin("Paladin1", FighterClass.PALADIN.name(), new OuterSkill[]{new OuterSkill("Booom"), new OuterSkill("Baaaam")}, new Weapon(), 23, 13, 27, 23));

        //Entities
        HashMap<String, String> menu = new HashMap<>();
        // if user created an account it go to the ArrayList
        //Users
        HashMap<String, Account> usersDB = new HashMap<>();

        usersDB.put("j@i.ua", new Account("John", "j@i.ua", "2323"));
        usersDB.put("jim@i.ua", new Account("Jim", "jim@i.ua", "2323"));

        Utils.fillMenuItems(MENU_ITEMS_BY_DEFAULT, MENU_POINTERS_BY_DEFAULT, menu);

        //


        while (isRunning) {
            Utils.showMenuItems(menu);

            String menuPointer = scanner.nextLine();

            switch (menuPointer) {
                case "a":
                    if(currentUser == null){
                        System.out.println("Do you have an account? Y/N");
                        String hasAccount = scanner.nextLine();


                        String name = scanner.nextLine();
                        String email = scanner.nextLine();
                        String password = scanner.nextLine();

                        if(!hasAuthorized(hasAccount)) {
                            createAccount(name, email, password, usersDB);
                            Account createdAccount = getUsersData(email, password, usersDB);

                            currentUser = createdAccount;
                            System.out.println(currentUser.toString());
                        }

                        Account account = getUsersData(email, password, usersDB);
                        System.out.println(account.toString());
                    }


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
        Scanner scanner = new Scanner(System.in);
        // 1. Ask user to create a hero or pick of existing (Create some amount of heroes)
        // 2. Log hero which user picked  (Override .toString of heroes )
        // 3. Create array of enemies with some heroes
        // 4. In the start of a game we should have random enemy of enemies
        // 5. Create method if it not exists provideDamage/consumeDamage
        // 6. Who will make a punch first you should decide using Random

        System.out.println("Would u like to create a hero or pick of existing?");
        String choose = scanner.nextLine();
    }

    public static void loadGame() {
        System.out.println("New loadGame");

    }
    public static void createAccount(String name, String email, String password, HashMap usersDB) {
        usersDB.put(email ,new Account(name, email, password));
    }

    public static boolean hasAuthorized(String hasAuthorized) {
        switch (hasAuthorized.toUpperCase().trim()) {
            case "Y" :
                return true;
            default:
                return false;
        }
    }

    public static Account getUsersData(String email,String password, HashMap usersDB) {
        return (Account) usersDB.get(email);
    }

    public static void gameLog() {
        System.out.println("Game log");
    }
    public static boolean quit() {
        return false;
    }
}
