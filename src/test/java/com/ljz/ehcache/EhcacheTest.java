package com.ljz.ehcache;

import com.ljz.controller.CacheDemoUserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.Model;

import java.util.Collection;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-mybatis.xml"})
@WebAppConfiguration
public class EhcacheTest {
    @Autowired
    private CacheDemoUserController userController;

    @Test
    public void testOne() {
        userController.get("2", getModel());
        userController.update("2", getModel());
    }

    private Model getModel() {
        return new Model() {
            @Override
            public Model addAttribute(String attributeName, Object attributeValue) {
                return null;
            }

            @Override
            public Model addAttribute(Object attributeValue) {
                return null;
            }

            @Override
            public Model addAllAttributes(Collection<?> attributeValues) {
                return null;
            }

            @Override
            public Model addAllAttributes(Map<String, ?> attributes) {
                return null;
            }

            @Override
            public Model mergeAttributes(Map<String, ?> attributes) {
                return null;
            }

            @Override
            public boolean containsAttribute(String attributeName) {
                return false;
            }

            @Override
            public Map<String, Object> asMap() {
                return null;
            }
        };
    }
}
