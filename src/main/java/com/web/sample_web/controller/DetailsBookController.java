package com.web.sample_web.controller;

import com.web.sample_web.dao.BookDao;
import com.web.sample_web.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Base64;
import java.util.List;

@Controller
public class DetailsBookController {

    @Autowired
    BookDao bookDao;

    @GetMapping(path = "/books/{bookCode}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String showBookDetails(@PathVariable String bookCode, ModelMap modelMap, HttpSession session) {
        List<Book> orderBook = (List<Book>)session.getAttribute("orderBook");
        Book bookDetail = bookDao.getByBookCode(bookCode);
        bookDetail.setPicBase64(Base64.getEncoder().encodeToString(bookDetail.getBookPicture()));
        modelMap.addAttribute("bookDetail",bookDetail);
        modelMap.addAttribute("order",orderBook);
        return "details";
    }
}
