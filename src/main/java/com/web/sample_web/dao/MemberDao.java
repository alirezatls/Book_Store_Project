package com.web.sample_web.dao;

import com.web.sample_web.entity.Member;

import java.util.List;

public interface MemberDao {

    Member saveMember(Member m);

    Member getByUserName(String userName);

    Member getByUserNameAndPassword(String userName, String password);

    List<Member> getAllMember();

    Integer deleteMemberById(int id);

    Long memberCount();



}
