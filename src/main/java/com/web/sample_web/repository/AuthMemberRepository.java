package com.web.sample_web.repository;

import com.web.sample_web.domain.AuthMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthMemberRepository extends JpaRepository<AuthMember,Integer> {
    List<AuthMember> findByUserName(String userName);
}
