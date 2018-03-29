package com.ljz.design_mode.singleton_pattern;

//饿汉式
public class Singleton3 {
    private static Singleton3 instance = new Singleton3();
    private Singleton3() {}
    public static Singleton3 getInstance() {
        return instance;
    }

}
