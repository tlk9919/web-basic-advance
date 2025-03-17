package com.itheima.intercerptor;

import com.itheima.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    //目标资源方法执行前执行 返回值为true放行，false拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //1.获取请求路径
        String requestURI = request.getRequestURI();
        //2.判断是否包含指定资源，若包含，则放行
        if (requestURI.contains("login") || requestURI.contains("register")){
            log.info("请求路径中包含login或register，放行");

            return true;
        }

        //3.获取请求头中的令牌数据
        String token = request.getHeader("token");
        //4.判断令牌是否存在，若不存在，则返回401，无权访问
        if (token == null || token.isEmpty()){
            log.info("请求头中无token数据，返回401无权访问");
            response.setStatus(401);
            return false;
        }

        //5.如果存在，校验令牌，通过则放行、反之401
        try {
            JwtUtils.parseToken(token);
        } catch (Exception e) {
            log.info("令牌非法");
            response.setStatus(401);
        }
        log.info("令牌合法");
       return true;
    }


}
