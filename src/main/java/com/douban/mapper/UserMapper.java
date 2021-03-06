package com.douban.mapper;

import com.douban.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by ruikai.lin  on 2018/1/30 下午2:20.
 * Email: ruikai.lin@plusx.cn
 * Copyright (c) 2014 承影互联(科技)有限公司 版权所有
 */
public interface UserMapper{

    User getById(Integer id);

    void insert(User user);


    @Select("select * from user")
    List<User> getAll();
}
