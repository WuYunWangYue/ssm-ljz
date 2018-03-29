package com.ljz.design_mode.decorator_pattern.hero;

public class Skill_R extends Skills {

    private String skillName;

    public Skill_R(Hero hero, String skillName) {
        super(hero);
        this.skillName = skillName;
    }

    @Override
    public void learnSkills() {
        System.out.println("学习了技能R : " + skillName);
        super.learnSkills();
    }
}