package com.ljz.test.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class FilterTest implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    /**

    <filter>
        <filter-name>FilterTest</filter-name>
        <filter-class>com.ljz.test.filter.FilterTest</filter-class>
        <init-param>
            <description>FilterTest</description>
            <param-name>ljz</param-name>
            <param-value>123</param-value>
        </init-param>
        <init-param>
            <description>配置FilterTest过滤器的初始化参数</description>
            <param-name>like</param-name>
            <param-value>java</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>FilterTest</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

    */
        System.out.println("---- Filter初始化 ----");
        // 得到过滤器的名字
        System.out.println("---- getFilterName ---- " + filterConfig.getFilterName());
        // 得到在web.xml文件中配置的初始化参数
        System.out.println("---- getInitParameter 1 ---- " + filterConfig.getInitParameter("ljz"));
        System.out.println("---- getInitParameter 2 ---- " + filterConfig.getInitParameter("like"));
        // 返回过滤器的所有初始化参数的名字的枚举集合
        Enumeration<String> initParameterNames  = filterConfig.getInitParameterNames();
        int i = 0;
        while (initParameterNames.hasMoreElements()) {
            String paramName = (String) initParameterNames.nextElement();
            i++;
            System.out.println("---- getInitParameterNames "+ i + " ---- " + paramName );
        }
        System.out.println("---- getServletContext ---- " + filterConfig.getServletContext());

        System.out.println("----------------------------------------------------------------");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("---- 调用service之前执行一段代码 ----");
        chain.doFilter(request, response); // 执行目标资源，放行
        System.out.println("---- 调用service之后执行一段代码 ----");
    }

    @Override
    public void destroy() {
        System.out.println("---- Filter销毁 ----");
    }
}
