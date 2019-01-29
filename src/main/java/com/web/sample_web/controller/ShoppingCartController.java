package com.web.sample_web.controller;

import com.web.sample_web.dao.BookDao;
import com.web.sample_web.entity.Book;
import com.web.sample_web.service.CartService;
import com.web.sample_web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
//@SessionAttributes(value = {"orderBook"})
public class ShoppingCartController {

    @Autowired
    BookDao bookDao;

    @Autowired
    CartService cartService;

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public ModelAndView showMyCart(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("orders");
        if (session.getAttribute("orderBook") == null) {
            List<Book> list = new ArrayList<>();
            session.setAttribute("orderBook",list);
        } else {
            List<Book> list = (List<Book>) session.getAttribute("orderBook");
            modelAndView.addObject("total",orderService.totalPrice(list));
            modelAndView.addObject("count",orderService.count(list));
        }

        return modelAndView;
    }

    @GetMapping(path = "cart/add/{bookId}")
    public String addBookToCart(@PathVariable Integer bookId, HttpSession session) {
        Book book = bookDao.getBookById(bookId);
        List<Book> list = (List<Book>) session.getAttribute("orderBook");
        orderService.addBook(book,list);
        session.setAttribute("orderBook",list);
        return "redirect:/books/"+book.getBookCode();
    }


    @RequestMapping(value = "/cart/remove/{bookId}", method = RequestMethod.GET)
    public String deleteBookFromCart(@PathVariable("bookId") Integer bookId, HttpSession session) {
        List<Book> orderBook = (List<Book>) session.getAttribute("orderBook");
        //Book exist = cartService.exist(bookId, orderBook);
        Optional<Book> exist = orderService.exist(bookId, orderBook);
        //cartService.removeBook(exist,orderBook);
        orderService.removeBook(exist.orElseThrow(IllegalStateException::new),orderBook);
        return "redirect:/cart";
    }
}