package com.web.sample_web.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "jpa")
public class Book {

    private Integer bookId;

    private String bookName;

    private String bookAuthor;

    private String bookCode;

    private String cost;

    private byte[] bookPicture;

    private String picBase64;

    private Date creationDate;

    public Book() {
    }

    public Book(String bookName, String bookAuthor, String bookCode, String cost) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookCode = bookCode;
        this.cost = cost;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getBookId() {
        return bookId;
    }

    @Column(name = "book_name",nullable = false)
    public String getBookName() {
        return bookName;
    }

    @Column(name = "book_author",nullable = false)
    public String getBookAuthor() {
        return bookAuthor;
    }

    @Column(name = "book_code",nullable = false)
    public String getBookCode() {
        return bookCode;
    }

    @Column(name = "book_cost",nullable = false)
    public String getCost() {
        return cost;
    }

    @Lob
    @Column(name = "book_picture")
    public byte[] getBookPicture() {
        return bookPicture;
    }

    @Transient
    public String getPicBase64() {
        return picBase64;
    }

    @CreationTimestamp @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    public Date getCreationDate() {
        return creationDate;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setBookPicture(byte[] bookPicture) {
        this.bookPicture = bookPicture;
    }

    public void setPicBase64(String picBase64) {
        this.picBase64 = picBase64;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}

