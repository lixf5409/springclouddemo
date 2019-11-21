package com.example.springcloud.hystrixclient.controller;

import com.example.springcloud.hystrixclient.viewobjects.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lixiaofeng
 * @date 2019/11/20
 */
@RestController
public class HystrixClientController {
    @Autowired
    private UserRemoteClient userRemoteClient;

    @GetMapping("/hystrix/callHello")
//    @HystrixCommand(fallbackMethod = "failCallHello")
    public String callHello() {
        String result = userRemoteClient.hello();
        System.out.println("调用结果：" + result);
        return result;
    }
    public String failCallHello(){
        return "callHello failed";
    }
    @GetMapping("/hystrix/getUser")
    public User getUser(){
        User user = userRemoteClient.getUser();;
        System.out.println(user);
        return user;
    }
    @PostMapping("hystrix/addUser")
    public void addUser(){
        User user = new User();
        user.setUserId(1);
        user.setUserName("lixf");
        userRemoteClient.addUser(user);
    }
}
