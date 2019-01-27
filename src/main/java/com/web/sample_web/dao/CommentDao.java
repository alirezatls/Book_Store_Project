package com.web.sample_web.dao;

import com.web.sample_web.entity.Comment;

import java.util.List;

public interface CommentDao {

     Comment saveComment(Comment comment);

    Integer deleteCommentById(Integer id);

    List<Comment> getAllComment();
}
