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
	/**
	 * This method takes in an order from the user, consisting of: bookId, bookQuantity, diceId, and diceQuantity.
	 * This method then takes in and saves the order to the database and adjusts the quantities of the books ordered.
	 * @param order
	 * @return
	 */
	@PostMapping(name = "/neworder")
	public String save(@RequestBody Order order) {
		String diceQNotEnough = null;
		String bookQNotEnough = null;
		boolean diceQCk = true;
		boolean bookQCk = true;
		this.orderService.save(order);
		Book book = restTemplate.getForObject("http://localhost:8081/book/id/" + order.getBookId(), Book.class);
		if(order.getBookQuantity()<book.getQuant()) {
			book.setQuant(book.getQuant()-order.getBookQuantity());
		}else {
			bookQNotEnough = " Unfortunately there are not that many of that book left.";
			bookQCk = false;
		}
		DiceDTO dice = this.diceController.findById(order.getDiceId());
		if(order.getDiceQuantity()<dice.getQuant()) {
			dice.setQuant(dice.getQuant()-order.getDiceQuantity());
		}else {
			diceQNotEnough = " Unfortunately there are not that many of that dice left.";
			diceQCk = false;
		}
		if(bookQCk && diceQCk) {
			restTemplate.postForEntity("http://localhost:8081/book/new", book, String.class);
			this.diceController.saveNewDice(dice);
			return "Order Number: " + order.getId() + " was placed with the system!";
		}else {
			return bookQNotEnough + diceQNotEnough;
		}

	}
	
	
}
