package com.ljz.test.inner;

import lombok.Getter;
import lombok.Setter;

public class OuterClass {

    private String outerName = "I am outer class";
    private int outerAge = 90;

    @Getter
    @Setter
    public class InnerClass {
        private String innerName;
        private int innerAge;

        InnerClass() {
            //内部类可以访问外部类的元素
            this.innerName = outerName;
            this.innerAge = outerAge;
        }

        public void display() {
            System.out.println("inner display : " + innerName + " and my age is " + innerAge);
        }

        public void innerInvokingOuterDisplay() {
//            在java中，我们可以通过OuterClass.this来获得外部类的引用
            System.out.println("内部类 引用 外部类 的方法");
            OuterClass.this.display();
        }
    }

    public void display() {
        System.out.println("outer display : " + outerName + " and my age is " + outerAge);
    }

    public void outerInvokingInnerDisplay() {
        InnerClass innerClass = new InnerClass();
        System.out.println("外部类 引用 内部类 的方法");
        innerClass.display();
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.outerInvokingInnerDisplay();
//        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        OuterClass.InnerClass innerClass = new OuterClass().new InnerClass();

        innerClass.display();
        innerClass.innerInvokingOuterDisplay();

    }
}