package com.ljz.test;

public class B {
    private static String str;
    {
        System.out.println("非静态字段1");

    }

    static {
        System.out.println("静态字段");

    }
    B() {
        System.out.println("非静态字段2");
    }
}
