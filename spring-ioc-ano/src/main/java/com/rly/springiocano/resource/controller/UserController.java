package com.rly.springiocano.resource.controller;

import com.rly.springiocano.resource.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("myUserController")
public class UserController {

    //根据名称进行注入
/*
    @Resource(name = "myUserService")
    private UserService userService;
*/

    //根据类型进行注入
    @Resource
    private UserService userService;

    public void add(){
        System.out.println("controller执行");
        userService.add();
    }


}
