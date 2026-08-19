package com.rly.springiocano.autowire.service;

import com.rly.springiocano.autowire.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    //1、autowire属性注入
    @Autowired
    private UserDao userDaoA;

    //2、set方法注入

    private UserDao userDaoB;

    @Autowired
    public void setUserDaoB(UserDao userDaoB) {
        this.userDaoB = userDaoB;
    }

    //3、构造方法注入
    private UserDao userDaoC;

    @Autowired
    public UserServiceImpl(UserDao userDaoC) {
        this.userDaoC = userDaoC;
    }

    @Override
    public void add() {
        System.out.println("service执行");
        userDaoC.add();
    }
}
