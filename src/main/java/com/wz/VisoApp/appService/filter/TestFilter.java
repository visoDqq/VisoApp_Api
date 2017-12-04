package com.wz.VisoApp.appService.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by chenwuxiong on 2017/12/4.
 */
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
        String s = filterConfig.getInitParameter("myname");
        System.out.println("获取初始化参数myname:"+s);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器开始");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("过滤器结束");
    }

    @Override
    public void destroy() {

    }
}
