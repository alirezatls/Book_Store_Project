package com.web.sample_web.service.impl;

import com.web.sample_web.domain.Members;
import com.web.sample_web.repository.MembersRepository;
import com.web.sample_web.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultMemberService implements MemberService {
    private final MembersRepository memberRepository;

    @Autowired
    public DefaultMemberService(MembersRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Members saveMember(Members m) {
        return memberRepository.save(m);
    }

    @Override
    public Members getByUserName(String userName) {
        return memberRepository.findByUserName(userName);
    }

    @Override
    public Members getByUserNameAndPassword(String userName, String password) {
        return memberRepository.findByUserNameAndPassword(userName, password);
    }

    @Override
    public List<Members> getAllMember() {
        return memberRepository.findAll();
    }

    @Override
    @Transactional
    public Integer deleteMemberById(int id) {
        return memberRepository.deleteByMemberId(id);
    }

    @Override
    public Long memberCount() {
        return memberRepository.count();
    }

    @Override
    public Page<Members> getAllMembersPage(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }

    @Override
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
        return member != null;
    }

    @Override
    public void saveRegisteredMember(Members member) {
        memberRepository.save(member);
    }
}
