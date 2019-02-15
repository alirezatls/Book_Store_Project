package com.web.sample_web.controller;

import com.web.sample_web.dao.BookDao;
import com.web.sample_web.dao.MemberDao;
import com.web.sample_web.entity.Book;
import com.web.sample_web.entity.Comment;
import com.web.sample_web.entity.Members;
import com.web.sample_web.repository.CommentRepository;
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
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private BookDao bookDao;

    @Autowired
    MemberDao memberDao;

    @Autowired
    CommentRepository commentRepository;

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


    @GetMapping(path = "/admin/members")
    public String showApplicationMembersPage(ModelMap modelMap,@RequestParam(defaultValue = "0") int page) {
        PageRequest pageRequest = PageRequest.of(page, 10);
        Page<Members> members = memberDao.getAllMembersPage(pageRequest);
        modelMap.addAttribute("memberPage",members);
        modelMap.addAttribute("currentPage",page);
        return "admin_members";
    }

    @GetMapping(path = "/deleteBook/{bookCode}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteBookFromList(@PathVariable("bookCode") String bookCode) {
        Integer state = bookDao.deleteBookByBookCode(bookCode);
        if (state<=0) {
            throw new IllegalStateException();
        }
        return "redirect:/admin";
    }

    @GetMapping(path = "/updateBook/{bookCode}")
    public String updateBookPage(Model model, @PathVariable(name = "bookCode") String bookCode) {
        Book book = bookDao.getByBookCode(bookCode);
        book.setPicBase64(Base64.getEncoder().encodeToString(book.getBookPicture()));
        model.addAttribute("book", book);
        return "update_book";
    }

    @GetMapping(path = "/admin/comments")
    public String showManageCommentsPage(Model model) {
        List<Comment> comments = commentRepository.findAll();
        model.addAttribute("comments", comments);
        return "comments";
    }
}
