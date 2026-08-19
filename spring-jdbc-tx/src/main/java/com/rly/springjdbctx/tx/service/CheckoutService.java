package com.rly.springjdbctx.tx.service;

public interface CheckoutService {
    void checkout(Integer[] bookIds, Integer userId);
}
