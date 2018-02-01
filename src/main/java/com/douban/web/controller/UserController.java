package com.douban.web.controller;

import com.douban.annotation.Email;
import com.douban.annotation.Mobile;
import com.douban.bean.User;
import com.douban.service.UserService;
import com.douban.web.support.Result;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ruikai.lin  on 2018/1/30 下午2:18.
 * Email: ruikai.lin@plusx.cn
 * Copyright (c) 2014 承影互联(科技)有限公司 版权所有
 */
@Validated
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping(path = "user/{id}")
    public Result get(@ApiParam(name = "id",value = "用户ID")@PathVariable Integer id){
        User user = userService.getById(id);
        logger.info("user:{}",user);
        return Result.success(user);
    }

    @GetMapping(path = "mobile")
    public Result mobile(@ApiParam(name = "mobile",value = "手机号")@Mobile @RequestParam String mobile){
        logger.info("手机号：{}",mobile);
        return Result.success(mobile);
    }
    @GetMapping(path = "email")
    public Result email(@ApiParam(name = "email",value = "邮箱")@Email @RequestParam String email){
        logger.info("邮箱：{}",email);
        return Result.success(email);
    }
}
