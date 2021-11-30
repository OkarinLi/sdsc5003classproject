package com.cityu.sdsc5003classproject.dao;

import com.cityu.sdsc5003classproject.entity.User;

import java.util.List;
public interface UserDao {
    //注册
    int insertUser(User user);
    //根据用户名和密码查询
    User search(User user);
    User getUserById(int id);

    int updateUser(User user);
}
