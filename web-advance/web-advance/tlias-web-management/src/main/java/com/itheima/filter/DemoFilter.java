package com.itheima.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
//@WebFilter(urlPatterns = "/*")// 拦截所有请求
@Slf4j
public class DemoFilter implements Filter  {
    // 初始化方法，web 容器启动，创建 Filter 对象，调用 init 初始化，只执行一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter init。。。。。");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 拦截到请求，执行过滤操作，执行多次
        log.info("filter doFilter。。。。。");
        // 放行，让请求继续访问目标资源
        filterChain.doFilter(servletRequest, servletResponse);
    }
    // 销毁方法，web 容器销毁 Filter 对象，调用 destroy 销毁，只执行一次
    @Override
    public void destroy() {
        log.info("filter destroy。。。。。");
        Filter.super.destroy();
    }
}
