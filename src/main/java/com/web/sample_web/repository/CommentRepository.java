package com.web.sample_web.repository;

import com.web.sample_web.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer>{
}
