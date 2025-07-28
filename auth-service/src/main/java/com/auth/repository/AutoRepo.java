package com.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.auth.entity.UserMaster;

@Repository
public interface AutoRepo extends JpaRepository<UserMaster, Long>
{

	//Optional<UserMaster> findByUsername(String username);

	Optional<UserMaster> findByuserName(String username);
	

}
