package com.ljz.test.apo_aspectJ;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        ArithmeticCalculator arithmeticCalculator =
                (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
        System.out.println("========================================================");
        System.out.println(arithmeticCalculator.getClass());

        int result = arithmeticCalculator.add(3, 5);
        System.out.println("result: " + result);

        result = arithmeticCalculator.div(5, 0);
        try {
            System.out.println("result2: " + result);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}