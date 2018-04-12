package com.ljz.test.design_mode.abstract_factory_pattern;

public abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Shape getShape(String shape) ;
}
