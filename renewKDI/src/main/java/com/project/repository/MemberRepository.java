package com.project.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Member;

public interface MemberRepository extends JpaRepository<Member,Long>{
	
	boolean existsByUsername(String username);
	boolean existsByEmail(String email);
	Member findByEmail(String email);
	Member findByUsername(String username);
	
}
