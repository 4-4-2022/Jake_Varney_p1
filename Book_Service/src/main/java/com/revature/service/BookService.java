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
		


}
