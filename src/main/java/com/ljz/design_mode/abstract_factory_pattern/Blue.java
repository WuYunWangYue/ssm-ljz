package com.ljz.design_mode.abstract_factory_pattern;

public class Blue implements Color {

   @Override
   public void fill() {
      System.out.println("Inside Blue::fill() method.");
   }
}