package com.ljz.design_mode.abstract_factory_pattern;

public class Red implements Color {

   @Override
   public void fill() {
      System.out.println("Inside Red::fill() method.");
   }
}