package com.xx.cloud.controller;

import com.xx.cloud.body.User;
import com.xx.cloud.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Dubbo调用
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Reference(version = "1.0")
    private UserService userService;

    @GetMapping("/get")
    public User get(Long id){
        System.out.println(111);
        return userService.get(id);
    }

    @GetMapping("/add")
    public Integer add(User user){
        return userService.add(user);
    }



}
