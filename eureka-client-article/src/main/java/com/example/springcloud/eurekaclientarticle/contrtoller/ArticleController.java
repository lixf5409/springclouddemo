package com.example.springcloud.eurekaclientarticle.contrtoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author lixiaofeng
 * @date 2019/11/19
 */
@RestController
public class ArticleController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancer;
    @GetMapping("/article/callHello")
    public String callHello() {
        return
                restTemplate.getForObject( "http://eureka-client-user/user/hello", String.class);
    }
    @GetMapping("/choose")
    public Object chooseUrl() {
        ServiceInstance instance = loadBalancer.choose("eureka-client-user");
        return instance;
    }
}