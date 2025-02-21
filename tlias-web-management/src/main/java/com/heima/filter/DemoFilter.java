package com.heima.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*") //配置过滤器要拦截的请求路径（ /* 表示拦截浏览器的所有请求 ）
@Slf4j
public class DemoFilter implements Filter {

    //初始化方法, web服务器启动, 创建Filter实例时调用, 只调用一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init ...");
    }
    //拦截到请求时,调用该方法,可以调用多次
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截到了请求...");
        filterChain.doFilter(servletRequest, servletResponse);
    }
    //销毁方法, web服务器关闭时调用, 只调用一次
    @Override
    public void destroy() {
        System.out.println("destroy ... ");
    }
}
