package com.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.dto.CustomJwt;
import com.auth.entity.UserMaster;
import com.auth.service.AuthService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/generateToken")
	public ResponseEntity<CustomJwt> generateToken(@RequestBody UserMaster userMaster) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userMaster.getUserName(), userMaster.getUserPassword()));

		if (authentication.isAuthenticated())
			return ResponseEntity.ok((CustomJwt)authService.generateToken(userMaster));
		else
			throw new RuntimeException("Invaild Access");
	}
	
	
	@GetMapping("/validateToken")
	public String validateToken(@RequestParam("token") String token) 
	{
		
		return authService.validateToken(token);
	}
	

}
