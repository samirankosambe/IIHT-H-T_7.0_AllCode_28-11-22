package com.book.models;

public class BookSubscription {
	private Long bookID;
	private Long SubscriptionID;
	private Long userID;
	private String title;
	private String category;
	private Long price;
	private String author;
	private String publisher;
	public BookSubscription() {
		super();
	}
	public BookSubscription(Long bookID, Long subscriptionID, Long userID, String title, String category, Long price,
			String author, String publisher) {
		super();
		this.bookID = bookID;
		SubscriptionID = subscriptionID;
		this.userID = userID;
		this.title = title;
		this.category = category;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
	}
	public Long getBookID() {
		return bookID;
	}
	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}
	public Long getSubscriptionID() {
		return SubscriptionID;
	}
	public void setSubscriptionID(Long subscriptionID) {
		SubscriptionID = subscriptionID;
	}
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "BookSubscription [bookID=" + bookID + ", SubscriptionID=" + SubscriptionID + ", userID=" + userID
				+ ", title=" + title + ", category=" + category + ", price=" + price + ", author=" + author
				+ ", publisher=" + publisher + "]";
	}
	
}
