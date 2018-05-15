package com.douban.service.impl;

import com.douban.bean.User;
import com.douban.mapper.UserMapper;
import com.douban.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ruikai.lin  on 2018/1/30 下午2:19.
 * Email: ruikai.lin@plusx.cn
 * Copyright (c) 2014 承影互联(科技)有限公司 版权所有
 */
@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    @Cacheable(value = "user")
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    @Transactional
    @Override
    public void insert(User user) {
            userMapper.insert(user);
            try {
                int i = 1 / 0;
                logger.info("失败");
            }catch (Exception e){
                logger.info("e {}",e);
            }
            logger.info("我跳过了");
    }

    @Override
    public PageInfo<User> getAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> list = userMapper.getAll();
        PageInfo<User> info = new PageInfo<>(list);
        return info;
    }

}
