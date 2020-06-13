package com.web.sample_web.service.impl;

import com.web.sample_web.domain.Book;
import com.web.sample_web.domain.Comment;
import com.web.sample_web.repository.BookRepository;
import com.web.sample_web.repository.CommentRepository;
import com.web.sample_web.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultCommentService implements CommentService {

    private CommentRepository commentRepository;
    private BookRepository bookRepository;

    @Autowired
    public DefaultCommentService(CommentRepository commentRepository, BookRepository bookRepository) {
        this.commentRepository = commentRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public String addComment(String bookCode, Comment comment) {
        Book book = bookRepository.findByBookCode(bookCode);
        book.getComments().add(comment);
        comment.setBook(book);
        commentRepository.save(comment);
        return bookCode;
    }

    @Override
    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }
}
