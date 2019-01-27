package com.web.sample_web.controller;

import com.web.sample_web.dao.BookDao;
import com.web.sample_web.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Base64;

@Controller
public class DetailsBookController {

    @Autowired
    BookDao bookDao;

    @GetMapping(path = "/books/{bookCode}")
    public String showBookDetails(@PathVariable String bookCode, ModelMap modelMap) {
        Book bookDetail = bookDao.getByBookCode(bookCode);
        bookDetail.setPicBase64(Base64.getEncoder().encodeToString(bookDetail.getBookPicture()));
        modelMap.addAttribute("bookDetail",bookDetail);
        return "details";
    }
}
