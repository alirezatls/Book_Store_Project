package com.web.sample_web.service;

import com.web.sample_web.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    private static List<Book> books = null;


}
