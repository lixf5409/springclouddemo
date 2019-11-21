package com.example.springcloud.feignclient.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author lixiaofeng
 * @date 2019/11/20
 */
@Configuration
public class FeignConfiguration {
    /**
     *日志级别
     *@return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}