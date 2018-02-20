package com.books.service.impl;

import com.books.dao.BookDAO;
import com.books.entity.Book;
import com.books.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    public BookServiceImpl() {
        System.out.println("BookServiceImpl()");
    }

    @Autowired
    private BookDAO bookDAO;

    @Override
    public long createBook(Book book) {
        return bookDAO.createBook(book);
    }
    @Override
    public Book updateBook(Book book) {
        return bookDAO.updateBook(book);
    }
    @Override
    public void deleteBook(long id) {
        bookDAO.deleteBook(id);
    }
    @Override
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }
    @Override
    public Book getBook(long id) {
        return bookDAO.getBook(id);
    }
    @Override
    public List<Book> getAllBooks(String bookName) {
        return bookDAO.getAllBooks(bookName);
    }
}
