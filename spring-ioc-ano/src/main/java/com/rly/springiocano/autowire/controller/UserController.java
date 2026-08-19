package com.rly.springiocano.autowire.controller;

import com.rly.springiocano.autowire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    //1、autowire属性注入
    //根据类型找到对应实现类的对象
    @Autowired
    private UserService userServiceA;

    //2、set方法注入
    private UserService userServiceB;

    @Autowired
    public void setUserServiceB(UserService userServiceB) {
        this.userServiceB = userServiceB;
    }

    //3、构造方法注入
    private UserService userServiceC;

    @Autowired
    public UserController(UserService userServiceC) {
        this.userServiceC = userServiceC;
    }


    public void add(){
        System.out.println("controller执行");
        userServiceC.add();
    }


}
