package com.web.sample_web.repository;

import com.web.sample_web.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Integer> {
    Member findByUserName(String userName);
    Member findByEmail(String email);
    Member findByUserNameAndPassword(String userName,String password);
    Integer deleteByMemberId(int id);
}
