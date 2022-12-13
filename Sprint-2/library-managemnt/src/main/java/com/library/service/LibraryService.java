package com.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Book;
import com.library.exception.BookNotFoundExceptionHandler;
import com.library.repo.ILibraryRepo;

@Service
public class LibraryService implements ILibraryService {

	@Autowired
	ILibraryRepo libraryRepo;

	@Override
	public Long createBook(Book book) {
		Book savedBook = libraryRepo.save(book);
		return savedBook.getBookID();
	}

	@Override
	public Optional<Book> getBook(Long id) {
		return libraryRepo.findById(id);
	}

	@Override
	public List<Book> getAllBooks() {
		return libraryRepo.findAll();
	}
	
	@Override
	public Optional<Book> getBookByName(String name) {
		return libraryRepo.findByName(name);
	}

	@Override
	public Book updateBook(Book book, Long id) {
		Book existingBook = libraryRepo.findById(id)
				.orElseThrow(() -> new BookNotFoundExceptionHandler("Book", "id", id));
		existingBook.setName(book.getName());
		existingBook.setAuthor(book.getAuthor());
		existingBook.setPrice(book.getPrice());
		existingBook.setGenre(book.getGenre());
		existingBook.setStatus(book.isStatus());
		return libraryRepo.save(existingBook);
	}

	@Override
	public Book changeStatus(Long id) {
		Book existingBook = libraryRepo.findById(id)
				.orElseThrow(() -> new BookNotFoundExceptionHandler("Book", "id", id));
		if(existingBook.isStatus()) {
			existingBook.setBookID(0L);
			return existingBook;
		}
		existingBook.setStatus(true);
		return libraryRepo.save(existingBook);
	}

	@Override
	public void deleteBook(Long id) {
		libraryRepo.deleteById(id);
	}

}
