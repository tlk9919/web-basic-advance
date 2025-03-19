package com.itheima.filter;

import com.itheima.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*")// 拦截所有请求
@Slf4j
public class TokenFilter implements Filter  {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //1.获取请求路径
        String requestURI = request.getRequestURI();
        //2.判断是否包含指定资源，若包含，则放行
        if (requestURI.contains("login") || requestURI.contains("register")){
            log.info("请求路径中包含login或register，放行");
            filterChain.doFilter(request,response);
            return;
        }

        //3.获取请求头中的令牌数据
        String token = request.getHeader("token");
        //4.判断令牌是否存在，若不存在，则返回401，无权访问
        if (token == null || token.isEmpty()){
            log.info("请求头中无token数据，返回401无权访问");
            response.setStatus(401);
            return;
        }

        //5.如果存在，校验令牌，通过则放行、反之401
        try {
            JwtUtils.parseToken(token);
        } catch (Exception e) {
            log.info("令牌非法");
            response.setStatus(401);
        }
        log.info("令牌合法");
        filterChain.doFilter(request,response);
    }

}
