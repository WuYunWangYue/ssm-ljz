package com.ljz.aop_aspectJ;

import com.ljz.test.aop_aspectJ.ArithmeticCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-mybatis.xml"})
@WebAppConfiguration
public class AOPAspectJTest {
    @Autowired
    ArithmeticCalculator arithmeticCalculator;

    @Test
    public void test() {
        System.out.println(arithmeticCalculator.getClass());

        int result = arithmeticCalculator.add(3, 5);
        System.out.println("result: " + result);

        result = arithmeticCalculator.div(5, 0);
        try {
            System.out.println("result2: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
