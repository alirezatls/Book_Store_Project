package com.web.sample_web.service;

import com.web.sample_web.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public interface CartService {


    void addBook(Book book, Map<Book,Integer> map);

    void removeBook(Book book,Map<Book,Integer> map);

    Book exist(int id,Map<Book,Integer> map);

     Integer totalPrice();

}
