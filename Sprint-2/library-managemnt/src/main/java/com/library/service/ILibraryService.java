package com.library.service;

import java.util.List;
import java.util.Optional;

import com.library.entity.Book;

public interface ILibraryService {

	Long createBook(Book book);

	Optional<Book> getBook(Long id);

	List<Book> getAllBooks();

	Book updateBook(Book book, Long id);

	Book changeStatus(Long id);

	void deleteBook(Long id);

}
