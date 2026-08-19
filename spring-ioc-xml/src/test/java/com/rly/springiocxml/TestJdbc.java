package com.rly.springiocxml;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJdbc {

    @Test
    public void demo1(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/springdemo?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("Rly1820350621@");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        System.out.println(dataSource);
    }

    @Test
    public void demo2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-jdbc.xml");

        DruidDataSource dataSource = (DruidDataSource) context.getBean("dataSource");

        System.out.println(dataSource.getUrl());
    }
}
