package com.web.sample_web.dao.impl;


import com.web.sample_web.dao.MemberDao;
import com.web.sample_web.entity.Members;
import com.web.sample_web.repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class MemberDaoImpl implements MemberDao {

    @Autowired
    MembersRepository memberRepository;

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
        return memberRepository.findByUserNameAndPassword(userName,password);
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
}
