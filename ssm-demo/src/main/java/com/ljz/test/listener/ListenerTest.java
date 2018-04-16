package com.ljz.test.listener;

import org.apache.commons.dbcp.BasicDataSource;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ListenerTest implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysqlocalhost:3306/");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("123456");
        basicDataSource.setMaxActive(10);//最大连接数
        basicDataSource.setMaxIdle(5);//最大管理数
        servletContext.setAttribute("dataSource", basicDataSource);
        System.out.println("应用监听器初始化工作完成...");
        System.out.println("已经创建DataSource...");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        servletContext.removeAttribute("dataSource");
        System.out.println("销毁工作完成...");
    }
}
