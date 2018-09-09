package com.douban.config;

import com.alibaba.fastjson.JSONObject;
import com.douban.web.support.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * Created by ruikai.lin  on 2018/8/7 上午11:50.
 * Email: ruikai.lin@plusx.cn
 * Copyright (c) 2014 承影互联(科技)有限公司 版权所有
 */
@Component
@Aspect
public class AccessAspect {

    private static final Logger logger = LoggerFactory.getLogger("access");


    @Pointcut(value = "execution(public com.douban.web.support.Result com.douban.web.controller.*.*(..))")
    public void accessAspect() {
    }

    @Around("accessAspect()")
    public Result accessAll(ProceedingJoinPoint joinPoint) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

        String uri = request.getRequestURI();
        String host = request.getRemoteHost();
        String ip = request.getRemoteAddr();
        String httpMethod = request.getMethod();
        String userAgent = request.getHeader("user-agent");
        String referer = request.getHeader("Referer");
        LocalDateTime timestamp = LocalDateTime.now();
        JSONObject json = new JSONObject();
        Map<String, String[]> requestParam = request.getParameterMap();
        for (Map.Entry entry : requestParam.entrySet()) {
            json.put(entry.getKey().toString(), entry.getValue());
        }


        int responseCode = response.getStatus();
        int serverPort = request.getLocalPort();
        String serverIp = request.getLocalAddr();


        int resultCode = -1;
        Result result = null;
        long startTime = System.currentTimeMillis();
        try {
            Object obj = joinPoint.proceed();
            result = (Result) obj;
            resultCode = result.getCode();
        } catch (Throwable e) {
            logger.error("统计某方法执行耗时环绕通知出错", e);
        }
        long endTime = System.currentTimeMillis();

//        logger.info("uri:[{}] host:[{}] ip:[{}] httpMethod:[{}] userAgent:[{}] referer:[{}] requestTime:[{}] timestamp:[{}] requestParam:[{}] " +
//                        " accountId:[{}] service:[{}] responseCode:[{}] resultCode:[{}] serverPort:[{}] serverIp:[{}]", uri, host, ip, httpMethod, userAgent, referer,
//                endTime - startTime, timestamp, json, 0, 0, responseCode, resultCode, serverPort, serverIp);
        logger.info("{} {} {} {} {} {} {} {} {} {} {} {} {} {} {}", uri, host, ip, httpMethod, referer,
                endTime - startTime, timestamp,  1000, "app", responseCode, resultCode, serverPort,userAgent, serverIp,json);
        return result;
    }
}
