package com.douban.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.douban.annotation.Email;
import com.douban.annotation.Login;
import com.douban.annotation.Mobile;
import com.douban.bean.User;
import com.douban.service.UserService;
import com.douban.util.common.AsyncTask;
import com.douban.web.support.Result;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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

    @Autowired
    private AsyncTask asyncTask;


    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping(path = "user/{id}")
    public Result get(@ApiParam(name = "id", value = "用户ID") @PathVariable Integer id) {
        User user = userService.getById(id);
        logger.info("user:{}", user);
        return Result.success(user);
    }

    @ApiOperation("测试pagehelper")
    @GetMapping("all")
    public Result all(@ApiParam(name = "pageNum",value = "当前页") @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                      @ApiParam(name = "pageSize",value = "每页数") @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        PageInfo<User> users = userService.getAll(pageNum,pageSize);
        return Result.success(users);
    }


    @GetMapping(path = "mobile")
    @Login
    public Result mobile(@ApiParam(name = "mobile", value = "手机号") @Mobile @RequestParam String mobile) {
        logger.info("手机号：{}", mobile);
        JSONObject json = new JSONObject();
        json.put("mobile",mobile);
        return Result.success();
    }

    @GetMapping(path = "email")
    public Result email(@ApiParam(name = "email", value = "邮箱") @Email @RequestParam String email) {
        logger.info("邮箱：{}", email);
        return Result.success(email);
    }

    @PostMapping("email")
    public Result sendEmail(){
        String content = "我的邮件";
        String subject = "测试邮件";
        String[] senders = {"ruikai.lin@plusx.cn", "ruikai.lin@qiezipai.cn"};
        asyncTask.sendEmail(subject,content,senders);
        return Result.success();
    }
}
