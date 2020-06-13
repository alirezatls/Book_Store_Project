package com.web.sample_web.controller;

import com.web.sample_web.domain.Comment;
import com.web.sample_web.repository.CommentRepository;
import com.web.sample_web.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class CommentController {

    private final CommentService service;
    private final CommentRepository repository;

    @PostMapping(path = "/addComment")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String addComment(@RequestParam(name = "comment") String comment,
                             @RequestParam(name = "commentName") String commentName,
                             @RequestParam(name = "code") String code) {
        Comment com = new Comment();
        com.setText(comment);
        com.setCommentOwner(commentName);
        String uuid = service.addComment(code, com);
        return "redirect:/books/" + uuid;
    }

    @GetMapping("/admin/comment/{commentId}")
    public String deleteComment(@PathVariable("commentId") int id) {
        Comment comment = repository.findById(id).get();
        repository.delete(comment);
        return "redirect:/admin/comments";
    }
}
