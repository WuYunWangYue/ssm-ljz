package com.ljz.test.design_mode.decorator_pattern.hero;

//ConcreteComponent 具体组件 以英雄盲僧为例
public class BlindMonk implements Hero {

    private String name;

    public BlindMonk(String name) {
        this.name = name;
    }

    public void learnSkills() {
        System.out.println(name + "学习了以上技能!");

    }
}
