package com.rly.springreflect.proxy;

public class UserServiceImpl implements UserService{
    @Override
    public void save(String name) {
        System.out.println("用户为"+name);
    }
}
