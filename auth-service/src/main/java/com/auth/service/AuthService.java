package com.auth.service;

import com.auth.dto.CustomJwt;
import com.auth.entity.UserMaster;

public interface AuthService 
{

	CustomJwt  generateToken(UserMaster userMaster);
	
	 String  validateToken(String token);
	

}
