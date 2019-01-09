package com.web.sample_web.service;

import com.web.sample_web.entity.AuthGroup;
import com.web.sample_web.entity.Member;
import com.web.sample_web.repository.AuthGroupRepository;
import com.web.sample_web.repository.MemberRepository;
import com.web.sample_web.util.MemberPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberUserDetailsService implements UserDetailsService {

    private MemberRepository memberRepository;
    private AuthGroupRepository authGroupRepository;

    public MemberUserDetailsService(MemberRepository memberRepository,AuthGroupRepository authGroupRepository) {
        this.memberRepository = memberRepository;
        this.authGroupRepository =authGroupRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Member byUserName = memberRepository.findByUserName(s);
        if(byUserName == null) {
            throw new UsernameNotFoundException("username not found");
        }
        List<AuthGroup> auth = authGroupRepository.findByUserName(s);
        return new MemberPrincipal(byUserName,auth);
    }
}
