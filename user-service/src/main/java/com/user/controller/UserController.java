package com.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.UserMaster;
import com.user.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/allUsers")
	public ResponseEntity<List<UserMaster>> getAllUsers()
	{
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@PostMapping("/saveUser")
	public ResponseEntity<UserMaster> saveUser(@RequestBody UserMaster userMaster) {
		//TODO: process POST request
		userMaster.setUserPassword(passwordEncoder.encode(userMaster.getUserPassword()));
		return ResponseEntity.ok(userService.saveUser(userMaster));
	}
	
	@GetMapping("/getUsersById/{id}")
	public ResponseEntity< Optional<UserMaster>> getUsersById(@PathVariable("id") Long id)
	{
		return ResponseEntity.ok(userService.getUsersById(id));
	}
	

}
