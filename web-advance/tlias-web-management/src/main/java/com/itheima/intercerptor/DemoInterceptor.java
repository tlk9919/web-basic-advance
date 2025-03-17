package com.itheima.intercerptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Slf4j
@Component
public class DemoInterceptor implements HandlerInterceptor {
    //目标资源方法执行前执行 返回值为true放行，false拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("interceptor preHandle。。。。。");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    //目标资源方法执行后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("interceptor postHandle。。。。。");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    //资源方法执行后，视图渲染完毕后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("interceptor afterCompletion。。。。。");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
