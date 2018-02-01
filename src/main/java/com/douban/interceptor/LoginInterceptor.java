package com.douban.interceptor;

import com.douban.annotation.Login;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ruikai.lin  on 2018/1/31 下午6:33.
 * Email: ruikai.lin@plusx.cn
 * Copyright (c) 2014 承影互联(科技)有限公司 版权所有
 */
public class LoginInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String referer = request.getHeader("referer");
        if (StringUtils.isEmpty(referer) && referer.contains("swagger-ui")) {
            //这是swagger测试，直接跳过
            logger.info("swagger test skip");
            return true;
        }
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            //判断方法上是否有该注解
            Login login = handlerMethod.getMethodAnnotation(Login.class);
            if (login == null) {
                //方法上面没有该注解的话，再获取类上面是否有Login注解
                login = handlerMethod.getBeanType().getAnnotation(Login.class);
                if (login == null) {
                    //说明该类上都没有该注解，放行
                    return true;
                }
                //TODO 后期完善具体的登陆业务
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
