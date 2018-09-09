package com.douban.service.kafka;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

/**
 * Created by ruikai.lin  on 2018/4/23 下午4:22.
 * Email: ruikai.lin@plusx.cn
 * Copyright (c) 2014 承影互联(科技)有限公司 版权所有
 */
@Component
public class Provider {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void send(String topic,String msg){
        kafkaTemplate.send(topic,msg);
        System.out.println("消息发送成功");
    }
}
