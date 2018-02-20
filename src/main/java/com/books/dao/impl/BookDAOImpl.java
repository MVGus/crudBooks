package com.books.dao.impl;

import com.books.dao.BookDAO;
import com.books.entity.Book;
import com.books.util.HibernateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;



@Repository
public class BookDAOImpl implements BookDAO {

    public BookDAOImpl() {
        System.out.println("BookDAOImpl");
    }

    @Autowired
    private HibernateUtil hibernateUtil;

    @Override
    public long createBook(Book book) {
        return (Long) hibernateUtil.create(book);
    }

    @Override
    public Book updateBook(Book book) {
        return hibernateUtil.update(book);
    }

    @Override
    public void deleteBook(long id) {
        Book book = new Book();
        book.setId(id);
        hibernateUtil.delete(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return hibernateUtil.fetchAll(Book.class);
    }

    @Override
    public Book getBook(long id) {
        return hibernateUtil.fetchById(id, Book.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Book> getAllBooks(String bookName) {
        String query = "SELECT e.* FROM Books e WHERE e.title like '%"+ bookName +"%'";
        List<Object[]> bookObjects = hibernateUtil.fetchAll(query);
        List<Book> books = new ArrayList<Book>();
        for(Object[] bookObject: bookObjects) {
            Book book = new Book();
            long id = ((BigInteger) bookObject[0]).longValue();
            String author = (String) bookObject[1];
            String title = (String) bookObject[3];
            float price = (float) bookObject[2];
            book.setId(id);
            book.setTitle(title);
            book.setAuthor(author);
            book.setPrice(price);
            books.add(book);
        }
        System.out.println(books);
        return books;
    }
}