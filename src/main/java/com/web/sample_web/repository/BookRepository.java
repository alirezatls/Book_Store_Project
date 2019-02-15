package com.web.sample_web.repository;

import com.web.sample_web.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer>{
    Integer deleteByBookId(int id);
    int deleteBookByBookCode(String bookCode);
    Book findByBookId(int id);
    Book findByBookCode(String bookCode);
}
