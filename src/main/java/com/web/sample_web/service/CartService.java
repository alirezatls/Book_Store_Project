package com.web.sample_web.service;

import com.web.sample_web.domain.Book;

import java.util.Map;


public interface CartService {


    void addBook(Book book, Map<Book,Integer> map);

    void removeBook(Book book,Map<Book,Integer> map);

    Book exist(int id,Map<Book,Integer> map);

     Integer totalPrice();

}
