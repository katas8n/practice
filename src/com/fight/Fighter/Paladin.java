package com.fight.Fighter;

import com.fight.Weapon.Weapon;

import java.util.ArrayList;

public class Paladin<T, Y> extends Fighter {
    public Paladin(
            String name,
            String fighterClass,
            ArrayList<T> skills,
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
        System.out.println("hero damaged ... by ...");
    }

    public void consumeDamage() {
        System.out.println("here was damaged ... by ...");
    };
}
