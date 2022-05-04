package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Book;
import com.revature.service.BookService;

@RestController("bookController")
@RequestMapping("/book")
public class BookController {

	private BookService bookService;
	
	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> findAll(){
		ResponseEntity<List<Book>> httpResponse = new ResponseEntity<>(this.bookService.findAll(), HttpStatus.OK);
		return httpResponse;
	}
	
	@PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String save(@RequestBody Book book) {
		this.bookService.save(book);
		return book.getName() + " was added!";
	}
	
	@DeleteMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@RequestBody Book book) {
		this.bookService.delete(book);
	}
	
	@GetMapping(value = "/cost")
	public ResponseEntity<List<Book>> findAllByCostBetween(@RequestParam int cost1, @RequestParam int cost2){
		ResponseEntity<List<Book>> httpResponse = new ResponseEntity<>(this.bookService.findAllByCost(cost1, cost2), HttpStatus.OK);
		return httpResponse;
	}

	
	
}
