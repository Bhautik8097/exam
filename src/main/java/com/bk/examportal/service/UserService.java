package com.bk.examportal.service;

import java.util.Set;

import com.bk.examportal.model.User;
import com.bk.examportal.model.UserRole;

public interface UserService {

	public User createUser(User user, Set<UserRole> userRoles) throws Exception;
	public User findByUserName(String username);
	
	public User updateUser(User user);
	
	public void deleteUser(String userName);
}
