package com.web.sample_web.service;

import com.web.sample_web.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

    String saveBook(Book b);

    Page<Book> getAllBook(Pageable pageable);

    String removeBook(String code);

    Book getBook(String code);

    Book getBookById(Integer id);
}
