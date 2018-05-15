package com.douban.config;

import org.springframework.context.annotation.Bean;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by ruikai.lin  on 2018/4/26 下午3:58.
 * Email: ruikai.lin@plusx.cn
 * Copyright (c) 2014 承影互联(科技)有限公司 版权所有
 */
@Component
public class ThreadPool {
    /**
     * 自定义异步线程池
     */
    @Bean
    public AsyncTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("TASK_EXECUTOR");
        int size = Runtime.getRuntime().availableProcessors();
        executor.setCorePoolSize(size + 1);
        executor.setMaxPoolSize(size << 1);
        executor.setKeepAliveSeconds(3000);
        executor.setQueueCapacity(200);
        // 使用预定义的异常处理类
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}
