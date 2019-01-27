package com.web.sample_web.dao;

import com.web.sample_web.entity.Book;
import com.web.sample_web.entity.Comment;

import java.util.List;

public interface BookDao {

    Book saveBook(Book b);

    Book getBookById(int id);

    List<Book> getAllBook();

    Integer deleteBookById(int id);

    Long bookCount();

    Book getByBookCode(String bookCode);

    String addCommentForBook(String code,Comment comment);
}
