package com.ljz.test.design_mode.strategy_pattern;

public class OperationSubtract implements Strategy{
   @Override
   public int doOperation(int num1, int num2) {
      return num1 - num2;
   }
}