package com.book.service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.Book;
import com.book.entity.Subscription;
import com.book.exception.BookNotFoundExceptionHandler;
import com.book.exception.SubscriptionNotFoundExceptionHandler;
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
		return bookRepo.searchBooks(book.getCategory(), book.getTitle(), book.getAuthor(), book.getPrice(), book.getPublisher(), true);
	}
	
	@Override
	public Long subscribe(Long userId, Long bookId) {
		Book book = bookRepo.findById(bookId).orElseThrow(() -> new BookNotFoundExceptionHandler("Book", "id", bookId));
		Subscription subscription = new Subscription();
		subscription.setBookID(bookId);
		subscription.setUserID(userId);
		subscription.setSubscriptionDateTime(LocalDateTime.now());
		subscription.setActive(true);
		subscription.setInvoice("The full amount for the book is: " + book.getPrice() + ". The Book is subcribed on: " + LocalDateTime.now());
		Subscription newSubscription = subscriptionRepo.save(subscription);
		return newSubscription.getId();
	}

	@Override
	public List<Subscription> getSubcribedBooksByUserId(Long userId) {
		return subscriptionRepo.findByUserID(userId);
		
	}
	
	@Override
	public Subscription getBookBySubscriptionId(Long subscriptionId) {
		return subscriptionRepo.findById(subscriptionId)
				.orElseThrow(() -> new SubscriptionNotFoundExceptionHandler("id", subscriptionId));
	}

	@Override
	public String getBookContentBySubscriptionId(Long subscriptionId) {
		Subscription subscription = subscriptionRepo.findById(subscriptionId)
				.orElseThrow(() -> new SubscriptionNotFoundExceptionHandler("id", subscriptionId));
		Book book = bookRepo.findById(subscription.getBookID()).orElseThrow(() -> new BookNotFoundExceptionHandler("Book", "id", subscription.getBookID()));
		return book.getContent();
	}

	@Override
	public boolean cancelSubscription(Long subscriptionId) {
		Subscription subscription = subscriptionRepo.findById(subscriptionId)
				.orElseThrow(() -> new SubscriptionNotFoundExceptionHandler("id", subscriptionId));
		Duration duration = Duration.between(subscription.getSubscriptionDateTime(), LocalDateTime.now());
		Subscription cancelledSubscription = subscription;
		if(duration.toHours() <= 24) {
			subscription.setActive(false);
			cancelledSubscription = subscriptionRepo.save(subscription);
		}
		return cancelledSubscription.isActive();
	}

	@Override
	public Long createBook(Book book) {
		book.setPublishedDate(LocalDate.now());
		Book newBook = bookRepo.save(book);
		return newBook.getBookID();
	}
	
	@Override
	public Book editBook(Book book, Long bookId) {
		Book existingBook = bookRepo.findById(bookId)
				.orElseThrow(() -> new BookNotFoundExceptionHandler("Book", "id", bookId));
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
	public boolean editStatusofBook(Long bookId) {
		Book existingBook = bookRepo.findById(bookId)
				.orElseThrow(() -> new BookNotFoundExceptionHandler("Book", "id", bookId));
		existingBook.setActive(!existingBook.isActive());
		bookRepo.save(existingBook);
		return existingBook.isActive();
	}

	@Override
	public boolean getBookStatus(Long bookID) {
		Book existingBook = bookRepo.findById(bookID)
				.orElseThrow(() -> new BookNotFoundExceptionHandler("Book", "id", bookID));
		return existingBook.isActive();
	}

	@Override
	public Book getBookbyId(Long bookID) {
		Book book = bookRepo.findById(bookID).orElseThrow(() -> new BookNotFoundExceptionHandler("Book", "id", bookID));
		return book;
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}

	@Override
	public List<Book> getAllBooksByAuthor(String author) {
		return bookRepo.findByAuthor(author);
	}

}
