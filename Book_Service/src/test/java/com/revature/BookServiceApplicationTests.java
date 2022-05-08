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
import com.revature.repository.BookRepository;
import com.revature.service.BookService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class BookServiceApplicationTests {

	@InjectMocks
	private BookService bookService;
	
	@Mock
	private BookRepository bookRepository;
	
	private List<Book> mockBooks;
	
	@BeforeAll
	public void setup() {
		MockitoAnnotations.openMocks(this);
		this.mockBooks = new ArrayList();
		this.mockBooks.add(new Book(1, "book1", "happy man", 5, 25));
		this.mockBooks.add(new Book(2, "book2", "happy man", 10, 25));
		this.mockBooks.add(new Book(3, "book3", "happy man", 6, 25));
		this.mockBooks.add(new Book(4, "book4", "happy man", 58, 25));
		this.mockBooks.add(new Book(5, "book5", "happy man", 23, 25));
	}
	
	@Test
	void testFindAll() {
		Mockito.when(this.bookRepository.findAll()).thenReturn(this.mockBooks);
		List<Book> books = this.bookService.findAll();
		Assertions.assertEquals(5, books.size());
	}
	
	@Test
	void testFindByCost() {
		int cost1 = 0;
		int cost2 = 6;
		Mockito.when(this.bookRepository.findAllByCostBetween(cost1, cost2)).thenReturn(this.mockBooks.subList(1, 3));
		List<Book> books = this.bookService.findAllByCost(cost1, cost2);
		Assertions.assertEquals(2, books.size());
	}
	
	@Test
	void testFindById() {
		int id = 1;
		Mockito.when(this.bookRepository.findById(id)).thenReturn(this.mockBooks.get(0));
		Book book = this.bookService.findById(id);
		Assertions.assertEquals(1, book.getId());
	}
	
	@Test
	void contextLoads() {
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
