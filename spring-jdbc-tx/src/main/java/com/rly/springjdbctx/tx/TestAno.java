package com.rly.springjdbctx.tx;

import com.rly.springjdbctx.tx.config.SpringConfig;
import com.rly.springjdbctx.tx.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAno {

    @Test
    public void testTxAnno(){

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookController bookController = context.getBean("bookController", BookController.class);
        bookController.buyBook(1, 1);
    }
}
