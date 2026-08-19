package com.rly.rlyspring.service.impl;

import com.rly.rlyspring.annotation.Bean;
import com.rly.rlyspring.annotation.Di;
import com.rly.rlyspring.dao.UserDao;
import com.rly.rlyspring.service.UserService;

@Bean
public class UserServiceImpl implements UserService {

    @Di
    private UserDao userDao;


    @Override
    public void add() {
        System.out.println("UserServiceImpl add");
        //调用dao方法
        userDao.add();
    }
}
