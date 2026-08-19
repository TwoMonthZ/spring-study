package com.rly.springiocxml.di;

public class Book {

    private String bname;
    private String author;
    private String others;


    public Book(String bname, String author) {
        this.bname = bname;
        this.author = author;
    }

    public Book() {

    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOthers() {
        return others;
    }
    public void setOthers(String others) {
        this.others = others;
    }
    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", others='" + others + '\'' +
                '}';
    }

    static void main(String[] args) {

        Book book = new Book();
        book.setBname("张三");
        book.setAuthor("张三");

        Book book1 = new Book("张三", "张三");

    }
}
