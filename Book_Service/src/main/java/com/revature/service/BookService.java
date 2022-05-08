package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Book;
import com.revature.repository.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepository;
	
	@Autowired
	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> findAll() {
		return this.bookRepository.findAll();
	}

	public void save(Book book) {
		this.bookRepository.save(book);
	}

	public void delete(Book book) {
		this.bookRepository.delete(book);
	}
	
	public List<Book> findAllByCost(int cost1, int cost2){
		return this.bookRepository.findAllByCostBetween(cost1, cost2);
		
	}
	
	public List<Book> findAllByName(String name){
		return this.bookRepository.findAllByName(name);
	}
	
	public Book getBook(int id) {
		List<Book> books = this.bookRepository.findAll();
		for(Book book : books) {
			if(book.getId() == id) {
				return this.bookRepository.findById(id);
			}
		}
		return null;
	}
	
	public Book findById(int id) {
		return this.bookRepository.findById(id);
	}
	
//	public Book convertToDisplay(Book book) {
//		return new Book(book.getId(), book.getName(), book.getDescription(), book.getCost());
//	}

}
