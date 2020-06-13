package com.web.sample_web.service;

import com.web.sample_web.domain.Book;

import java.util.List;
import java.util.Optional;

public interface OrderService {


    void addBook(Book book, List<Book> bookList);

    void removeBook(Book book,List<Book> bookList);

    Optional<Book> exist(int id, List<Book> bookList);

    Integer totalPrice(List<Book> bookList);

    Integer count(List<Book> list);
}
