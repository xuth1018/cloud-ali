package com.xx.cloud.service.impl;

import com.xx.cloud.body.User;
import com.xx.cloud.service.UserService;
import org.apache.dubbo.config.annotation.Service;

import java.util.Random;

@Service(protocol = "dubbo",version = "1.0")
public class UserServiceImpl implements UserService {

    @Override
    public User get(Long id) {
        return  new User(id,"xth",2);
    }

    @Override
    public Integer add(User user) {
        return new Random().nextInt()*100;
    }
}
