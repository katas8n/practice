package com.fight.Skill;

import java.util.HashMap;
import java.util.Objects;

public class OuterSkill {
    String skillsName;
    private static int basicDamage = 10;

    public <T> T getHeroesFraction(T fraction) {
        return fraction;
    }

    public OuterSkill(String skillsName) {
        this.skillsName = skillsName;
    }

    @Override
    public String toString() {
        return skillsName;
    }

    class InnerSkill {
        public int fireWall() {
             return basicDamage;
        }
        public int waterArrow() {
            return basicDamage;
        }
        public int windAxe() {
            return basicDamage;
        }
        public int heal() {
            return basicDamage;
        }
    }
}
