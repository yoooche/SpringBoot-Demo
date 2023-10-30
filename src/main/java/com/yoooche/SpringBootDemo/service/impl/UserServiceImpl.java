package com.yoooche.SpringBootDemo.service.impl;

import com.yoooche.SpringBootDemo.dao.UserDao;
import com.yoooche.SpringBootDemo.dto.UserRegisterRequest;
import com.yoooche.SpringBootDemo.model.User;
import com.yoooche.SpringBootDemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Access;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());

        // 檢查email是否已被註冊過
        if(user != null){
            log.warn("該 email {} 已被註冊", userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        // email未被註冊 -> 創建帳號
        return userDao.createUser(userRegisterRequest);

    }

}
