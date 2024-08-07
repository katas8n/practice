package com.fight.Fighter;

import com.fight.Skill.OuterSkill;
import com.fight.Weapon.Weapon;

// TODO : wide opportunity of Wizard
public class Wizard<T,Y> extends Paladin{
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
    public void damage() {
        System.out.println("hero damaged ... by ...");
    }

    public void consumeDamage() {
        System.out.println("here was damaged ... by ...");
    };
}
