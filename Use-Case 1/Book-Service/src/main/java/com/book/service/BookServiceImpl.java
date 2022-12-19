package com.book.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.Book;
import com.book.entity.Subscription;
import com.book.exception.BookNotFoundExceptionHandler;
import com.book.repo.IBookRepo;
import com.book.repo.ISubscriptionRepo;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	IBookRepo bookRepo;
	
	@Autowired
	ISubscriptionRepo subscriptionRepo;

	@Override
	public List<Book> searchBooks(String category, String title, String author, Long price) {
		return bookRepo.searchBooks(category, title, author, price, true);
	}

	@Override
	public Long createBook(Book book, String username) {		
		book.setPublishedDate(LocalDate.now());
		book.setPublisher(username);
		Book newBook = bookRepo.save(book);
		return newBook.getBookID();
	}

	@Override
	public Book editBook(Book book, String username, Long bookID) {
		Book existingBook = bookRepo.findById(bookID).orElseThrow(()->new BookNotFoundExceptionHandler("Book", "id", bookID));
		existingBook.setLogo(book.getLogo());
		existingBook.setTitle(book.getTitle());
		existingBook.setCategory(book.getCategory());
		existingBook.setPrice(book.getPrice());
		existingBook.setAuthor(book.getAuthor());
		existingBook.setPublisher(book.getPublisher());
		existingBook.setPublishedDate(book.getPublishedDate());
		existingBook.setContent(book.getContent());
		existingBook.setActive(book.isActive());
		bookRepo.save(existingBook);
		return existingBook;
	}

	@Override
	public boolean editStatusofBook(Long bookID) {
		Book existingBook = bookRepo.findById(bookID).orElseThrow(()->new BookNotFoundExceptionHandler("Book", "id", bookID));
		existingBook.setActive(!existingBook.isActive());
		bookRepo.save(existingBook);
		return existingBook.isActive();
	}

	@Override
	public boolean getBookStatus(Long bookID) {
		Book existingBook = bookRepo.findById(bookID).orElseThrow(()->new BookNotFoundExceptionHandler("Book", "id", bookID));
		return existingBook.isActive();
	}

	@Override
	public Book getBookbyId(Long bookID) {
		Book book = bookRepo.findById(bookID).orElseThrow(()->new BookNotFoundExceptionHandler("Book", "id", bookID));
		return book;
	}


	@Override
	public Long subscribe(Long userId, Long bookId) {
		Subscription subscription = new Subscription();
		subscription.setBookID(bookId);
		subscription.setUserID(userId);
		subscription.setSubscriptionDateTime(LocalDateTime.now());
		subscription.setActive(true);
		Subscription newSubscription = subscriptionRepo.save(subscription);
		return newSubscription.getId();
	}

	@Override
	public Book getSubcribedBookByTitle(String title) {
		return bookRepo.findByTitle(title);
	}

	@Override
	public List<Book> getSubcribedBooksByUserId(Long userId) {
		List<Subscription> subscriptions = subscriptionRepo.findByUserID(userId);
		List<Book> books = new ArrayList<>();
		subscriptions.stream().forEach(subcription -> books.add(bookRepo.findById(subcription.getUserID()).get()));
		return books;
	}

	@Override
	public String cancelSubscription(Integer subscriptionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
