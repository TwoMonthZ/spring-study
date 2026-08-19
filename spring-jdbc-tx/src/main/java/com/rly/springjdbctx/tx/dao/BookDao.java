package com.rly.springjdbctx.tx.dao;

public interface BookDao {
    void buyBook(Integer userId, Integer bookPrice);

    Integer getBookPrice(Integer bookId);

    void updateStock(Integer bookId);
}
