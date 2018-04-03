package com.ljz.test;

import com.ljz.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
    	ApplicationContext context =
    	  new ClassPathXmlApplicationContext(new String[] {"spring-mybatis.xml"});

    	Person person = (Person)context.getBean("PersonBean");

    	System.out.println("=====================================");


    	System.out.println("userName = " + person.getUserName());
    	System.out.println("password = " + person.getPassword());
    	System.out.println("age = " + person.getAge());
    	System.out.println("person = " + person);

    }
}