package com.revature;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.models.Book;
import com.revature.models.Dice;
import com.revature.models.Order;
import com.revature.repositories.OrderRepository;
import com.revature.services.OrderService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class FrontServiceApplicationTests {

	@InjectMocks
	private OrderService orderService;
	
	@Mock
	private OrderRepository orderRepository;
	
	private List<Order> mockOrders;
	
	@BeforeAll
	public void setup() {
		
		this.orderService = new OrderService();
		this.mockOrders = new ArrayList();
		this.mockOrders.add(new Order(2, 5, 3, 4, 5));
		this.mockOrders.add(new Order(3, 8, 3, 6, 5));
		this.mockOrders.add(new Order(4, 5, 3, 4, 5));
		this.mockOrders.add(new Order(5, 2, 3, 7, 5));
		this.mockOrders.add(new Order(6, 12, 3, 4, 5));
	}
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testFindAllOrders() {
		Mockito.when(this.orderRepository.findAll()).thenReturn(this.mockOrders);
		List<Order> orders = this.orderService.findAll();
		Assertions.assertEquals(5, orders.size());
	}
	
	
	@Test
	public void testNegOrderBookQ() {
		Order order = new Order();
		order.setBookQuantity(-1);
		Assertions.assertEquals(0, order.getBookQuantity());
	}
	
	@Test
	public void testOrderBookQ() {
		Order order = new Order();
		order.setBookQuantity(2);
		Assertions.assertEquals(2, order.getBookQuantity());
	}
	
	@Test
	void testNegOrderDiceId() {
		Order order = new Order();
		order.setDiceId(-1);
		Assertions.assertEquals(0, order.getDiceId());
	}
	
	@Test
	void testOrderDiceId() {
		Order order = new Order();
		order.setDiceId(5);
		Assertions.assertEquals(5, order.getDiceId());
	}

	@Test
	void testNegOrderBookId() {
		Order order = new Order();
		order.setBookId(-1);
		Assertions.assertEquals(0, order.getBookId());
	}
	
	@Test
	void testOrderBookId() {
		Order order = new Order();
		order.setBookId(5);
		Assertions.assertEquals(5, order.getBookId());
	}
	
	@Test
	void testNegOrderDiceQ() {
		Order order = new Order();
		order.setDiceQuantity(-1);
		Assertions.assertEquals(0, order.getDiceQuantity());
	}
	
	@Test
	void testOrderDiceQ() {
		Order order = new Order();
		order.setDiceQuantity(5);
		Assertions.assertEquals(5, order.getDiceQuantity());
	}
	@Test
	void testNegDiceCost() {
		Dice dice = new Dice();
		dice.setCost(-1);
		Assertions.assertEquals(0, dice.getCost());
	}
	
	@Test
	void testDiceCost() {
		Dice dice = new Dice();
		dice.setCost(5);
		Assertions.assertEquals(5, dice.getCost());
	}
	
	@Test
	void testNegDiceQ() {
		Dice dice = new Dice();
		dice.setQuant(-1);
		Assertions.assertEquals(0, dice.getQuant());
	}
	
	@Test
	void testDiceQ() {
		Dice dice = new Dice();
		dice.setQuant(5);
		
	
	}
	@Test
	void testNegBookQ() {
		Book book = new Book();
		book.setQuant(-1);
		Assertions.assertEquals(0, book.getQuant());
	}
	
	@Test
	void testBookQ() {
		Book book = new Book();
		book.setQuant(5);
		Assertions.assertEquals(5, book.getQuant());
	}
	
	@Test
	void testNegBookCost() {
		Book book = new Book();
		book.setQuant(-1);
		Assertions.assertEquals(0, book.getCost());
	}
	
	@Test
	void testBookCost() {
		Book book = new Book();
		book.setCost(5);
		Assertions.assertEquals(5, book.getCost());
	}
}
