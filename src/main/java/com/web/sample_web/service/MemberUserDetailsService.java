package com.web.sample_web.service;

import com.web.sample_web.entity.Member;
import com.web.sample_web.repository.MemberRepository;
import com.web.sample_web.util.MemberPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MemberUserDetailsService implements UserDetailsService {

    private MemberRepository memberRepository;

    public MemberUserDetailsService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Member byUserName = memberRepository.findByUserName(s);
        if(byUserName == null) {
            throw new UsernameNotFoundException("username not found");
        }
        return new MemberPrincipal(byUserName);
    }
}
