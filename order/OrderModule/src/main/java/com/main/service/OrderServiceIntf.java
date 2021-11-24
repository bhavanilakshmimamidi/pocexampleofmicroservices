package com.main.service;

import java.util.List;
import java.util.Optional;

import com.main.model.Order;

public interface OrderServiceIntf {

	void saveOrder(Order order);

	List<Order> fetchDetails();

	Optional<Order> viewOrderDetails(int orderId);

	Optional<Order> buyUsingOrderId(int orderId);

}
