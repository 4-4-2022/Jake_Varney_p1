package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Book;

@Repository("bookRepository")
public interface BookRepository extends JpaRepository<Book, String>{

	public List<Book> findAll();
	public <S extends Book> S save(Book book);
	public void delete(Book book);
	public List<Book> findAllByCostBetween(int cost1, int cost2);
}
