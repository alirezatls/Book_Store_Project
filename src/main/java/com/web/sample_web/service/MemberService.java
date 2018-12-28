package com.web.sample_web.service;

import com.web.sample_web.entity.Member;
import com.web.sample_web.entity.VerificationToken;
import com.web.sample_web.repository.MemberRepository;
import com.web.sample_web.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    VerificationTokenRepository verificationTokenRepository;


    public Member registerNewMemberAccount(Member member)
            throws IllegalStateException {

        if (emailExist(member.getEmail())) {
            throw new IllegalStateException(
                    "There is an account with that email adress: "
                            + member.getEmail());
        }

        return memberRepository.save(member);
    }

    private boolean emailExist(String email) {
        Member member = memberRepository.findByEmail(email);
        if (member != null) {
            return true;
        }
        return false;
    }

    public Member getMember(String verificationToken) {
        Member member = verificationTokenRepository.findByToken(verificationToken).getMember();
        return member;
    }


    public VerificationToken getVerificationToken(String VerificationToken) {
        return verificationTokenRepository.findByToken(VerificationToken);
    }


    public void saveRegisteredMember(Member member) {
        memberRepository.save(member);
    }

    //saved token to database
    public void createVerificationToken(Member member, String token) {
        VerificationToken myToken = new VerificationToken(token, member);
        verificationTokenRepository.save(myToken);
    }
}
