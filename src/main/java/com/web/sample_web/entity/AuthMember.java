package com.web.sample_web.entity;

import javax.persistence.*;

@Entity
@Table(name = "AUTH_MEMBER",schema = "jpa")
public class AuthMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUTH_MEMBER_ID")
    private int authMemberId;

    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "AUTH_GROUP")
    private String authGroup;

    public AuthMember() {
    }

    public int getAuthMemberId() {
        return authMemberId;
    }

    public void setAuthMemberId(int authMemberId) {
        this.authMemberId = authMemberId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAuthGroup() {
        return authGroup;
    }

    public void setAuthGroup(String authGroup) {
        this.authGroup = authGroup;
    }
}
