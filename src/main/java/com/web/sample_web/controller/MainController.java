package com.web.sample_web.controller;

import com.web.sample_web.dao.BookDao;
import com.web.sample_web.dao.MemberDao;
import com.web.sample_web.entity.Book;
import com.web.sample_web.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Controller
@SessionAttributes(value = {"orderBook","user"})
public class MainController {

    @Autowired
    MemberDao memberDao;
    @Autowired
    BookDao bookDao;

    @Autowired
    CartService cartService;

    @GetMapping(path = "/")
    public String showWelcomePage() {
        return "index";
    }

    @GetMapping(path = "/add_book)")
    public String showAddBookPage() {
        return "add_book";
    }

    @PostMapping(path = "/add_book")
    public String addNewBook(@RequestParam String bookName,
                             @RequestParam String bookAuthor,
                             @RequestParam String cost,
                             @RequestParam(name = "bookPicture") MultipartFile file) {
        try {
           Book book = new Book();
           book.setBookName(bookName);
           book.setBookAuthor(bookAuthor);
           book.setCost(cost);
           book.setBookPicture(file.getBytes());
            Book saveBook = bookDao.saveBook(book);
            if(saveBook == null) {
                return "/error";
            }
            System.out.println(book.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }

    @RequestMapping(value = "/list_book", method = RequestMethod.GET)
    public String showListOfBook(ModelMap modelMap) {
        List<Book> books = bookDao.getAllBook();
        String format = "data:image/png;base64";
        for(Book b: books) {
           b.setPicBase64(Base64.getEncoder().encodeToString(b.getBookPicture()));
        }
        modelMap.addAttribute("books",books);
        return "list_book";
    }

    @GetMapping(path = "/delete_book/{bookId}")
    public String deleteBookFromList(@PathVariable("bookId") Integer bookId) {
        Integer state = bookDao.deleteBookById(bookId);
        if (state<=0) {
            throw new IllegalStateException();
        }
        return "redirect:/list_book";
    }

    @GetMapping(path = "/add_to_cart/{bookId}")
    public String addBookToCart(@PathVariable Integer bookId,
                                ModelMap modelMap) {

        //get book by Id
        Book book = bookDao.getBookById(bookId);
        if (book == null) {
            throw new IllegalStateException();
        }

        List<Book> books = (ArrayList<Book>)modelMap.get("orderBook");
        //add book to session
        if(books == null) {
            books = new ArrayList<>();
            modelMap.put("orderBook",books);
        }
        books.add(book);

        return "redirect:/list_book";
    }

    @RequestMapping(value = "/my_cart",method = RequestMethod.GET)
    public String showMyCart() {
        return "orders";
    }


    @RequestMapping(value = "/delete/{bookId}",method = RequestMethod.GET)
    public String deleteBookFromOrder(@PathVariable("bookId") Integer bookId,ModelMap modelMap) {
        List<Book> orderBook = (ArrayList<Book>) modelMap.get("orderBook");
        if(orderBook != null) {
            for (Book b: orderBook) {
                if(b.getBookId().equals(bookId)) {
                    orderBook.remove(b);
                    return "redirect:/my_cart";
                }
            }
        }
        throw new IllegalStateException();
    }

}
