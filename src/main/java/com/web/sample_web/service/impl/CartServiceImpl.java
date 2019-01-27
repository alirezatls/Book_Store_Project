package com.web.sample_web.service.impl;

import com.web.sample_web.entity.Book;
import com.web.sample_web.service.CartService;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    @Override
    public void addBook(Book b,Map<Book,Integer> cart) {
        Book exist = exist(b.getBookId(), cart);
        if(exist == null) {
            cart.put(b,1);
        }
        else if(exist != null){
            cart.replace(exist,cart.get(exist)+1);
        }
    }

    @Override
    public void removeBook(Book book, Map<Book,Integer> cart) {
            if (cart.get(book) > 1) {
                cart.replace(book, cart.get(book) - 1);
            } else if (cart.get(book) == 1) {
                cart.remove(book);
            }
    }

    @Override
    public Book exist(int id, Map<Book, Integer> map) {
        boolean state = false;
        for (Map.Entry<Book,Integer> entry: map.entrySet()) {
            if(entry.getKey().getBookId() == id) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    public Integer totalPrice() {
        return null;
    }

}
