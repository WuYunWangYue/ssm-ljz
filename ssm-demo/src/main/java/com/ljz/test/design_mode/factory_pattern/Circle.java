package com.ljz.test.design_mode.factory_pattern;

//圆形
public class Circle implements Shape {

   @Override
   public void draw() {
      System.out.println("Inside Circle::draw() method.");
   }
}