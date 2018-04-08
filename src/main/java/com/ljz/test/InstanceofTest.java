package com.ljz.test;

public class InstanceofTest {
    public static void testInstanceof(Object x) {
        System.out.println("x instanceof Parent:  " + (x instanceof Parent));
        System.out.println("x instanceof Child:  " + (x instanceof Child));
        System.out.println("x getClass Parent:  " + (x.getClass() == Parent.class));
        System.out.println("x getClass Child:  " + (x.getClass() == Child.class));
    }

    public static void main(String[] args) {
        testInstanceof(new Parent());
        System.out.println("---------------------------");
        testInstanceof(new Child());
    }
}

class Parent {

}

class Child extends Parent {

}

/*
输出:
x instanceof Parent:  true
x instanceof Child:  false
x getClass Parent:  true
x getClass Child:  false
---------------------------
x instanceof Parent:  true
x instanceof Child:  true
x getClass Parent:  false
x getClass Child:  true
*/