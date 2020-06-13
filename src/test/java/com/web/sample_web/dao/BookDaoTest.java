//package com.web.sample_web.dao;
//
//import com.web.sample_web.entity.Book;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class BookDaoTest {
//
//    @Autowired
//    BookDao bookDao;
//
//  //  private Book book = new Book("lord of the rings","J.R.R.T",
//   //         "4152378","1500");
//    @Test
//    public void testSaveBook() {
//
//      //  Book saveBook = bookDao.saveBook(book);
//      //  Assert.assertNotNull(saveBook);
//    }
//
//    @Test
//    public void testGetBookById() {
//        Book song = bookDao.getBookById(1);
//        Assert.assertEquals("J.R.R.M",song.getBookAuthor());
//    }
//
//    @Test
//    public void testGetAllBook() {
//        List<Book> allBook = bookDao.getAllBook();
//        Assert.assertEquals(1, allBook.size());
//    }
//
//    @Test
//    public void testDeleteBookById() {
//       // Integer integer = bookDao.deleteBookById(3);
//      //  Assert.assertEquals(true, integer>0);
//    }
//
//}
