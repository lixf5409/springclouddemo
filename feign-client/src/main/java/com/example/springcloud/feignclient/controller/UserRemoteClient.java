package com.example.springcloud.feignclient.controller;

import com.example.springcloud.feignclient.configuration.FeignConfiguration;
import com.example.springcloud.feignclient.viewobjects.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author lixiaofeng
 * @date 2019/11/20
 */
@FeignClient(value="eureka-client-user",configuration = FeignConfiguration.class)
public interface UserRemoteClient {
    @GetMapping("/user/hello")
    String hello();
    @GetMapping("/user/getUser")
    User getUser();
    @PostMapping("user/addUser")
    void addUser(@RequestBody User user);
}
