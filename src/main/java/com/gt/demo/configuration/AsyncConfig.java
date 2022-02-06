package com.gt.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {
    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // Min number of workers to keep alive
        executor.setCorePoolSize(7);
        // Max number of threads that can ever be created
        executor.setMaxPoolSize(42);
        // Max number of requests before it scales
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("gt-threadPoolTaskExecutor-");
        executor.initialize();
        return executor;
    }
}
