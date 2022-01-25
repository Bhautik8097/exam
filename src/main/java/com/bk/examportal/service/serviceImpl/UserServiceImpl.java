package com.bk.examportal.service.serviceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bk.examportal.model.User;
import com.bk.examportal.model.UserRole;
import com.bk.examportal.repository.RoleRepository;
import com.bk.examportal.repository.UserRepository;
import com.bk.examportal.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		  User local = this.userRepository.findByUserName(user.getUserName());
		  if( local != null) {
			  System.out.println("User is already there !!");
			  throw new Exception("User already present !!");
		  } else {
			  
			  for(UserRole ur:userRoles) {
				  roleRepository.save(ur.getRole());
			  }
			  
			  user.getUserRoles().addAll(userRoles);
			  local = this.userRepository.save(user);
			  
		  }
		  
		  return local;
	}


	@Override
	public User findByUserName(String username) {
		
		return userRepository.findByUserName(username);
	}


	@Override
	public User updateUser(User user) {
		
		
		return userRepository.save(user);
		
	}


	@Override
	public void deleteUser(String userName) {
		
		User user = userRepository.findByUserName(userName);
		
		userRepository.delete(user);

		
	}

}
