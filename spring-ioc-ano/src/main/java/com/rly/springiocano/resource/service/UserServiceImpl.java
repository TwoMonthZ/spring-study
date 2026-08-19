package com.rly.springiocano.resource.service;

import com.rly.springiocano.resource.dao.UserDao;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "myUserService")
public class UserServiceImpl implements UserService {

    //不指定名称，根据属性名称注入
    @Resource
    private UserDao myUserDao;

    @Override
    public void add() {
        System.out.println("service执行");
        myUserDao.add();
    }
}
