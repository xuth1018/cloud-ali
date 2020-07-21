package com.xx.cloud.service;

import com.xx.cloud.body.User;

public interface UserService {

    User get(Long id);

    Integer add(User user);
}
