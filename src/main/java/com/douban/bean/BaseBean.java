package com.douban.bean;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * Created by ruikai.lin  on 2018/1/30 下午3:56.
 * Description: 实体类继承这个类可以自动实现toString的方法
 */
public class BaseBean implements Serializable {

    private static final long  serialVersionUID = 1L;

    @Override
    public String toString(){
        return ReflectionToStringBuilder.toString(this);
    }
}
