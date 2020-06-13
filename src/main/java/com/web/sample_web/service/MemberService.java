package com.web.sample_web.service;

import com.web.sample_web.domain.Members;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberService {
    Members saveMember(Members m);

    Members getByUserName(String userName);

    Members getByUserNameAndPassword(String userName, String password);

    List<Members> getAllMember();

    Integer deleteMemberById(int id);

    Long memberCount();

    Page<Members> getAllMembersPage(Pageable pageable);

    Members registerNewMemberAccount(Members member) throws IllegalStateException;

    void saveRegisteredMember(Members member);
}
