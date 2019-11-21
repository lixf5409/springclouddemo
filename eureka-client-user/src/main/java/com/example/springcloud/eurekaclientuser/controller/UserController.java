package com.example.springcloud.eurekaclientuser.controller;

import com.example.springcloud.eurekaclientuser.viewobjects.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author lixiaofeng
 */
@RestController
public class UserController {
    @Value("${server.port}")
    private String port;
    @GetMapping("/user/hello")
    public String hello() {
        return "hello on port " +port;
    }
    @GetMapping("/user/getUser")
    public User getUser(){
        User user = new User();
        user.setUserId(1);
        user.setUserName("lixf");
        return user;
    }
    @PostMapping("user/addUser")
    public void addUser(@RequestBody User user){
        System.out.println(user);
    }
}
