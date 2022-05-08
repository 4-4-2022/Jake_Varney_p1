package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Order;
import com.revature.repositories.OrderRepository;

@Service("orderService")
public class OrderService {

	private OrderRepository orderRepository;
	
	@Autowired
	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	/**
	 * This method returns all orders from the table for the user to view past orders.
	 * @return
	 */
	public List<Order> findAll(){
		return this.orderRepository.findAll();
	}
	/**
	 * This method saves an order to the system.
	 * @param order
	 */
	public void save(Order order) {
		this.orderRepository.save(order);
	}
	
	
}
