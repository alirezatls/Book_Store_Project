package com.web.sample_web.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "jpa")
@Access(AccessType.PROPERTY)
public class VerificationToken {

    private Long id;

    private String token;

    private Member member;


    public VerificationToken() {
    }

    public VerificationToken(String token, Member member) {
        this.token = token;
        this.member = member;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    @OneToOne(targetEntity = Member.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "member_id")
    public Member getMember() {
        return member;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
