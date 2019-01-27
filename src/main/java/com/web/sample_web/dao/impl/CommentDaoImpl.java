package com.web.sample_web.dao.impl;

import com.web.sample_web.dao.CommentDao;
import com.web.sample_web.entity.Comment;
import com.web.sample_web.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Integer deleteCommentById(Integer id) {
        return null;
    }

    @Override
    public List<Comment> getAllComment() {
        return null;
    }
}
