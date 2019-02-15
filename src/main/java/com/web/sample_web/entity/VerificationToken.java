package com.web.sample_web.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "VERIFICATION_TOKEN", schema = "jpa")
public class VerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "TOKEN", nullable = false)
    private String token;

    @OneToOne(targetEntity = Members.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "MEMBER_FK")
    private Members member;


    public VerificationToken() {
    }

    public VerificationToken(String token, Members member) {
        this.token = token;
        this.member = member;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Members getMember() {
        return member;
    }

    public void setMember(Members member) {
        this.member = member;
    }
}
