package com.web.sample_web.service.impl;

import com.web.sample_web.entity.Book;
import com.web.sample_web.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public void addBook(Book book, List<Book> bookList) {
        Optional<Book> exist = exist(book.getBookId(), bookList);
        boolean existPresent = exist.isPresent();
        if(!existPresent)
            bookList.add(book);
    }

    @Override
    public void removeBook(Book book, List<Book> bookList) {
        Optional<Book> optional = exist(book.getBookId(), bookList);
        if (optional.isPresent())
            bookList.remove(book);
    }

    @Override
    public Optional<Book> exist(int id, List<Book> bookList) {
        for (Book b: bookList) {
            if(b.getBookId() == id) {
                return Optional.of(b);
            }
        }
        return Optional.empty();
    }

    @Override
    public Integer totalPrice(List<Book> bookList) {
        Long aLong = bookList.stream().
                map(Book::getCost).
                reduce(0L, (l1, l2) -> l1 + l2);
        return aLong.intValue();
    }

    @Override
    public Integer count(List<Book> list) {
        return (int)list.stream().count();
    }
}
