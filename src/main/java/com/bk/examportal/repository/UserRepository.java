package com.bk.examportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bk.examportal.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public User findByUserName(String username);
	
	
}
