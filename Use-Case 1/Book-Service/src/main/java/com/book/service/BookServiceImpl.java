package com.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.Book;
import com.book.repo.IBookRepo;
import com.book.repo.ISubscriptionRepo;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	IBookRepo bookRepo;
	
	@Autowired
	ISubscriptionRepo subscriptionRepo;

	@Override
	public List<Book> searchBooks(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer createBook(Book book, String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book editBook(Book book, Integer userID, Integer bookID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editStatusofBook(Integer bookID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBookStatus(Integer bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getBookbyId(Integer bookID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer subscribe(Integer userId, Integer bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getSubcribedBookByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getSubcribedBooksByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String cancelSubscription(Integer subscriptionId) {
		// TODO Auto-generated method stub
		return null;
	}
}
