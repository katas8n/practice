package com.fight.Fighter;

import com.fight.Skill.OuterSkill;
import com.fight.Weapon.Weapon;

import java.util.ArrayList;
import java.util.Arrays;

public class Paladin<T, Y> extends Fighter {
    public Paladin(
            String name,
            String fighterClass,
            OuterSkill[] skills,
            Weapon weapon,
            Y agility,
            Y strength,
            Y intelligence,
            Y damage
    ) {
        super(
                name,
                fighterClass,
                skills,
                weapon,
                agility,
                strength,
                intelligence,
                damage
        );
    }

    @Override
    public void damage() {
        System.out.printf("Hero %s damaged on %d\n", getName(), (int) getDamage());
    }

    @Override
    public String toString() {
        return "Paladin {" +
                "name='" + getName() + '\'' +
                ", fighterClass='" + getFighterClass() + '\'' +
                ", skills=" + Arrays.toString(getSkills()) +
                ", weapon='" + getWeapon() + '\'' +
                ", HP=" + getHP() +
                ", agility=" + getAgility() +
                ", strength=" + getStrength() +
                ", intelligence=" + getIntelligence() +
                ", damage=" + getDamage() +
                '}';
    }

    @Override
    public void consumeDamage(int enemyDamage) {
        super.consumeDamage(enemyDamage);
        System.out.printf("Hero %s was damaged by %d. Now his HP is:%d\n", getName(), enemyDamage, getHP());
    };

    @Override
    public void displayHP() {

    }
}
