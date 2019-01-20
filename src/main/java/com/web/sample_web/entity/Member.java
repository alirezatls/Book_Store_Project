package com.web.sample_web.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "members", schema = "jpa")
@Access(AccessType.PROPERTY)
public class Member {

    private Integer memberId;

    @Size(min = 4, message = "full name atleast need 4 character")
    private String fullName;

    @Email(message = " please enter a valid email address")
    private String email;

    @Size(min = 4, message = "user name atleast need 4 character")
    private String userName;


    @Size(min = 8, message = "password atleast need 8 character")
    private String password;

    private boolean enabled;

    private Date creationDate;

    private Date lastUpdate;

    public Member() {
        enabled = false;
    }

    public Member(String fullName, String email, String userName, String password) {
        this.fullName = fullName;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    public Integer getMemberId() {
        return memberId;
    }

    @Column(name = "full_name", nullable = false)
    public String getFullName() {
        return fullName;
    }

    @Column(name = "email",nullable = false)
    public String getEmail() {
        return email;
    }

    @Column(name = "user_name", nullable = false, unique = true)
    public String getUserName() {
        return userName;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    @Column(name = "enabled")
    public boolean isEnabled() {
        return enabled;
    }


    @Temporal(TemporalType.TIMESTAMP) @CreationTimestamp
    @Column(name = "creation_date")
    public Date getCreationDate() {
        return creationDate;
    }

    @Temporal(TemporalType.TIMESTAMP) @UpdateTimestamp
    @Column(name = "last_update")
    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
