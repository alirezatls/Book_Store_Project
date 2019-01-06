package com.web.sample_web.dao.impl;

import com.web.sample_web.dao.BookDao;
import com.web.sample_web.entity.Book;
import com.web.sample_web.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class BookDaoImpl implements BookDao {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book saveBook(Book b) {
        return bookRepository.save(b);
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.findByBookId(id);
    }

    @Override
    public List<Book> getAllBook() {
       return bookRepository.findAll();
    }

    @Override
    @Transactional
    public Integer deleteBookById(int id) {
       return bookRepository.deleteByBookId(id);
    }

    @Override
    public Long bookCount() {
        return bookRepository.count();
    }

}
