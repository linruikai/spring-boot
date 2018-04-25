package com.douban.service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by ruikai.lin  on 2018/4/23 下午4:25.
 * Email: ruikai.lin@plusx.cn
 * Copyright (c) 2014 承影互联(科技)有限公司 版权所有
 */
@Component
public class Consumer {

    @KafkaListener(topics = "topic")
    public void consumer(String msg){
        System.out.println("消费者消费1"+msg);
    }
}
