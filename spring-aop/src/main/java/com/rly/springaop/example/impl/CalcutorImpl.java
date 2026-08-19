package com.rly.springaop.example.impl;

import com.rly.springaop.example.Calcutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalcutorImpl implements Calcutor {
    //创建Logger对象
    private Logger log = LoggerFactory.getLogger(CalcutorImpl.class);
    @Override
    public int add(int a, int b) {
        int result = a + b;
        log.info("add方法执行了{}和{}",a,b);
        return result;
    }

    @Override
    public int sub(int a, int b) {
        int result = a - b;
        log.info("sub方法执行了{}和{}",a,b);
        return result;


    }

    @Override
    public int mul(int a, int b) {
        int result = a * b;
        log.info("mul方法执行了{}和{}",a,b);
        return result;

    }

    @Override
    public int div(int a, int b) {
        int result = a / b;
        log.info("div方法执行了{}和{}",a,b);
        return result;
    }
}
