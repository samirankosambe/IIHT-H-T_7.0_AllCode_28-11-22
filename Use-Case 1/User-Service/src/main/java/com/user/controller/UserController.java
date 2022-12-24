package com.user.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.entity.User;
import com.user.models.Book;
import com.user.service.IUserService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/digitalbooks")
public class UserController {

	@Autowired
	IUserService userService;

	@Autowired
	private RestTemplate restTemplate;

	public static final String BASE_URL = "http://localhost:5001";

	// Create account for new user
	@PostMapping("/sign-up")
	public Long createUser(@RequestBody User user) {
		return userService.createAccountforUser(user);
	}

	// To search a book by author/Guest/Reader
	@GetMapping("/search")
	public List<Book> searchBooks(@RequestParam("category") String category, @RequestParam("title") String title,
			@RequestParam("author") String author, @RequestParam("price") Long price,
			@RequestParam("publisher") String publisher) {
		Book book = new Book();
		book.setCategory(category);
		book.setTitle(title);
		book.setAuthor(author);
		book.setPrice(price);
		book.setPublisher(publisher);
		@SuppressWarnings("unchecked")
		List<Book> books = restTemplate.postForObject(BASE_URL + "/search", book, List.class);
		return books;
	}

	// To subscribe a book
	@PostMapping("/reader/subscribe/{userId}/{bookId}")
	public Long subscribeBook(@PathVariable("userId") Long userId, @PathVariable("bookId") Long bookId) {
		return restTemplate.getForObject(BASE_URL + "/subscribe/" + bookId + "/" + userId, Long.class);

	}

	// To fetch all the books subscribed by Reader
	@GetMapping("/reader/{userId}/books")
	public List<Book> getListofBooksSuscribed(@PathVariable("userId") Long userId) {
		@SuppressWarnings("unchecked")
		List<Book> books = restTemplate.getForObject(BASE_URL + "/booksSubscribedbyId/" + userId, List.class);
		return books;
	}

	// To fetch a specific book subscribed by Reader
	@GetMapping("/reader/{userId}/books/{subscriptionId}")
	public Book getSubscribedBook(@PathVariable("userId") Long userId, @PathVariable("subscriptionId") Long subscriptionId) {
		Book book = restTemplate.getForObject(BASE_URL + "/subscribedBook/" + subscriptionId, Book.class);
		return book;
	}

	// To get the content of a book subscribed by Reader
	@GetMapping("/reader/{userId}/books/{subscriptionId}/read")
	public String getSubscribedBookContent(@PathVariable("userId") Integer userId,
			@PathVariable("subscriptionId") Integer subscriptionId) {
		String content = restTemplate.getForObject(BASE_URL + "/subscribedBook/" + subscriptionId + "/read",
				String.class);
		return content;
	}

	// TO Cancel subscription of a book by reader within 24hrs
	@PostMapping("/readers/{userId}/books/{subscriptionId}/read/cancel-subscription")
	public ResponseEntity<?> cancelSubscription(@PathVariable("userId") Long userId,
			@PathVariable("subscriptionId") Long subscriptionId) {
		boolean cancelled = restTemplate.getForObject(BASE_URL + "/getUserBookData/" + userId + "/" + subscriptionId,
				boolean.class);
		return new ResponseEntity<>(cancelled, HttpStatus.OK);
	}

	// TO add a book by author
	@PostMapping("/author/{authorID}/books")
	public Long createBook(@PathVariable("authorID") String userID, @RequestBody Book book) {
		Long bookId = restTemplate.postForObject(BASE_URL + "/create/" + userID, book, Long.class);
		return bookId;
	}

	// To edit a book by author
	@PutMapping("/author/{authorID}/books/{bookID}")
	public void editBook(@PathVariable("authorID") Long userID, @PathVariable("bookID") Long bookID,
			@RequestBody Book book) throws Exception {
		restTemplate.put(BASE_URL + "/edit/" + userID + "/" + bookID, book);
	}

	// To change the status of book
	@PostMapping("/author/{authorID}/books/{bookID}/changeStatus")
	public ResponseEntity<?> changeBookStatus(@PathVariable("authorID") Long userID,
			@PathVariable("bookID") Long bookID) throws Exception {
		return new ResponseEntity<String>(
				restTemplate.postForObject(BASE_URL + "/changeBookStatus/" + bookID, null, String.class),
				HttpStatus.OK);
	}
}
