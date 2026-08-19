package com.rly.springiocxml;

import com.rly.springiocxml.di.Book;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestBook {

    @Test
    public void  testSet(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");

        Book book = context.getBean("book", Book.class);

        System.out.println(book);
    }


    @Test
    public void  testCon(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");

        Book book = context.getBean("bookCon", Book.class);

        System.out.println(book);
    }
}
