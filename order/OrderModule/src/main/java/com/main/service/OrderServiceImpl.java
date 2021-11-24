package com.main.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.OrderRepository;
import com.main.model.Order;

@Service
@Transactional
public class OrderServiceImpl implements OrderServiceIntf {

	@Autowired
	OrderRepository ordrep;
	public void saveOrder(Order order)
	{
		ordrep.save(order);
		
	}
	public List<Order> fetchDetails()
	{
		return ordrep.findAll();
		
	}
	
	public Optional<Order> viewOrderDetails(int orderId) {
		
		return ordrep.findById(orderId);
	}
	@Override
	public Optional<Order> buyUsingOrderId(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
