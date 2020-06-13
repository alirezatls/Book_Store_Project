package com.web.sample_web.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer bookId;
    private String bookName;
    private String bookAuthor;
    private String bookCode;
    private String url;
    private Long cost;
    private String publisher;
    private Integer pageNumber;
    @Column(columnDefinition = "VARCHAR(10000)")
    private String details;
    @CreationTimestamp
    private Date creationDate;
    @OneToMany(mappedBy = "book", fetch = EAGER, cascade = ALL)
    private List<Comment> comments;
}

