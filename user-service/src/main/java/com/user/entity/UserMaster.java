package com.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
@Entity
public class UserMaster 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String userAddress;
	private String userEmail;
	private String userMobile;
	private String userName;
	private String userPassword;
	private String userRole;
	public UserMaster() {
		super();
	}
	
	

}
