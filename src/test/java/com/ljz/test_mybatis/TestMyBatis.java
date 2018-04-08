package com.ljz.test_mybatis;

import com.ljz.controller.UserController;
import com.ljz.controller.vo.UserRequestVO;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.ljz.model.User;
import com.ljz.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestMyBatis {
    private static Logger logger = Logger.getLogger(TestMyBatis.class);
    //  private ApplicationContext ac = null;
    @Autowired
    private IUserService userService = null;
    @Autowired
    private UserController userController;

//  @Before  
//  public void before() {  
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");  
//      userService = (IUserService) ac.getBean("userService");  
//  }  

    @Test
    public void test1() {
        User user = userService.getUserById(2);
        // System.out.println(user.getUserName());  
        // logger.info("值："+user.getUserName());  
        logger.info(JSON.toJSONString(user));
    }

    @Test
    public void test2() {
        UserRequestVO vo = new UserRequestVO();
        vo.setUserName("ljz");
        vo.setPassword("123456");
        vo.setAge(29);
        userController.create(vo);
        System.out.println("结果是: " + userController.create(vo));
        System.out.println("结果是: " + userController.getUserInJson2("5"));
    }

}