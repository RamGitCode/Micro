package com.customer.exception;

public class CustomerNotFoundException extends RuntimeException
{
	

	public CustomerNotFoundException(Long  id)
	{
		super("Customer Not Found for id " + id);
	}
}
