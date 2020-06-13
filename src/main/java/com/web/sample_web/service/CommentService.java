package com.web.sample_web.service;

import com.web.sample_web.domain.Comment;

import java.util.List;

public interface CommentService {

    String addComment(String bookCode, Comment comment);

    List<Comment> getAllComment();
}
