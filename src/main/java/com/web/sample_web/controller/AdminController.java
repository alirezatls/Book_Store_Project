package com.web.sample_web.controller;

import com.web.sample_web.domain.Book;
import com.web.sample_web.domain.Comment;
import com.web.sample_web.domain.Members;
import com.web.sample_web.service.BookService;
import com.web.sample_web.service.CommentService;
import com.web.sample_web.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class AdminController {

    private final MemberService memberService;
    private final CommentService commentRepository;
    private final BookService service;

    @GetMapping(path = "/admin")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    public String showAdminPanel(ModelMap modelMap, @RequestParam(defaultValue = "0") int page) {
        Page<Book> adminBooks = service.getAllBook(PageRequest.of(page, 8));
        modelMap.addAttribute("page", adminBooks);
        modelMap.addAttribute("currentPage", page);
        return "admin";
    }


    @GetMapping(path = "/admin/members")
    public String showApplicationMembersPage(ModelMap modelMap, @RequestParam(defaultValue = "0") int page) {
        PageRequest pageRequest = PageRequest.of(page, 10);
        Page<Members> members = memberService.getAllMembersPage(pageRequest);
        modelMap.addAttribute("memberPage", members);
        modelMap.addAttribute("currentPage", page);
        return "admin_members";
    }

    @GetMapping(path = "/deleteBook/{bookCode}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteBookFromList(@PathVariable("bookCode") String bookCode) {
        return service.removeBook(bookCode);
    }


    @GetMapping(path = "/admin/comments")
    public String showManageCommentsPage(Model model) {
        List<Comment> comments = commentRepository.getAllComment();
        model.addAttribute("comments", comments);
        return "comments";
    }
}
