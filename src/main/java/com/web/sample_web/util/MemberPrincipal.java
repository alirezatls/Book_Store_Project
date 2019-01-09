package com.web.sample_web.util;

import com.web.sample_web.entity.AuthGroup;
import com.web.sample_web.entity.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

/*
convert a Member Object to a Principal cuz spring security works with principals not member
 */
public class MemberPrincipal implements UserDetails {

    private Member member;
    private List<AuthGroup> authGroups;

    public MemberPrincipal(Member member,List<AuthGroup> authGroups) {
        this.member = member;
        this.authGroups = authGroups;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(authGroups == null) {
            return Collections.emptySet();
        }
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        for(AuthGroup group:authGroups) {
            grantedAuthorities.add(new SimpleGrantedAuthority(group.getAuthGroup()));
        }
        return grantedAuthorities;
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
