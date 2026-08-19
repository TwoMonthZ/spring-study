package com.rly.springjdbctx.tx.service;

import com.rly.springjdbctx.tx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookDao bookDao;

    @Override
    @Transactional(noRollbackFor = ArithmeticException.class,propagation = Propagation.REQUIRED)
    public void buyBook(Integer bookId, Integer userId) {
        //根据图书id查询图书价格
        Integer bookPrice = bookDao.getBookPrice(bookId);

        //更新图书表库存量
        bookDao.updateStock(bookId);

        //更新用户表用户余额-图书价格
        bookDao.buyBook(userId,bookPrice);
    }
}
