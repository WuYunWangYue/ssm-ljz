package com.ljz.design_mode.abstract_factory_pattern;

public class Square implements Shape {

   @Override
   public void draw() {
      System.out.println("Inside Square::draw() method.");
   }
}