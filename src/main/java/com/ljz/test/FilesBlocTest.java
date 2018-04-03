package com.ljz.test;

public class FilesBlocTest {
    private static A a = new A();
    static {
        System.out.println("A类的静态代码块");
    }

    public static void main(String[] args) {
        System.out.println("main方法");
    }
//    非静态字段
//    初始代码块
//    A类构造器
//    A类的静态代码块
//    main方法
}
