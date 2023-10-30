package com.yoooche.SpringBootDemo.service.impl;

import com.yoooche.SpringBootDemo.dao.UserDao;
import com.yoooche.SpringBootDemo.dto.UserRegisterRequest;
import com.yoooche.SpringBootDemo.model.User;
import com.yoooche.SpringBootDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }

}
