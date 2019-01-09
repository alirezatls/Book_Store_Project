package com.web.sample_web.controller;

import com.web.sample_web.dao.BookDao;
import com.web.sample_web.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String addToBookStore(@RequestParam String bookName,
                             @RequestParam String bookAuthor,
                             @RequestParam String cost,
                             @RequestParam(name = "bookPicture") MultipartFile file) {
        try {
            Book book = new Book();
            book.setBookName(bookName);
            book.setBookAuthor(bookAuthor);
            book.setCost(cost);
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
    @PreAuthorize("hasRole('ROLE_USER')")
    public String showListOfBookPage(ModelMap modelMap) {
        List<Book> books = bookDao.getAllBook();
        String format = "data:image/png;base64";
        for(Book b: books) {
            b.setPicBase64(Base64.getEncoder().encodeToString(b.getBookPicture()));
        }
        modelMap.addAttribute("books",books);
        return "list_book";
    }

    @GetMapping(path = "/deleteBook/{bookId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteBookFromList(@PathVariable("bookId") Integer bookId) {
        Integer state = bookDao.deleteBookById(bookId);
        if (state<=0) {
            throw new IllegalStateException();
        }
        return "redirect:/books";
    }
}
