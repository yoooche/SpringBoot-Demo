package com.yoooche.SpringBootDemo.service;

import com.yoooche.SpringBootDemo.dto.UserRegisterRequest;
import com.yoooche.SpringBootDemo.model.User;

public interface UserService {
    User getUserById(Integer userId);
    Integer register(UserRegisterRequest userRegisterRequest);
}
