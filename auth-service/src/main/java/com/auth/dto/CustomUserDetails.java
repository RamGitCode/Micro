package com.auth.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.auth.entity.UserMaster;

public class CustomUserDetails implements UserDetails
{
	private UserMaster userMaster;
	public CustomUserDetails(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority>   grantedAuthority = new ArrayList<>();
		grantedAuthority.add(new SimpleGrantedAuthority(this.userMaster.getUserRole()));
		return grantedAuthority;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.userMaster.getUserPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userMaster.getUserName();
	}

}
