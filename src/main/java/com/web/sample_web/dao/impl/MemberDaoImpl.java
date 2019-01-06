package com.web.sample_web.dao.impl;


import com.web.sample_web.dao.MemberDao;
import com.web.sample_web.entity.Member;
import com.web.sample_web.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class MemberDaoImpl implements MemberDao {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public Member saveMember(Member m) {
        return memberRepository.save(m);
    }

    @Override
    public Member getByUserName(String userName) {
        return memberRepository.findByUserName(userName);
    }

    @Override
    public Member getByUserNameAndPassword(String userName, String password) {
        return memberRepository.findByUserNameAndPassword(userName,password);
    }

    @Override
    public List<Member> getAllMember() {
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
}
