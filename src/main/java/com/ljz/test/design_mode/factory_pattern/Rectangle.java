package com.ljz.test.design_mode.factory_pattern;

//长方形
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
