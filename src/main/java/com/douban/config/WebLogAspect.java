package com.douban.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by ruikai.lin  on 2018/5/14 下午6:12.
 * Email: ruikai.lin@plusx.cn
 * Copyright (c) 2014 承影互联(科技)有限公司 版权所有
 */
@Aspect
@Component
public class WebLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public com.douban.web.support.Result com.douban.web.controller.*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void logBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("URL:{}", request.getRequestURL());
        logger.info("HTTP_METHOD:{}", request.getMethod());
        logger.info("IP:{}", request.getRemoteAddr());
        logger.info("ARGS:{}", Arrays.toString(joinPoint.getArgs()));
    }

//    @AfterReturning(returning = "ret", pointcut = "webLog()")
//    public void doAfterReturning(Object ret) {
//        // 处理完请求，返回内容
//        logger.info("RESPONSE : " + ret);
//    }
}
