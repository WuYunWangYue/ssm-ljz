package com.ljz.test.design_mode.observer_pattern;

//二进制
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        String str = Integer.toBinaryString(subject.getState());
        System.out.println("Binary String : " + str);
    }
}