package com.books.dao;

import java.util.List;

import com.books.entity.Book;


public interface BookDAO {
    public long createBook(Book book);
    public Book updateBook(Book book);
    public void deleteBook(long id);
    public List<Book> getAllBooks();
    public Book getBook(long id);
    public List<Book> getAllBooks(String booksName);
}