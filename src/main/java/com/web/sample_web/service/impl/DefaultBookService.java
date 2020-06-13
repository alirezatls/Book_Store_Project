package com.web.sample_web.service.impl;

import com.web.sample_web.domain.Book;
import com.web.sample_web.repository.BookRepository;
import com.web.sample_web.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultBookService implements BookService {

    private BookRepository repository;

    @Autowired
    public DefaultBookService(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public String saveBook(Book b) {
        Book book = repository.save(b);
        if (book == null) {
            return "/error";
        }
        return "add_book";
    }

    @Override
    public Page<Book> getAllBook(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    @Transactional
    public String removeBook(String code) {
        int status = repository.deleteBookByBookCode(code);
        if (status <= 0) {
            throw new IllegalStateException();
        }
        return "redirect:/admin";
    }

    @Override
    @Transactional
    public Book getBook(String code) {
        return repository.findByBookCode(code);
    }

    @Override
    public Book getBookById(Integer id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }
}
