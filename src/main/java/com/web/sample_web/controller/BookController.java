package com.web.sample_web.controller;

import com.web.sample_web.domain.Book;
import com.web.sample_web.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@AllArgsConstructor
public class BookController {

    private final BookService service;

    @GetMapping(path = "/addBookPage")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showBookForm(ModelMap modelMap) {
        modelMap.addAttribute("book", new Book());
        return "add_book";
    }

    @PostMapping(path = "/addBookPerform")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addToBookStore(@ModelAttribute("book") Book book) {
        book.setBookCode(UUID.randomUUID().toString());
        return service.saveBook(book);
    }

    @GetMapping(path = "/books")
    public String showListOfBookPage(ModelMap modelMap, @RequestParam(defaultValue = "0") int page) {
        Page<Book> bookPage = service.getAllBook(PageRequest.of(page, 13));
        modelMap.addAttribute("page", bookPage);
        modelMap.addAttribute("currentPage", page);
        return "list_book";
    }

    @PostMapping(path = "/books/sort")
    public String showListOfBookPage(ModelMap modelMap, @RequestParam(defaultValue = "1") int page,
                                     @RequestParam(defaultValue = "") String sortType) {
        PageRequest pageRequest = getPageRequest(page, sortType);
        Page<Book> bookPage = service.getAllBook(pageRequest);
        modelMap.addAttribute("page", bookPage);
        modelMap.addAttribute("currentPage", page);
        return "list_book";
    }

    private PageRequest getPageRequest(int page, String sortType) {
        PageRequest pageRequest;
        if (sortType.equals("max")) {
            pageRequest = PageRequest.of(page, 13, Sort.by(Sort.Order.asc("Price")));
        } else if (sortType.equals("min")) {
            pageRequest = PageRequest.of(page, 13, Sort.by(Sort.Order.desc("Price")));
        } else {
            pageRequest = PageRequest.of(page, 13);
        }
        return pageRequest;
    }
}
