package com.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.model.Order;



public interface OrderRepository extends JpaRepository<Order,Integer> {

}
