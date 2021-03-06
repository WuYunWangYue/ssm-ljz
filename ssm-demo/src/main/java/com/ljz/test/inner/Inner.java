package com.ljz.test.inner;

public class Inner {
    private int num = 3;

    class Limian {
        public void show() {
            //内部类可以访问外部类的私有变量
            System.out.println(num);
        }
    }

    //局部内部类
    public void method() {

        int num2 = 44;
        class JuIn {
            public void zhanshi() {
                System.out.print(num2);
            }
        }
        System.out.println("访问局部变量" + num2);
        //在局部创建内部类对象
        JuIn ji = new JuIn();
        ji.zhanshi();
    }
}

class StaticTest {
    private static int num1 = 4;

    //内部类用静态变量修饰
    public static class Test {
        public static void show() {
            //静态内部类访问外部变量必须用static修饰
            System.out.println(num1);
        }
    }
}

class InnerDemo {
    public static void main(String[] args) {
        //非静态内部类创建方法
        Inner.Limian l = new Inner().new Limian();
        l.show();

        //静态内部类创建方式
        StaticTest.Test t = new StaticTest.Test();
        //调用方法一
        t.show();
        //调用方法二
        StaticTest.Test.show();

        //局部内部类的方法调用
        Inner i = new Inner();
        i.method();
    }
}