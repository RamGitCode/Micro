package com.user.service;

import java.util.List;
import java.util.Optional;

import com.user.entity.UserMaster;

public interface UserService 
{
	
	
	List<UserMaster> getAllUsers();

	UserMaster saveUser(UserMaster userMaster);

	 Optional<UserMaster> getUsersById(Long id);

}
