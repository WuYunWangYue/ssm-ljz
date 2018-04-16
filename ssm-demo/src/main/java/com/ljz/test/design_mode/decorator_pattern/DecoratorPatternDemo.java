package com.ljz.test.design_mode.decorator_pattern;

//装饰者模式
public class DecoratorPatternDemo {
    public static void main(String[] args) {

        Shape circle = new Circle();
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("=============================================");

        Shape redCircle = new RedShapeDecorator(new Circle());
        System.out.println("\nCircle of red border");
        redCircle.draw();

//        Shape redRectangle = new RedShapeDecorator(new Rectangle());
//        System.out.println("\nRectangle of red border");
//        redRectangle.draw();
    }
}