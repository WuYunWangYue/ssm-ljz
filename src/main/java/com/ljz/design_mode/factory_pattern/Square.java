package com.ljz.design_mode.factory_pattern;

//正方形
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
