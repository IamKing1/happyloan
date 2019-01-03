package com.group8.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * className:AsyncConfig
 * discriptoin:多线程执行
 * 在传统的Spring项目中，
 * 我们可以在xml配置文件添加task的配置，
 * 而在SpringBoot项目中一般使用config配置类的方式添加配置，
 * 所以新建一个AsyncConfig类
 * author:丁启斌
 * createTime:2018-12-25 18:23
 */
@Configuration
@EnableAsync
public class AsyncConfig {

    /*
 5 此处成员变量应该使用@Value从配置中读取
 6 */
  private int corePoolSize = 10;
  private int maxPoolSize = 200;
  private int queueCapacity = 10;
     @Bean(value = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
         executor.setCorePoolSize(corePoolSize);
         executor.setMaxPoolSize(maxPoolSize);
         executor.setQueueCapacity(queueCapacity);
         executor.initialize();
     return executor;
 }
}
