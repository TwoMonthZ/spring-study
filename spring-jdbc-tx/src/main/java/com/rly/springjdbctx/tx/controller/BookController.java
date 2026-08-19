package com.rly.springjdbctx.tx.controller;

import com.rly.springjdbctx.tx.service.BookService;
import com.rly.springjdbctx.tx.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CheckoutService checkoutService;

    //买书的方法：图书id和用户id
    public void buyBook(Integer bookId, Integer userId){
        bookService.buyBook(bookId, userId);
    }

    public void checkout(Integer[] bookIds, Integer userId){
        checkoutService.checkout(bookIds, userId);
    }
}
