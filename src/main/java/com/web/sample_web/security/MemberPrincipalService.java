package com.web.sample_web.security;

import com.web.sample_web.entity.AuthMember;
import com.web.sample_web.entity.Members;
import com.web.sample_web.repository.AuthMemberRepository;
import com.web.sample_web.repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberPrincipalService implements UserDetailsService {

    private MembersRepository memberRepository;
    private AuthMemberRepository authMemberRepository;

    @Autowired
    public MemberPrincipalService(MembersRepository memberRepository, AuthMemberRepository authMemberRepository) {
        this.memberRepository = memberRepository;
        this.authMemberRepository = authMemberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Members member = memberRepository.findByUserName(username);
        if(member == null) {
            throw new UsernameNotFoundException("username not found");
        }
        List<AuthMember> auth = authMemberRepository.findByUserName(username);
        return new MemberPrincipal(member,auth);

    }
}
