package com.fight;

import com.fight.Account.Account;
import com.fight.Fighter.Fighter;
import com.fight.Fighter.FighterClass;
import com.fight.Fighter.Paladin;
import com.fight.Fighter.Wizard;
import com.fight.Log.Log;
import com.fight.Skill.OuterSkill;
import com.fight.Weapon.Weapon;
import com.fight.utils.Utils;

import java.util.*;

public class Main {
    public static  Account currentUser;
    public static List<Fighter> playerClan;
    public static List<Fighter> enemyClan;

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
                        } else {
                            currentUser = getUsersData(email, password, usersDB);
                            System.out.println(currentUser.toString());
                        }
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
        // 1. Ask user to create a hero or pick of existing (Create some amount of heroes)
        // 2. Log hero which user picked  (Override .toString of heroes )
        // 3. Create array of enemies with some heroes
        // 4. In the start of a game we should have random enemy of enemies
        // 5. Create method if it not exists damage/consumeDamage
        // 6. Who will make a punch first you should decide using Random

        // fill clans
        fillClans();

        // select heroes
        Fighter playerHero = chooseUserHero();
        Fighter enemyHero = chooseEnemyHero();

        // Log user hero info
        Log.logUserHero(playerHero.toString());

        // fight
        System.out.println("Start fighting...");
        fight(playerHero, enemyHero);
    }

    public static Fighter chooseUserHero() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Do you want to create [C] or pick [P] a hero?");
            String userChoice = input.nextLine();

            switch (userChoice.toUpperCase().trim()) {
                case "C":
                    return createUserHero(input);
                case "P":
                    return pickUserHero(input);
                default:
                    System.out.println("You've entered wrong data... Please try again!");
                    break;
            }
        }
    }

    private static Fighter createUserHero(Scanner input) {
        OuterSkill[] skills = new OuterSkill[]{new OuterSkill("Kick"), new OuterSkill("Jump")};
        Weapon weapon = new Weapon();
        int agility = 25,
                strength = 15,
                intelligence = 25,
                damage = 25;

        while (true) {
            System.out.print("What hero do you want to create: 1) Paladin 2) Wizard \nEnter 1 or 2: ");
            String userChoice = input.nextLine();
            System.out.print("Enter the name of your hero: ");
            String heroName = input.nextLine();

            switch (userChoice.toUpperCase().trim()) {
                case "1":
                    return new Paladin<OuterSkill,Integer>(heroName, FighterClass.PALADIN.name(), skills, weapon, agility, strength, intelligence, damage);
                case "2":
                    System.out.print("Enter hero's talent: ");
                    String talent = input.nextLine();
                    return new Wizard(heroName, FighterClass.WIZARD.name(), skills, weapon, agility, strength, intelligence, damage, talent);
                default:
                    System.out.println("You've entered wrong data. Please try again!");
                    break;
            }
        }
    }

    private static Fighter pickUserHero(Scanner input) {
        System.out.println("Here is the list of heroes:");
        int listIdx = 1;

        for (Fighter hero : playerClan) {
            System.out.print(listIdx + ") ");
            System.out.println(hero);
            listIdx++;
        }

        int clanSize = playerClan.size();

        while (true) {
            System.out.println("Please select the number");
            int index = Integer.parseInt(input.nextLine());

            if (index < 1 || index > clanSize) {
                System.out.println("You've entered not existing list number!");
                continue;
            }

            return playerClan.get(index - 1);
        }
    }

    public static Fighter chooseEnemyHero() {
        Random random = new Random();
        int idx = random.nextInt(0, enemyClan.size());

        return enemyClan.get(idx);
    }

    public static void fight(Fighter playerHero, Fighter enemyHero) {
        Random random = new Random();
        boolean isPlayerPunch = random.nextInt(0, 2) == 0;
        Fighter heroMakePunch;
        Fighter heroGetPunch;

        while (true) {
            heroMakePunch = isPlayerPunch ? playerHero : enemyHero;
            heroGetPunch = isPlayerPunch ? enemyHero : playerHero;

            heroMakePunch.damage();
            heroGetPunch.consumeDamage((int)heroMakePunch.getDamage());

            if (heroGetPunch.getHP() < 0) {
                System.out.println("Fight is over...");
                System.out.printf("The winner is: %s\n", heroMakePunch.getName());
                return;
            }

            isPlayerPunch = !isPlayerPunch;
        }
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

    public static void fillClans() {
        playerClan = new ArrayList<>(Arrays.asList(
                new Paladin(
                        "PlayerPaladin1",
                        FighterClass.PALADIN.name(),
                        new OuterSkill[]{new OuterSkill("Kick"), new OuterSkill("Jump")},
                        new Weapon(),
                        24,
                        15,
                        28,
                        24
                ),
                new Paladin(
                        "PlayerPaladin2",
                        FighterClass.PALADIN.name(),
                        new OuterSkill[]{new OuterSkill("Kick"), new OuterSkill("Jump"), new OuterSkill("Run")},
                        new Weapon(),
                        20,
                        20,
                        30,
                        26
                ),
                new Wizard(
                        "PlayerWizard1",
                        FighterClass.WIZARD.name(),
                        new OuterSkill[]{new OuterSkill("Kick"), new OuterSkill("Jump"), new OuterSkill("Run")},
                        new Weapon(),
                        30,
                        20,
                        15,
                        30,
                        "Swim"
                )
        ));

        enemyClan = new ArrayList<>(Arrays.asList(
                new Paladin(
                        "EnemyPaladin1",
                        FighterClass.PALADIN.name(),
                        new OuterSkill[]{new OuterSkill("Kick"), new OuterSkill("Jump"), new OuterSkill("Run")},
                        new Weapon(),
                        25,
                        13,
                        28,
                        20
                ),
                new Wizard(
                        "EnemyWizard1",
                        FighterClass.PALADIN.name(),
                        new OuterSkill[]{new OuterSkill("Kick"), new OuterSkill("Jump"), new OuterSkill("Run")},
                        new Weapon(),
                        24,
                        20,
                        24,
                        26,
                        "Run"
                ),
                new Wizard(
                        "EnemyWizard2",
                        FighterClass.WIZARD.name(),
                        new OuterSkill[]{new OuterSkill("Kick"), new OuterSkill("Jump"), new OuterSkill("Swim")},
                        new Weapon(),
                        30,
                        20,
                        15,
                        30,
                        "Swim"
                )
        ));
    }
}
