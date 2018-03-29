package com.ljz.design_mode.observer_pattern;

public abstract class Observer {
    protected Subject subject;

    public abstract void update();
}