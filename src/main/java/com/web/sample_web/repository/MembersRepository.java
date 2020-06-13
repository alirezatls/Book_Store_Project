package com.web.sample_web.repository;

import com.web.sample_web.domain.Members;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersRepository extends JpaRepository<Members,Integer> {
    Members findByUserName(String userName);
    Members findByEmail(String email);
    Members findByUserNameAndPassword(String userName, String password);
    Integer deleteByMemberId(int id);
}
