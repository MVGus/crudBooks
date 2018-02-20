package com.books.service;

import com.books.entity.Book;

import java.util.List;


public interface BookService {
    public long createBook(Book book);
    public Book updateBook(Book book);
    public void deleteBook(long id);
    public List<Book> getAllBooks();
    public Book getBook(long id);
    public List<Book> getAllBooks(String bookName);
}

