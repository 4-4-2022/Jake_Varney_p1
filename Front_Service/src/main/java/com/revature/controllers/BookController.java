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
	
	/**
	 * This method creates a new book for the site to sell. It takes an object of type Book and saves it to the database.
	 * @param book
	 * @return
	 */
	@PostMapping("/book/newbook")
	public String newBook(@RequestBody BookDTO book) {
		ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8081/book/new", book, String.class);
		return response.getBody();
	}
	/**
	 * This method displays a book of the corresponding id for the user to view its contents.
	 * @param id
	 * @return
	 */
	@GetMapping("/book/listid/{id}")
	public Book getBook(@PathVariable int id) {
		Book book = restTemplate.getForObject("http://localhost:8081/book/id/" + id, Book.class);
		return book;
	}
}
