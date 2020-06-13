package com.web.sample_web.controller;

import com.web.sample_web.domain.Book;
import com.web.sample_web.service.BookService;
import com.web.sample_web.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@AllArgsConstructor
public class ShoppingCartController {
    private final BookService service;
    private final OrderService orderService;


    @RequestMapping(value = "/cart", method = GET)
    public ModelAndView showMyCart(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("orders");
        if (session.getAttribute("orderBook") == null) {
            List<Book> list = new ArrayList<>();
            session.setAttribute("orderBook", list);
        } else {
            List<Book> list = (List<Book>) session.getAttribute("orderBook");
            modelAndView.addObject("total", orderService.totalPrice(list));
            modelAndView.addObject("count", orderService.count(list));
        }

        return modelAndView;
    }

    @GetMapping(path = "cart/add/{bookId}")
    public String addBookToCart(@PathVariable Integer bookId, HttpSession session) {
        Book book = service.getBookById(bookId);
        List<Book> list = check(session);
        orderService.addBook(book, list);
        session.setAttribute("orderBook", list);
        return "redirect:/books/";
    }


    @RequestMapping(value = "/cart/remove/{bookId}", method = GET)
    public String deleteBookFromCart(@PathVariable("bookId") Integer bookId, HttpSession session) {
        List<Book> orderBook = (List<Book>) session.getAttribute("orderBook");
        Optional<Book> exist = orderService.exist(bookId, orderBook);
        orderService.removeBook(exist.orElseThrow(IllegalStateException::new), orderBook);
        return "redirect:/cart";
    }

    private List<Book> check(HttpSession session) {
        List<Book> list;
        if (session.getAttribute("orderBook") == null) {
            list = new ArrayList<>();
            session.setAttribute("orderBook", list);
        } else {
            list = (List<Book>) session.getAttribute("orderBook");
        }
        return list;
    }
}
