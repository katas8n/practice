package com.fight.Fighter;

import com.fight.Weapon.Weapon;

import java.util.ArrayList;

public abstract class Fighter<T, Y> implements IFighter {
        private String name;
        private String fighterClass;

        private ArrayList<T> skills;
        private Weapon weapon;
        private int HP;

        private Y agility;
        private Y strength;
        private Y intelligence;

        private Y damage;

    public Fighter(
            String name,
            String fighterClass,
            ArrayList<T> skills,
            Weapon weapon,
            Y agility,
            Y strength,
            Y intelligence,
            Y damage
    ) {
        this.name = name;
        this.fighterClass = fighterClass;
        this.skills = skills;
        this.weapon = weapon;
        this.agility = agility;
        this.strength = strength;
        this.intelligence = intelligence;
        this.damage = damage;
        this.HP = 100;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<T> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<T> skills) {
        this.skills = skills;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getFighterClass() {
        return fighterClass;
    }

    public void setFighterClass(String fighterClass) {
        this.fighterClass = fighterClass;
    }

    public Y getDamage() {
        return damage;
    }

    public <T> void printSkills(T[] skills) {
        for (T skill : skills) {
            System.out.println("[SKILL]: " + skill);
        }
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setDamage(Y damage) {
        this.damage = damage;
    }

    public void consumeDamage(int enemyDamage) {
        setHP(enemyDamage - getHP());
    }

    public void setAgility(Y agility) {
        this.agility = agility;
    }

    public Y getAgility() {
        return agility;
    }
    public void setStrength(Y strength) {
        this.strength = strength;
    }

    public Y getStrength() {
        return strength;
    }
    public void setIntelligence(Y intelligence) {
        this.intelligence = intelligence;
    }

    public Y getIntelligence() {
        return intelligence;
    }
}
