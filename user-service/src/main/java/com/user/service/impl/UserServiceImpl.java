package com.user.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.UserMaster;
import com.user.repo.UserRepo;
import com.user.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public List<UserMaster> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public UserMaster saveUser(UserMaster userMaster) {
		// TODO Auto-generated method stub
		return userRepo.save(userMaster);
	}

	@Override
	public Optional<UserMaster> getUsersById(Long id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id);
	}

	

}
