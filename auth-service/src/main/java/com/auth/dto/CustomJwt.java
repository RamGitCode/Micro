package com.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class CustomJwt 
{

	private String userName;
	private String userEmail;
	private String token;
	public CustomJwt() {
		//super();
	}
	
	
}
