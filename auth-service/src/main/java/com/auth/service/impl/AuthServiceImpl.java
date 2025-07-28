package com.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.dto.CustomJwt;
import com.auth.entity.UserMaster;
import com.auth.service.AuthService;
import com.auth.utils.JwtUtils;

@Service
public class AuthServiceImpl implements AuthService{

	@Autowired
	private JwtUtils jwtUtils;
	
	@Override
	public CustomJwt generateToken(UserMaster userMaster) {
		
		CustomJwt customJwt = new CustomJwt();
		
		customJwt.setUserName(userMaster.getUserName());
		customJwt.setUserEmail(userMaster.getUserEmail());
		customJwt.setToken(jwtUtils.generateToken(userMaster.getUserName()));
		
		return customJwt;
	}

	@Override
	public String validateToken(String token) {
		// TODO Auto-generated method stub
		return jwtUtils.validateToken(token);
	}

}
