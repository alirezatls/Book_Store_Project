package com.web.sample_web.controller;

import com.web.sample_web.dao.BookDao;
import com.web.sample_web.entity.Book;
import com.web.sample_web.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@SessionAttributes(value = {"orderBook"})
public class ShoppingCartController {

    @Autowired
    BookDao bookDao;

    @Autowired
    CartService cartService;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public ModelAndView showMyCart() {
        ModelAndView modelAndView = new ModelAndView("orders");
        return modelAndView;
    }

    @GetMapping(path = "cart/add/{bookId}")
    public ModelAndView addBookToCart(@PathVariable Integer bookId, HttpSession session) {
        Book book = bookDao.getBookById(bookId);
        if (session.getAttribute("orderBook") == null) {
            Map<Book, Integer> map = new HashMap<>();
            cartService.addBook(book,map);
            session.setAttribute("orderBook", map);
        } else {
            Map<Book, Integer> map = (HashMap<Book, Integer>) session.getAttribute("orderBook");
            cartService.addBook(book,map);
        }
        return showMyCart();
    }


    @RequestMapping(value = "/cart/remove/{bookId}", method = RequestMethod.GET)
    public ModelAndView deleteBookFromCart(@PathVariable("bookId") Integer bookId, HttpSession session) {
        Map<Book, Integer> orderBook = (Map<Book, Integer>) session.getAttribute("orderBook");
        Book exist = cartService.exist(bookId, orderBook);
        cartService.removeBook(exist,orderBook);
        return showMyCart();
    }
}