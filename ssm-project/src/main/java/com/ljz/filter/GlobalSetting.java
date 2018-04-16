package com.ljz.filter;

import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * @Description:说明
 * @Author:xgchen
 * @Date:2016-01-15 9:42
 * @Version:V0.0.1
 */
public class GlobalSetting extends HttpServlet {

    private static GlobalSetting instance;

    public static final String ATTRIBUTE_NAME = "site";

    public static String basePath = null;

    private static String scheme = "https";

    private static String port;

    private GlobalSetting(String scheme, String port) {
        this.scheme = scheme;
        this.port = port;
    }


    public static GlobalSetting getInstance() {
        if (instance == null) {
            synchronized (GlobalSetting.class) {
                if (instance == null) {
                    String scheme = StringUtils.isBlank(PropertyUtil.getPropertyByName("req.scheme")) ? "https" : PropertyUtil.getPropertyByName("req.scheme");
                    String port = StringUtils.isNotBlank(PropertyUtil.getPropertyByName("req.port")) ? ":" + obtainPort() : "";
                    instance = new GlobalSetting(scheme, port);
                }
            }
        }
        return instance;
    }

    private GlobalSetting() {
    }

    /**
     * 获取上下文路径
     */
    public String getCtx() {
        if (basePath == null) {
            String path = getContext().getRequest().getContextPath();
            basePath = scheme + "://" + getContext().getRequest().getServerName() + port + path;
        }
        return basePath;
    }

    private static ControllerContext getContext() {
        return ControllerContext.getContext();
    }

    private static int obtainPort() {
        return getContext().getRequest().getServerPort();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
