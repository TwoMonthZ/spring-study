package com.rly.springaop.example.impl;

import com.rly.springaop.example.Calcutor;

public class CalculatorStaticProxy implements Calcutor {

    //被代理目标对象传递过来
    private Calcutor calcutor;

    public CalculatorStaticProxy(Calcutor calcutor) {
        this.calcutor = calcutor;
    }

    @Override
    public int add(int a, int b) {

        //静态代理
        int addResult = calcutor.add(a, b);
        return addResult;
    }

    @Override
    public int sub(int a, int b) {
        return 0;
    }

    @Override
    public int mul(int a, int b) {
        return 0;
    }

    @Override
    public int div(int a, int b) {
        return 0;
    }
}
