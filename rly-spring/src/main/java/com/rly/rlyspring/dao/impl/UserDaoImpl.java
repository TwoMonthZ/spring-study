package com.rly.rlyspring.dao.impl;

import com.rly.rlyspring.annotation.Bean;
import com.rly.rlyspring.dao.UserDao;


@Bean
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("UserDaoImpl add");
    }
}
