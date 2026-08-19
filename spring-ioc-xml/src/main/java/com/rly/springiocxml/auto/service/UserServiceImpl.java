package com.rly.springiocxml.auto.service;

import com.rly.springiocxml.auto.dao.UserDao;
import com.rly.springiocxml.auto.dao.UserDaoImpl;

public class UserServiceImpl implements UserService
{

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUserService() {
        System.out.println("userService方法执行");
        userDao.addUserDao();
//        UserDao userDao = new UserDaoImpl();
//        userDao.addUserDao();
    }
}
