package com.web.sample_web.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(schema = "jpa")
public class Book {

    private Integer bookId;

    private String bookName;

    private String bookAuthor;

    private String bookCode;

    private Long cost;

    private String publisher;

    private Integer pageNumber;

    private String details;

    private byte[] bookPicture;

    private String picBase64;

    private Date creationDate;

    private List<Comment> comments;

    public Book() {
        this.bookCode = UUID.randomUUID().toString();
    }

    public Book(String bookName, String bookAuthor, String bookCode, Long cost) {
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

    @Column(name = "bookCode")
    public String getBookCode() {
        return bookCode;
    }

    @Column(name = "book_cost",nullable = false,columnDefinition = "numeric")
    public Long getCost() {
        return cost;
    }

    @Column(name = "publisher")
    public String getPublisher() {
        return publisher;
    }

    @Column(name = "pageNumber",columnDefinition = "numeric")
    public Integer getPageNumber() {
        return pageNumber;
    }

    @Lob
    @Column(name = "detalis")
    public String getDetails() {
        return details;
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

    @OneToMany(mappedBy = "book",fetch = FetchType.EAGER)
    public List<Comment> getComments() {
        return comments;
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

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setDetails(String details) {
        this.details = details;
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

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}

