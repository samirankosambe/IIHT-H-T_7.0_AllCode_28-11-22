package com.book.service;

import java.util.List;

import com.book.entity.Book;

public interface IBookService {
	
	// Guest, Reader and Author can search books
	List<Book>searchBooks(Book book);
	
	//Reader can subscribe a book
	Integer subscribe(Integer userId, Integer bookId);
	
	//Reader can fetch all subscribed books
	List<Book> getSubcribedBooksByUserId(Integer userId);
	
	//Reader can fetch a subscribed book
	Book getSubcribedBookByUserId(Integer userId);
	
	//Reader can read a book content
	Book getBookbyId(Integer bookID);
	
	//Reader can can subscription within 24hrs of subscription
	String cancelSubscription(Integer subscriptionId);

	//Author can create a book
	Integer createBook(Book book, String userID);

	//Author can edit a book
	Book editBook(Book book, Integer userID, Integer bookID);
	
	//Author can block/unblock a book
	String editStatusofBook(Integer bookID);
	
	String getBookStatus(Integer bookId);
	
	List<Book> getAllBooks();
}
