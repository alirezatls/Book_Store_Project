package com.web.sample_web.controller;

import com.web.sample_web.dao.BookDao;
import com.web.sample_web.dao.CommentDao;
import com.web.sample_web.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {

    @Autowired
    CommentDao commentDao;

    @Autowired
    BookDao bookDao;

    @PostMapping(path = "/addComment")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String addComment(@RequestParam(name = "comment") String comment,
                             @RequestParam(name = "commentName") String commentName,
                             @RequestParam(name = "code") String code) {
        Comment com = new Comment();
        com.setText(comment);
        com.setCommentOwner(commentName);
        commentDao.saveComment(com);
        String uuid = bookDao.addCommentForBook(code, com);
        return "redirect:/books/"+uuid;
    }
}
