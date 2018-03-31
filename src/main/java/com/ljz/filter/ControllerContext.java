package com.ljz.filter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:说明
 * @Author:xgchen
 * @Date:2016-01-15 10:09
 * @Version:V0.0.1
 */
public class ControllerContext {

    private static final ThreadLocal<ControllerContext> ctx = new ThreadLocal<ControllerContext>();

    private static final String CONTEXT_HTTP_REQUEST = "javax.servlet.http.HttpServletRequest";
    private static final String CONTEXT_HTTP_RESPONSE = "javax.servlet.http.HttpServletResponse";
    private static final String SERVLET_CONTEXT = "javax.servlet.ServletContext";

    private Map<String, Object> ctxMap = new HashMap<String, Object>(3);
    private Map<String, Object> valueStack;

    public static ControllerContext getInstance(HttpServletRequest req, HttpServletResponse resq, ServletContext servletContext) {
        return getInstance(req, resq, servletContext, true);
    }

    public static ControllerContext getInstance(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext, boolean newInstance) {
        ControllerContext context = ctx.get();
        if (context == null && newInstance) {
            context = new ControllerContext();
            initContext(request, response, servletContext, context);
            ctx.set(context);
            setGlobalSetting(request);
        }
        return context;
    }

    public static void remove() {
        ctx.remove();
    }

    private static void initContext(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext, ControllerContext context) {
        context.ctxMap.put(CONTEXT_HTTP_REQUEST, request);
        context.ctxMap.put(CONTEXT_HTTP_RESPONSE, response);
        context.ctxMap.put(SERVLET_CONTEXT, servletContext);
    }

    private static void setGlobalSetting(HttpServletRequest request) {
        GlobalSetting globalSetting = GlobalSetting.getInstance();
        request.setAttribute(GlobalSetting.ATTRIBUTE_NAME, globalSetting);
    }

    public HttpSession getSession() {
        return ((HttpServletRequest) ctxMap.get(CONTEXT_HTTP_REQUEST)).getSession();
    }

    public HttpServletRequest getRequest() {
        return (HttpServletRequest) ctxMap.get(CONTEXT_HTTP_REQUEST);
    }

    public HttpServletResponse getResponse() {
        return (HttpServletResponse) ctxMap.get(CONTEXT_HTTP_RESPONSE);
    }

    public ServletContext getApplication() {
        return (ServletContext) ctxMap.get(SERVLET_CONTEXT);
    }

    public static ControllerContext getContext() {
        return ctx.get();
    }

    public void put(String key, Object value) {
        if (valueStack == null) {
            valueStack = new HashMap<String, Object>();
        }
        valueStack.put(key, value);
    }

    public Object get(String key) {
        return valueStack.get(key);
    }

}
