package com.douban.web.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.ServletException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

/**
 * Created by ruikai.lin  on 2018/1/31 下午2:31.
 * Email: ruikai.lin@plusx.cn
 * Copyright (c) 2014 承影互联(科技)有限公司 版权所有
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = {ValidationException.class, BindException.class,
            TypeMismatchException.class, HttpMessageConversionException.class,
            MethodArgumentNotValidException.class, ServletException.class,
            MethodArgumentTypeMismatchException.class})
    public Result parameterExceptionHandler(WebRequest request, Exception e) {
        logger.warn("无效请求 request={} {}", request, e.toString());
        return Result.fail("无效请求");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Result handleValidationException(ConstraintViolationException e) {
        for (ConstraintViolation<?> s : e.getConstraintViolations()) {
            return Result.fail(s.getMessage());
        }
        return Result.fail("参数格式错误");
    }

    @ExceptionHandler
    public Result handle(Exception e) {
        logger.error("服务器异常", e);
        return Result.fail("服务器错误");
    }
}
