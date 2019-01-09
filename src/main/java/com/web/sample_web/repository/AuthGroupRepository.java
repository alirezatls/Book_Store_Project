package com.web.sample_web.repository;

import com.web.sample_web.entity.AuthGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthGroupRepository extends JpaRepository<AuthGroup,Integer> {
    List<AuthGroup> findByUserName(String userName);
}
