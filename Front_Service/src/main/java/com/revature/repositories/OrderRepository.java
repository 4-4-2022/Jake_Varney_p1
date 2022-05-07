package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Order;

@Repository("orderRepository")
public interface OrderRepository extends JpaRepository<Order, String>{

	public List<Order> findAll();
	public <S extends Order> S save(Order order);
}
