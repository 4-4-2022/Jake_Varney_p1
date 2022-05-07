package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.dtos.BookDTO;
import com.revature.models.Book;

@RestController
public class BookController {

	@Autowired
	private RestTemplate restTemplate;
	
	
	@PostMapping("/book/newbook")
	public String newBook(@RequestBody BookDTO book) {
		ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8081/book/new", book, String.class);
		return response.getBody();
	}
	
	@GetMapping("/book/listid/{id}")
	public Book getBook(@PathVariable int id) {
		Book book = restTemplate.getForObject("http://localhost:8081/book/id/" + id, Book.class);
		return book;
	}
}
