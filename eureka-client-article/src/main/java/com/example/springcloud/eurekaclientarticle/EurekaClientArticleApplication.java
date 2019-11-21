package com.example.springcloud.eurekaclientarticle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author lixiaofeng
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientArticleApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientArticleApplication.class, args);
    }

}
