package com.web.sample_web.dao;

import com.web.sample_web.entity.Members;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberDao {

    Members saveMember(Members m);

    Members getByUserName(String userName);

    Members getByUserNameAndPassword(String userName, String password);

    List<Members> getAllMember();

    Integer deleteMemberById(int id);

    Long memberCount();

    Page<Members> getAllMembersPage(Pageable pageable);



}
