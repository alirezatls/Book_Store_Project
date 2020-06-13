package com.web.sample_web.controller;

import com.web.sample_web.domain.Book;
import com.web.sample_web.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@AllArgsConstructor
public class DetailsBookController {

    private final BookService service;

    @GetMapping(path = "/books/{bookCode}")
//    @PreAuthorize("hasRole('ROLE_USER')")
    public String showBookDetails(@PathVariable String bookCode, ModelMap modelMap, HttpSession session) {
        List<Book> orderBook = (List<Book>) session.getAttribute("orderBook");
        Book bookDetail = service.getBook(bookCode);
        modelMap.addAttribute("bookDetail", bookDetail);
        modelMap.addAttribute("order", orderBook);
        return "details";
    }
}
