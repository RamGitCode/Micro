package com.customer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.Customer;
import com.customer.exception.CustomerAlreadyExistsException;
import com.customer.exception.CustomerNotFoundException;
import com.customer.repo.CustomerRepo;
import com.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService
{
	
	@Autowired
	private CustomerRepo customerRepo;
	
	public CustomerServiceImpl(CustomerRepo customerRepo) 
	{
		this.customerRepo = customerRepo;
		
	}

	@Override
	public List<Customer> fetchAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepo.findAll();
	}

	@Override
	public Optional<Customer> getCustomerById(Long id) {
		Optional<Customer> customer = customerRepo.findById(id);
		if(customer.isEmpty()) throw new CustomerNotFoundException(id);
		return customer;
	}

	@Override
	public Customer createCustomer(Customer newCustomer) {
		Customer customerByEmail = customerRepo.getCustomerByEmail(newCustomer.getEmail());
		if(customerByEmail != null) throw new CustomerAlreadyExistsException(newCustomer.getEmail());
		return customerRepo.save(newCustomer);
	}

	@Override
	public Customer updateCustomer(Customer newCustomer, Long id) {
		Optional<Customer> customer = customerRepo.findById(id);
		Customer custObj = null;
		if(customer.isPresent()) {
			custObj = customer.get();
			custObj.setName(newCustomer.getName());
			custObj.setEmail(newCustomer.getEmail());
			custObj.setLocation(newCustomer.getLocation());
		}
		return customerRepo.save(custObj);
	}

	@Override
	public String deleteCustomerById(Long id) {
		// TODO Auto-generated method stub
		
		Optional<Customer> customer = customerRepo.findById(id);
		Customer custObj = null;
		String deleteMsg = null;
		if(customer.isPresent()) {
			custObj = customer.get();
			customerRepo.delete(custObj);
			deleteMsg = "Customer Successfully Deleted for id: "+id;
		}
		return deleteMsg;
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		
		return customerRepo.getCustomerByEmail(email);
	}

}
