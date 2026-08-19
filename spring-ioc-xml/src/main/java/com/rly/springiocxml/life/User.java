package com.rly.springiocxml.life;


public class User {

    //初始化方法
    public void init(){
        System.out.println("4初始化方法");
    }

    //销毁方法
    public void destroy(){
        System.out.println("7销毁方法");
    }

    private String name;

    public User() {
        System.out.println("1无参构造器");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("2给bean对象设置属性值");
        this.name = name;
    }
}
