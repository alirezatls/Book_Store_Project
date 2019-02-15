package com.web.sample_web.dao;

import com.web.sample_web.entity.Book;
import com.web.sample_web.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookDao {

    Book saveBook(Book b);

    Book getBookById(int id);

    List<Book> getAllBook();

    Page<Book> getAllBookPagination(Pageable pageable);

    int deleteBookByBookCode(String code);

    Long bookCount();

    Book getByBookCode(String bookCode);

    String addCommentForBook(String code,Comment comment);

    Integer updateBook(Book book);
}
