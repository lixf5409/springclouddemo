package com.example.springcloud.hystrixclient.controller;

import com.example.springcloud.hystrixclient.viewobjects.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author lixiaofeng
 * @date 2019/11/20
 */
@Component
public class UserRemoteClientFallBack implements UserRemoteClient {
    @Override
    public String hello() {
        return "hello failed";
    }

    @Override
    public User getUser() {
        return new User();
    }

    @Override
    public void addUser(User user) {
        System.out.println("addUser failed");
    }
}
