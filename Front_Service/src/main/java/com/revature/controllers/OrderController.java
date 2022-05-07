package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.dtos.DiceDTO;
import com.revature.models.Book;
import com.revature.models.Order;
import com.revature.services.OrderService;

@RestController("orderController")
@RequestMapping("/order")
public class OrderController {

	private OrderService orderService;
	
	@Autowired
	private DiceController diceController;
	
	@Autowired
	public RestTemplate restTemplate;
	
	@Autowired
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping(name = "/neworder")
	public String save(@RequestBody Order order) {
		this.orderService.save(order);
		Book book = restTemplate.getForObject("http://localhost:8081/book/id/" + order.getBookId(), Book.class);
		book.setQuant(book.getQuant()-order.getBookQuantity());
		restTemplate.postForEntity("http://localhost:8081/book/new", book, String.class);
		DiceDTO dice = this.diceController.findById(order.getDiceId());
		dice.setQuant(dice.getQuant()-order.getDiceQuantity());
		this.diceController.saveNewDice(dice);
		return "Order Number: " + order.getId() + " was placed with the system!";
	}
	
	
}
