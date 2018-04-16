package com.ljz.test.design_mode.observer_pattern;

//八进制
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        String str = Integer.toOctalString(subject.getState());
        System.out.println("Octal String : " + str);
    }
}