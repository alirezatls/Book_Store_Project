package com.web.sample_web.dao;

import com.web.sample_web.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckMethodTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    public void testCount() {
        long count = bookRepository.count();
        System.out.println(count);
    }
}
