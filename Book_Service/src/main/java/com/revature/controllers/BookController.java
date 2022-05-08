package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	/**
	 * This method returns all the books in the database for the user to view.
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<Book>> findAll(){
		ResponseEntity<List<Book>> httpResponse = new ResponseEntity<>(this.bookService.findAll(), HttpStatus.OK);
		return httpResponse;
	}
	/**
	 * This method allows the user to make a new book in the database. Book id is not needed since it is auto-generated.
	 * This method allows for communication from the front service to save a new book as well.
	 * @param book
	 * @return
	 */
	@CrossOrigin("http://localhost:8082")
	@PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String save(@RequestBody Book book) {
		this.bookService.save(book);
		return book.getName() + " was added!";
	}
	/**
	 * This method removes a book from the database.
	 * @param book
	 */
	@DeleteMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@RequestBody Book book) {
		this.bookService.delete(book);
	}
	/**
	 * This method finds books within a cost range and displays them for the user. The lower bound is cost1 and the upper bound is cost2.
	 * 
	 * @param cost1
	 * @param cost2
	 * @return
	 */
	@GetMapping(value = "/cost")
	public ResponseEntity<List<Book>> findAllByCostBetween(@RequestParam int cost1, @RequestParam int cost2){
		ResponseEntity<List<Book>> httpResponse = new ResponseEntity<>(this.bookService.findAllByCost(cost1, cost2), HttpStatus.OK);
		return httpResponse;
	}
	/**
	 * This method allows a user to look for a book by name.
	 * @param name
	 * @return
	 */
	@GetMapping(value = "/name/{name}")
	public List<Book> getBookbyName(@PathVariable String name) {
		return bookService.findAllByName(name);
	}
	/**
	 * This method allows for a user to find a book by its id number.
	 * It also allows for the front service to communicate through here and find a book of that id number.
	 * @param id
	 * @return
	 */
	@CrossOrigin("http://localhost:8082")
	@GetMapping(value = "/id/{id}")
	public Book getBook(@PathVariable int id) {
		return bookService.getBook(id);
	}
	
	
}
