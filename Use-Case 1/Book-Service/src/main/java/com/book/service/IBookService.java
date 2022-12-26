package com.book.service;

import java.util.List;

import com.book.entity.Book;
import com.book.entity.Subscription;

public interface IBookService {
	
	// Guest, Reader and Author can search books
	List<Book> searchBooks(Book book);
	
	//Reader can subscribe a book
	Long subscribe(Long userId, Long bookId);
	
	//Reader can fetch all subscribed books
	List<Subscription> getSubcribedBooksByUserId(Long userId);
	
	//Reader can fetch a subscribed book
	Subscription getBookBySubscriptionId(Long subscriptionId);
	
	//Reader can read a book content
	String getBookContentBySubscriptionId(Long subscriptionId);
	
	//Reader can  cancel subscription within 24hrs of subscription
	boolean cancelSubscription(Long subscriptionId);

	//Author can create a book
	Long createBook(Book book);

	//Author can edit a book
	Book editBook(Book book, Long bookID);
	
	//Author can block/unblock a book
	boolean editStatusofBook(Long bookID);
	
	List<Book> getAllBooksByAuthor(String author);
	
	boolean getBookStatus(Long bookId);

	Book getBookbyId(Long bookID);
	
	List<Book> getAllBooks();

}
