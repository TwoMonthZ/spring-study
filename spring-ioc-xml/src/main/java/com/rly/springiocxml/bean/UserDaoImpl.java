package com.rly.springiocxml.bean;

public class UserDaoImpl implements UserDao{
    @Override
    public void run() {
        System.out.println("我是重写run方法");
    }
}
