package com.bk.examportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bk.examportal.config.JwtUtils;
import com.bk.examportal.model.JwtRequest;
import com.bk.examportal.model.JwtResponse;
import com.bk.examportal.service.serviceImpl.UserDetailsServiceImpl;

@Controller
@CrossOrigin("*")
public class AuthenticateController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		try {
			authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("User not found ");
		}
		
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtils.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token)); 
	}

	private void authenticate(String username,String password) throws Exception {
		try {

		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED" +e.getMessage());
		}catch(BadCredentialsException e) {
			throw new Exception("Invalid Credentials "+e.getMessage());
		}
	}
}
