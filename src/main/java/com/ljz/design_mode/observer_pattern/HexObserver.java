package com.ljz.design_mode.observer_pattern;

//十六进制
public class HexObserver extends Observer {

    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        String str = Integer.toHexString(subject.getState()).toUpperCase();
        System.out.println("Hex String : " + str);
    }
}