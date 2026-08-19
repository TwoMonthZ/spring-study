package com.rly.springiocxml.auto.controller;

import com.rly.springiocxml.auto.service.UserService;
import com.rly.springiocxml.auto.service. UserServiceImpl;

public class UserController {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser(){
        System.out.println("userController方法执行");
        userService.addUserService();
//        UserService userService = new UserServiceImpl();
//        userService.addUserService();
    }
}
