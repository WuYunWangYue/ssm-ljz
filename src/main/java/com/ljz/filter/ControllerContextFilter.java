package com.ljz.filter;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @Description:说明
 * @Author:xgchen
 * @Date:2016-01-15 9:55
 * @Version:V0.0.1
 */
public class ControllerContextFilter implements Filter {

    private static final Logger log = LogManager.getLogger(ControllerContextFilter.class);

    private ServletContext servletContext;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        servletContext = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            Date begin = new Date();
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse resq = (HttpServletResponse) response;
            ControllerContext.getInstance(req, resq, servletContext);
            chain.doFilter(request, response);
            log.info("request 【" + req.getRequestURI() + "】 from 【" + getIp(req) + "】,响应时间：【" + (System.currentTimeMillis() - begin.getTime()) + "】ms");
        } finally {
            ControllerContext.remove();
        }
    }

    private Object getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }

    @Override
    public void destroy() {
    }
}
