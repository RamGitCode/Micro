package com.auth.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth.dto.CustomUserDetails;
import com.auth.entity.UserMaster;
import com.auth.repository.AutoRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private AutoRepo autoRepo;

	public CustomUserDetailsService(AutoRepo autoRepo2) {
		this.autoRepo = autoRepo2;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<UserMaster> byName = autoRepo.findByuserName(username);
		return byName.map(CustomUserDetails::new).orElseThrow(()-> new RuntimeException("Invalid access"));
	}
	
	

}
