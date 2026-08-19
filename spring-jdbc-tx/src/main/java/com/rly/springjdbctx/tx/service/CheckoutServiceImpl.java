package com.rly.springjdbctx.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CheckoutServiceImpl implements CheckoutService{

    //注入BookService
    @Autowired
    private BookService bookService;

    @Override
    public void checkout(Integer[] bookIds, Integer userId) {
        for (Integer bookId : bookIds) {
            //调用service买书
            bookService.buyBook(bookId, userId);
        }
    }
}
