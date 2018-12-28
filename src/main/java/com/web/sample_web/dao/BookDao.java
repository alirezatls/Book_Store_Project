package com.web.sample_web.dao;

import com.web.sample_web.entity.Book;

import java.util.List;

public interface BookDao {

    Book saveBook(Book b);

    Book getBookById(int id);

    List<Book> getAllBook();

    Integer deleteBookById(int id);

    Long bookCount();
}
