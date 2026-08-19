package com.rly.springaop.example.impl;

import com.rly.springaop.example.Calcutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CalcutorLogImpl implements Calcutor {
    //创建Logger对象
    private Logger log = LoggerFactory.getLogger(CalcutorLogImpl.class);
    @Override
    public int add(int a, int b) {
        log.info("add方法开始了{}和{}",a,b);
        int result = a + b;
        log.info("add方法结束了{}和{}",a,b);
        return result;
    }

    @Override
    public int sub(int a, int b) {
        log.info("sub方法开始了{}和{}",a,b);
        int result = a - b;
        log.info("sub方法结束了{}和{}",a,b);
        return result;


    }

    @Override
    public int mul(int a, int b) {
        log.info("mul方法开始了{}和{}",a,b);
        int result = a * b;
        log.info("mul方法结束了{}和{}",a,b);
        return result;

    }

    @Override
    public int div(int a, int b) {
        log.info("div方法开始了{}和{}",a,b);
        int result = a / b;
        log.info("div方法结束了{}和{}",a,b);
        return result;
    }
}
