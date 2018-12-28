package com.web.sample_web.repository;

import com.web.sample_web.entity.Member;
import com.web.sample_web.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Integer> {

    VerificationToken findByToken(String token);

    VerificationToken findByMember(Member member);
}