package com.book.controller;

import java.util.ArrayList;
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
import com.book.entity.Subscription;
import com.book.models.BookSubscription;
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
	public List<BookSubscription> getListofBooksSubscribed(@PathVariable("userId") Long userId){
		List<Subscription> subcriptions = bookService.getSubcribedBooksByUserId(userId);
		List<BookSubscription> bookSubscriptions = new ArrayList<>();
		for(Subscription subscription : subcriptions) {
			Book book = bookService.getBookbyId(subscription.getBookID());
			bookSubscriptions.add(new BookSubscription
					(book.getBookID(), subscription.getId(), subscription.getUserID(), book.getTitle(), book.getCategory(), book.getPrice(), book.getAuthor(), book.getPublisher()));
		}
		return bookSubscriptions;
	}
	
	@GetMapping("/subscribedBook/{subscriptionId}")
	public BookSubscription bookSubscribed(@PathVariable("subscriptionId") Long subscriptionId) {
		Subscription subscription = bookService.getBookBySubscriptionId(subscriptionId);
		Book book = bookService.getBookbyId(subscription.getBookID());
		return new BookSubscription
				(book.getBookID(), subscription.getId(), subscription.getUserID(), book.getTitle(), book.getCategory(), book.getPrice(), book.getAuthor(), book.getPublisher());
		
	}
	
	@GetMapping("/subscribedBook/{subscriptionId}/read")
	public String readSubscribed(@PathVariable("subscriptionId") Long subscriptionId) {
		return bookService.getBookContentBySubscriptionId(subscriptionId);
	}
	
	@GetMapping("/cancelSubscription/{subscriptionId}")
	public void updateSubscriptionStatus(@PathVariable("subscriptionId") Long subscriptionId) {
		bookService.cancelSubscription(subscriptionId);
	}
	
	@PostMapping("/add")
	public Long createBook(@RequestBody Book book) {
		return bookService.createBook(book);
	}
	@PutMapping("/update/{bookId}")
	public Book updateBook(@PathVariable("bookId") Long bookId, @RequestBody Book book) {
		return bookService.editBook(book, bookId);
	}
	
	@GetMapping("/changeBookStatus/{bookID}")
	public boolean changeBookStatus(@PathVariable("bookID") Long bookID) throws Exception{
		return bookService.editStatusofBook(bookID);
	}
	
	@GetMapping("get/all")
	public List<Book> getBooks(){
		return bookService.getAllBooks();
	}
		
}
