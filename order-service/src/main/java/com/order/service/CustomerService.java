package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.client.CustomerClient;
import com.order.model.Customer;
import com.order.model.CustomerResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CustomerService 
{
	@Autowired
	private CustomerClient customerClient;
	
	
	@CircuitBreaker(name = "customerServiceCB", fallbackMethod = "fallbackGetCustomer")
	public CustomerResponse getCustomer(long id) 
	{ 
		CustomerResponse customer = new CustomerResponse();
		
		Customer customerById = customerClient.getCustomerById(id);
		if(customerById != null)
		{
			customer.setCustomer(customerById);
			customer.setIsError(false);
		}
		
		return customer;
	}
	
	
	public CustomerResponse fallbackGetCustomer(Long id, Throwable t)
	{
		CustomerResponse customer = new CustomerResponse();
		customer.setIsError(true);
		customer.setErrorMsg("Customer service is temporarily Unavailable please try letter");
		
		return customer;
	}

}
