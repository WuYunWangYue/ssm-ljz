package com.ljz;

import com.ljz.controller.UserController;
import com.ljz.controller.vo.UserRequestVO;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.ljz.model.User;
import com.ljz.service.IUserService;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
@WebAppConfiguration
public class TestMyBatis {
    private static Logger logger = Logger.getLogger(TestMyBatis.class);
    @Autowired
    private IUserService userService;
    @Autowired
    private UserController userController;
    @Mock
    private BindingResult result;

    @Test
    public void test1() {
        User user = userController.getUserInfo("5");
        logger.info(JSON.toJSONString(user));
    }

    @Test
    //添加注解可以防止测试数据对数据库环境有污染
    @Transactional
    @Rollback
    public void test2() {
        Model model = new ExtendedModelMap();
        UserRequestVO vo = new UserRequestVO();
        vo.setUserName("ljz-cs");
        vo.setPassword("12345");
        vo.setAge(130);
        System.out.println("结果是: " + userController.create(vo, result));
        System.out.println("结果是: " + userController.getUserInfoByUserName(vo.getUserName()));
    }

}