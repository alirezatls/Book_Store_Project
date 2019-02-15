package com.web.sample_web.security;

import com.web.sample_web.entity.AuthMember;
import com.web.sample_web.entity.Members;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class MemberPrincipal implements UserDetails {

    private Members member;
    private List<AuthMember> authMember;

    public MemberPrincipal(Members member, List<AuthMember> authMember) {
        this.member = member;
        this.authMember = authMember;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authMember == null) {
            return Collections.emptySet();
        }
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authMember.forEach(auth -> authorities.add(new SimpleGrantedAuthority(auth.getAuthGroup())));
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.member.getPassword();
    }

    @Override
    public String getUsername() {
        return this.member.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
