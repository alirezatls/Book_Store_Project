package com.web.sample_web.controller;

import com.web.sample_web.dao.BookDao;
import com.web.sample_web.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookDao bookDao;

    @GetMapping(path = "/addBookPage")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showBookForm() {

        return "add_book";
    }

    @PostMapping(path = "/addBookPerform")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addToBookStore(@RequestParam String bookName,
                             @RequestParam String bookAuthor,
                             @RequestParam Long cost,
                             @RequestParam String publisher,
                             @RequestParam Integer pageNumber,
                             @RequestParam String txt,
                             @RequestParam(name = "bookPicture") MultipartFile file) {
        try {
            Book book = new Book();
            book.setBookName(bookName);
            book.setBookAuthor(bookAuthor);
            book.setCost(cost);
            book.setPublisher(publisher);
            book.setPageNumber(pageNumber);
            book.setDetails(txt);
            book.setBookPicture(file.getBytes());
            Book saveBook = bookDao.saveBook(book);
            if(saveBook == null) {
                return "/error";
            }
            System.out.println(book.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }

    @GetMapping(path = "/books")
    public String showListOfBookPage(ModelMap modelMap,@RequestParam(defaultValue = "0") int page) {
        PageRequest pageRequest = PageRequest.of(page,13);

        Page<Book> pag = bookDao.getAllBookPagination(pageRequest);
        for(Book b: pag.getContent()) {
            b.setPicBase64(Base64.getEncoder().encodeToString(b.getBookPicture()));
        }
        modelMap.addAttribute("page",pag);
        modelMap.addAttribute("currentPage",page);
        return "list_book";
    }

    @PostMapping(path = "/books/sort")
    public String showListOfBookPage(ModelMap modelMap,@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "") String sortType) {
        PageRequest pageRequest;
        if(sortType.equals("max")) {
             pageRequest = PageRequest.of(page, 13,Sort.by(Sort.Order.asc("Price")));
        }
        else if(sortType.equals("min")) {
             pageRequest = PageRequest.of(page, 13,Sort.by(Sort.Order.desc("Price")));
        }
        else {
             pageRequest = PageRequest.of(page, 13);
        }

        Page<Book> pag = bookDao.getAllBookPagination(pageRequest);
        for(Book b: pag.getContent()) {
            b.setPicBase64(Base64.getEncoder().encodeToString(b.getBookPicture()));
        }
        modelMap.addAttribute("page",pag);
        modelMap.addAttribute("currentPage",page);
        return "list_book";
    }

}
