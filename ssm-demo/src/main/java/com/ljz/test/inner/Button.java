package com.ljz.test.inner;

public class Button {
    public void click() {
        //匿名内部类，实现的是ActionListener接口
        new ActionListener() {
            public void onAction() {
                System.out.println("click action...");
            }
        }.onAction();
    }

    //匿名内部类必须继承或实现一个已有的接口
    public interface ActionListener {
        void onAction();
    }

    public static void main(String[] args) {
        Button button = new Button();
        button.click();
    }
}