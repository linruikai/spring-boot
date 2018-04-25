package com.douban.web.controller;

import com.douban.bean.User;
import com.douban.service.UserService;
import com.douban.web.support.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by ruikai.lin  on 2018/2/2 下午2:48.
 * Email: ruikai.lin@plusx.cn
 * Copyright (c) 2014 承影互联(科技)有限公司 版权所有
 */
@RestController
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private UserService userService;

    @PostMapping("insert")
    public Result insert(){
            User user = new User();
            user.setGender(0);
            user.setName("ceshi");
            user.setPassword("123");
            userService.insert(user);
            return Result.success();
        }
}
