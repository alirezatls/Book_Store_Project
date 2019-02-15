package com.web.sample_web.controller;

import com.web.sample_web.dao.BookDao;
import com.web.sample_web.dao.MemberDao;
import com.web.sample_web.entity.Book;
import com.web.sample_web.entity.Members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Base64;

@Controller
public class AdminController {

    @Autowired
    private BookDao bookDao;

    @Autowired
    MemberDao memberDao;

    @GetMapping(path = "/admin")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    public String showAdminPanel(ModelMap modelMap, @RequestParam(defaultValue = "0") int page) {
        PageRequest pageRequest = PageRequest.of(page,8);
        Page<Book> adminBooks = bookDao.getAllBookPagination(pageRequest);
        for(Book book: adminBooks.getContent()) {
            book.setPicBase64(Base64.getEncoder().encodeToString(book.getBookPicture()));
        }
        modelMap.addAttribute("page",adminBooks);
        modelMap.addAttribute("currentPage",page);
        return "admin";
    }

    @GetMapping(path = "/deleteBook/{bookId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteBookFromList(@PathVariable("bookId") Integer bookId) {
        Integer state = bookDao.deleteBookById(bookId);
        if (state<=0) {
            throw new IllegalStateException();
        }
        return "redirect:/admin";
    }
    @GetMapping(path = "/admin/members")
    public String showApplicationMembersPage(ModelMap modelMap,@RequestParam(defaultValue = "0") int page) {
        PageRequest pageRequest = PageRequest.of(page, 10);
        Page<Members> members = memberDao.getAllMembersPage(pageRequest);
        modelMap.addAttribute("memberPage",members);
        modelMap.addAttribute("currentPage",page);
        return "admin_members";
    }
}
