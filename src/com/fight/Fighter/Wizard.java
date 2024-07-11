package com.fight.Fighter;

import com.fight.Skill.OuterSkill;
import com.fight.Weapon.Weapon;

import java.util.Arrays;

// TODO : wide opportunity of Wizard
public class Wizard<T,Y> extends Paladin {
    private String talent;
    public Wizard(
            String name,
            String fighterClass,
            OuterSkill[] skills,
            Weapon weapon,
            Y agility,
            Y strength,
            Y intelligence,
            Y damage,
            String talent
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
        this.talent = talent;
    }

    @Override
    public String toString() {
        return "Wizard {" +
                "name='" + getName() + '\'' +
                ", fighterClass='" + getFighterClass() + '\'' +
                ", skills=" + Arrays.toString(getSkills()) +
                ", weapon='" + getWeapon() + '\'' +
                ", HP=" + getHP() +
                ", agility=" + getAgility() +
                ", strength=" + getStrength() +
                ", intelligence=" + getIntelligence() +
                ", damage=" + getDamage() +
                ", talent='" + talent + '\'' +
                '}';
    }

    @Override
    public void damage() {
        System.out.printf("Hero %s damaged on %d\n", getName(), (int) getDamage());
    }

//    public void consumeDamage() {
//        System.out.println("here was damaged ... by ...");
//    };
}
