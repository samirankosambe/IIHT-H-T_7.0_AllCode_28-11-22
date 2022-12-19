package com.book.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.book.entity.Book;

@Repository
public interface IBookRepo extends JpaRepository<Book, Long> {
	
	@Query("select b from Book b where b.price =:price and b.category=:category and b.title=:title and b.author=:author and b.publisher=:publisher and b.active=:active")
	List<Book> searchBooks(String category, String title, String author, Long price, boolean active);

	Book findByTitle(String title);
	
}
