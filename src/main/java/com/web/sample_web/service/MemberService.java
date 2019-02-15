package com.web.sample_web.service;

import com.web.sample_web.entity.Members;
import com.web.sample_web.entity.VerificationToken;
import com.web.sample_web.repository.MembersRepository;
import com.web.sample_web.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    MembersRepository memberRepository;

    @Autowired
    VerificationTokenRepository verificationTokenRepository;


    public Members registerNewMemberAccount(Members member)
            throws IllegalStateException {

        if (emailExist(member.getEmail())) {
            throw new IllegalStateException(
                    "There is an account with that email adress: "
                            + member.getEmail());
        }

        return memberRepository.save(member);
    }

    private boolean emailExist(String email) {
        Members member = memberRepository.findByEmail(email);
        if (member != null) {
            return true;
        }
        return false;
    }

    public Members getMember(String verificationToken) {
        Members member = verificationTokenRepository.findByToken(verificationToken).getMember();
        return member;
    }


    public VerificationToken getVerificationToken(String VerificationToken) {
        return verificationTokenRepository.findByToken(VerificationToken);
    }


    public void saveRegisteredMember(Members member) {
        memberRepository.save(member);
    }

    //saved token to database
    public void createVerificationToken(Members member, String token) {
        VerificationToken myToken = new VerificationToken(token, member);
        verificationTokenRepository.save(myToken);
    }
}
