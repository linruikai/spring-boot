package com.douban.web.controller;

import com.douban.bean.User;
import com.douban.service.UserService;
import com.douban.web.support.Result;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ruikai.lin  on 2018/1/30 下午2:18.
 * Email: ruikai.lin@plusx.cn
 * Copyright (c) 2014 承影互联(科技)有限公司 版权所有
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @GetMapping(path = "user/{id}")
    public Result get(@ApiParam(name = "id",value = "用户ID")@PathVariable Integer id){
        User user = userService.getById(id);
        logger.info("user:{}",user);
        return Result.success(user);
    }
}
