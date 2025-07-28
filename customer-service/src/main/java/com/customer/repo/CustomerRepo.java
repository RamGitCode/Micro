package com.customer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>
{
	Customer getCustomerByEmail(String email);

}
