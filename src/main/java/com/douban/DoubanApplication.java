package com.douban;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
@EnableAsync
@MapperScan("com.douban.mapper")
public class DoubanApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DoubanApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DoubanApplication.class);
    }

    /**
     * 自定义异步线程池
     */
    @Bean
    public AsyncTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("TASK_EXECUTOR");
        int size = Runtime.getRuntime().availableProcessors() + 1;
        executor.setCorePoolSize(size);
        executor.setMaxPoolSize(size * 2);
        executor.setKeepAliveSeconds(3000);
        executor.setQueueCapacity(200);
        // 使用预定义的异常处理类
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}
