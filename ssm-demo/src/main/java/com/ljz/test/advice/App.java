package com.ljz.test.advice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext appContext =
                new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        CustomerService customerService =
                (CustomerService) appContext.getBean("customerService");
        System.out.println("====================================================================");
        System.out.println("*************************");
        customerService.printName();
        System.out.println("*************************");
        customerService.printURL();
        System.out.println("*************************");
        try {
            customerService.printThrowException();
        } catch (Exception e) {
        }

        System.out.println("====================================================================");
        System.out.println("之前通知");
        customerService = (CustomerService) appContext.getBean("customerServiceProxy");
        System.out.println("*************************");
        customerService.printName();
        System.out.println("*************************");
        customerService.printURL();
        System.out.println("*************************");
        try {
            customerService.printThrowException();
        } catch (Exception e) {
        }

        System.out.println("====================================================================");
        System.out.println("返回后通知");
        customerService = (CustomerService) appContext.getBean("customerServiceProxy2");
        System.out.println("*************************");
        customerService.printName();
        System.out.println("*************************");
        customerService.printURL();
        System.out.println("*************************");
        try {
            customerService.printThrowException();
        } catch (Exception e) {
        }

        System.out.println("====================================================================");
        System.out.println("抛出后通知");
        customerService = (CustomerService) appContext.getBean("customerServiceProxy3");
        System.out.println("*************************");
        customerService.printName();
        System.out.println("*************************");
        customerService.printURL();
        System.out.println("*************************");
        try {
            customerService.printThrowException();
        } catch (Exception e) {
        }

        System.out.println("====================================================================");
        System.out.println("环绕通知");
        customerService = (CustomerService) appContext.getBean("customerServiceProxy4");
        System.out.println("*************************");
        customerService.printName();
        System.out.println("*************************");
        customerService.printURL();
        System.out.println("*************************");
        try {
            customerService.printThrowException();
        } catch (Exception e) {
        }

    }
}
