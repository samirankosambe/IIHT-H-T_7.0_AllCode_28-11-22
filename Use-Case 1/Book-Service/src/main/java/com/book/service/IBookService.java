package com.book.service;

import java.util.List;

import com.book.entity.Book;

public interface IBookService {
	
	// Guest, Reader and Author can search books
	List<Book>searchBooks(String category, String title, String author, Long price);
	
	//Reader can subscribe a book
	Long subscribe(Long userId, Long bookId);
	
	//Reader can fetch all subscribed books
	List<Book> getSubcribedBooksByUserId(Long userId);
	
	//Reader can fetch a subscribed book
	Book getSubcribedBookByTitle(String title);
	
	//Reader can read a book content
	Book getBookbyId(Long bookID);
	
	//Reader can can subscription within 24hrs of subscription
	boolean cancelSubscription(Long subscriptionId);

	//Author can create a book
	Long createBook(Book book, String username);

	//Author can edit a book
	Book editBook(Book book, String username, Long bookID);
	
	//Author can block/unblock a book
	boolean editStatusofBook(Long bookID);
	
	boolean getBookStatus(Long bookId);

}
