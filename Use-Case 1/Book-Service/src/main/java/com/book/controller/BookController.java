package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.Book;
import com.book.service.IBookService;

@RestController
@CrossOrigin
public class BookController {
	
	@Autowired
	IBookService bookService;
	
	@GetMapping("/search")
	public List<Book> searchBooks(Book book) {
		List<Book> books = bookService.searchBooks(book);
		return books;
	}
	
	@GetMapping("/subscribe/{bookId}/{userId}")
	public Long subscribeBook(@PathVariable("bookId") Long bookId,@PathVariable("userId") Long userId) throws Exception{
		return bookService.subscribe(userId, bookId);
	}
	
	@GetMapping("/booksSubscribedById/{userId}")
	public List<Book> getListofBooksSubscribed(@PathVariable("userId") Long userId){
		List<Book> books = bookService.getSubcribedBooksByUserId(userId);
		return books;
	}
	
	@GetMapping("/subscribedBook/{subscriptionId}")
	public Book bookSubscribed(@PathVariable("subscriptionId") Long subscriptionId) {
		return bookService.getBookBySubscriptionId(subscriptionId);
	}
	
	@GetMapping("/subscribedBook/{subscriptionId}/read")
	public String readSubscribed(@PathVariable("subscriptionId") Long subscriptionId) {
		return bookService.getBookContentBySubscriptionId(subscriptionId);
	}
	
	@PutMapping("/cancelSubscription/{subscriptionId}")
	public void updateSubscriptionStatus(@PathVariable("subscriptionId") Long subscriptionId) {
		bookService.cancelSubscription(subscriptionId);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> createBook(@RequestBody Book book) {
		return new ResponseEntity<>(bookService.createBook(book), HttpStatus.OK);
	}
	@PutMapping("/update/{bookId}")
	public ResponseEntity<?> updateBook(@PathVariable("bookId") Long bookId, @RequestBody Book book) {
		return new ResponseEntity<>(bookService.editBook(book, bookId), HttpStatus.OK);
	}
	
	@PostMapping("/changeBookStatus/{bookID}")
	public boolean changeBookStatus(@PathVariable("bookID") Long bookID) throws Exception{
		return bookService.editStatusofBook(bookID);
	}
		
}
