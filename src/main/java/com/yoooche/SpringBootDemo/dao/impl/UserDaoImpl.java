package com.yoooche.SpringBootDemo.dao.impl;

import com.yoooche.SpringBootDemo.dao.UserDao;
import com.yoooche.SpringBootDemo.dto.UserRegisterRequest;
import com.yoooche.SpringBootDemo.model.User;
import com.yoooche.SpringBootDemo.rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Integer createUser(UserRegisterRequest userRegisterRequest){
        String sql = "INSERT INTO user(email, password, created_date, last_modified_date) VALUES( :email, :password, :createdDate, :lastModifiedDate)";

        Map<String, Object> map = new HashMap<>();
        map.put("email", userRegisterRequest.getEmail());
        map.put("password", userRegisterRequest.getPassword());
        Date now = new Date();
        map.put("createdDate", now);
        map.put("lastModifiedDate", now);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public User getUserById(Integer userId) {
        String sql = "SELECT * FROM user WHERE user_id = :userId";
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        List<User> userList = namedParameterJdbcTemplate.query(sql, map, new UserRowMapper());

        if(!userList.isEmpty()){
            return userList.get(0);
        }else {
            return null;
        }
    }


}