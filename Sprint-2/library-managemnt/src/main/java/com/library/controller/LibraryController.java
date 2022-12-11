package com.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.Book;
import com.library.service.ILibraryService;

@RestController
public class LibraryController {

	@Autowired
	ILibraryService libraryService;

	@PostMapping("/add/book")
	public long createBook(@RequestBody Book book) {
		return libraryService.createBook(book);
	}

	@GetMapping("read/{id}")
	public Optional<Book> getBook(@PathVariable Long id) {
		return libraryService.getBook(id);
	}

	@GetMapping("allbooks")
	public List<Book> getBook() {
		return libraryService.getAllBooks();
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Book> updateEmployee(@PathVariable Long id, @RequestBody Book employee) {
		return new ResponseEntity<Book>(libraryService.updateBook(employee, id), HttpStatus.OK);
	}
	
	@PutMapping("/borrow/{id}")
	public ResponseEntity<Book> borrowBook(@PathVariable Long id) {
		return new ResponseEntity<Book>(libraryService.changeStatus(id), HttpStatus.OK);
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
		ResponseEntity<Book> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			libraryService.deleteBook(id);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
}
