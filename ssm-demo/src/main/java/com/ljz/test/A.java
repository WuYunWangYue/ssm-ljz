package com.ljz.test;

public class A {
    private B b = new B();
    {
        System.out.println("初始代码块");
    }
    
    A() {
        System.out.println("A类构造器");
    }
}
