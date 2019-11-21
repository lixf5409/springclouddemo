package com.example.springcloud.feignclient.controller;

import com.example.springcloud.feignclient.viewobjects.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lixiaofeng
 * @date 2019/11/20
 */
@RestController
public class FeignClientController {
    @Autowired
    private UserRemoteClient userRemoteClient;

    @GetMapping("/feign/callHello")
    public String callHello() {
        String result = userRemoteClient.hello();
        System.out.println("调用结果：" + result);
        return result;
    }
    @GetMapping("/feign/getUser")
    public User getUser(){
        User user = userRemoteClient.getUser();;
        System.out.println(user);
        return user;
    }
    @PostMapping("feign/addUser")
    public void addUser(){
        User user = new User();
        user.setUserId(1);
        user.setUserName("lixf");
        userRemoteClient.addUser(user);
    }
}
