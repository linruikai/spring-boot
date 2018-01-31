package com.douban.service;

import com.douban.bean.User;

/**
 * Created by ruikai.lin  on 2018/1/30 下午2:19.
 * Email: ruikai.lin@plusx.cn
 * Copyright (c) 2014 承影互联(科技)有限公司 版权所有
 */
public interface UserService {
    /**
     * 根据ID获取user对象
     * @param id
     * @return
     */
    User getById(Integer id);
}
