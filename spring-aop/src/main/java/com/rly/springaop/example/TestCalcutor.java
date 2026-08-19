package com.rly.springaop.example;

import com.rly.springaop.example.impl.CalcutorImpl;

public class TestCalcutor {
    static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new CalcutorImpl());
        Calcutor proxy = (Calcutor) proxyFactory.getProxy();
        proxy.add(1, 2);
        proxy.mul(1, 2);
    }
}
