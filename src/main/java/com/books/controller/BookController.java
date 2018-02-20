package com.books.controller;

import com.books.entity.Book;
import com.books.service.BookService;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

    private static final Logger logger = Logger.getLogger(BookController.class);

    public BookController() {
        System.out.println("BookController()");
    }

    @Autowired
    private BookService bookService;

    @RequestMapping("createBook")
    public ModelAndView createBook(@ModelAttribute Book book) {
        logger.info("Creating Book. Data: "+ book);
        return new ModelAndView("bookForm");
    }

    @RequestMapping("editBook")
    public ModelAndView editBook(@RequestParam long id, @ModelAttribute Book book) {
        logger.info("Updating the Book for the Id "+id);
        book = bookService.getBook(id);
        return new ModelAndView("bookForm", "bookObject", book);
    }

    @RequestMapping("saveBook")
    public ModelAndView saveBook(@ModelAttribute Book book) {
        logger.info("Saving the Book. Data : "+ book);
        if(book.getId() == 0){ // if book id is 0 then creating the book other updating the book
            bookService.createBook(book);
        } else {
            bookService.updateBook(book);
        }
        return new ModelAndView("redirect:getAllBooks");
    }

    @RequestMapping("deleteBook")
    public ModelAndView deleteBook(@RequestParam long id) {
        logger.info("Deleting the Book. Id : "+id);
        bookService.deleteBook(id);
        return new ModelAndView("redirect:getAllBooks");
    }

    @RequestMapping(value = {"getAllBooks", "/"})
    public ModelAndView getAllBooks() {
        logger.info("Getting the all Books.");
        List<Book> bookList = bookService.getAllBooks();
        return new ModelAndView("bookList", "bookList", bookList);
    }

    @RequestMapping("searchBook")
    public ModelAndView searchBook(@RequestParam("searchTitle") String searchTitle) {
        logger.info("Searching the Book. Book Names: "+searchTitle);
        List<Book> bookList = bookService.getAllBooks(searchTitle);
        return new ModelAndView("bookList", "bookList", bookList);
    }
}
