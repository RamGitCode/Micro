package com.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.entity.Orders;
import com.order.repository.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService
{
	@Autowired
	private OrderRepo orderRepo;
	
	public OrderServiceImpl(OrderRepo orderRepo)
	{
		this.orderRepo = orderRepo;
	}

	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepo.findAll();
	}

	@Override
	public Orders createOrder(Orders order) {
		// TODO Auto-generated method stub
		return orderRepo.save(order);
	}

}
