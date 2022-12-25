package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.entity.User;
import com.user.models.Book;
import com.user.models.BookSubscription;
import com.user.models.JwtRequest;
import com.user.models.JwtResponse;
import com.user.service.IUserService;
import com.user.utility.JWTUtility;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	IUserService userService;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private JWTUtility jwtUtility;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	public static final String BASE_URL = "http://BOOK-SERVICE";

	// For Signing in
	@PostMapping("/sign-in")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
		Authentication authentication;
		try {
			authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));

			SecurityContextHolder.getContext().setAuthentication(authentication);
			final String token = jwtUtility.generateToken(authentication);
			String role = authentication.getAuthorities().stream().map(item -> item.getAuthority()).findFirst().get();
			return new JwtResponse(token, jwtRequest.getUsername(), role);
			
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS");
		}
	}

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
	@PostMapping("/readers/subscribe/{userId}/{bookId}")
	public Long subscribeBook(@PathVariable("userId") Long userId, @PathVariable("bookId") Long bookId) {
		return restTemplate.getForObject(BASE_URL + "/subscribe/" + bookId + "/" + userId, Long.class);

	}

	// To fetch all the books subscribed by Reader
	@GetMapping("/readers/{userId}/books")
	public List<BookSubscription> getListofBooksSuscribed(@PathVariable("userId") Long userId) {
		@SuppressWarnings("unchecked")
		List<BookSubscription> books = restTemplate.getForObject(BASE_URL + "/booksSubscribedById/" + userId,
				List.class);
		return books;
	}

	// To fetch a specific book subscribed by Reader
	@GetMapping("/readers/{userId}/books/{subscriptionId}")
	public BookSubscription getSubscribedBook(@PathVariable("userId") Long userId,
			@PathVariable("subscriptionId") Long subscriptionId) {
		BookSubscription book = restTemplate.getForObject(BASE_URL + "/subscribedBook/" + subscriptionId,
				BookSubscription.class);
		return book;
	}

	// To get the content of a book subscribed by Reader
	@GetMapping("/readers/{userId}/books/{subscriptionId}/read")
	public String getSubscribedBookContent(@PathVariable("userId") Long userId,
			@PathVariable("subscriptionId") Long subscriptionId) {
		String content = restTemplate.getForObject(BASE_URL + "/subscribedBook/" + subscriptionId + "/read",
				String.class);
		return content;
	}

	// To Cancel subscription of a book by reader within 24hrs
	@PostMapping("/readers/{userId}/books/{subscriptionId}/cancelSubscription")
	public boolean cancelSubscription(@PathVariable("userId") Long userId,
			@PathVariable("subscriptionId") Long subscriptionId) {
		return restTemplate.getForObject(BASE_URL + "/cancelSubscription/" + subscriptionId, boolean.class);
	}

	// To add a book by author
	@PostMapping("/author/{authorID}/books")
	public Long createBook(@PathVariable("authorID") Long userID, @RequestBody Book book) {
		Long bookId = restTemplate.postForObject(BASE_URL + "/add", book, Long.class);
		return bookId;
	}

	// To edit a book by author
	@PutMapping("/author/{authorID}/books/{bookID}")
	public void editBook(@PathVariable("authorID") Long userID, @PathVariable("bookID") Long bookID,
			@RequestBody Book book) throws Exception {
		restTemplate.put(BASE_URL + "/update/" + bookID, book, Book.class);
	}

	// To change the status of book
	@PreAuthorize("hasRole('Admin')")
	@PostMapping("/author/{authorID}/books/{bookID}/changeStatus")
	public boolean changeBookStatus(@PathVariable("authorID") Long userID, @PathVariable("bookID") Long bookID)
			throws Exception {
		return restTemplate.getForObject(BASE_URL + "/changeBookStatus/" + bookID, boolean.class);
	}
}
