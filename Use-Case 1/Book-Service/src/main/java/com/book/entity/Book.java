package com.book.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	private Long bookID;
	@Column
	private String logo;
	@Column
	private String title;
	@Column
	private String category;
	@Column
	private Long price;
	@Column
	private String author;
	@Column
	private String publisher;
	@Column(name = "published_date")
	private LocalDate publishedDate;
	@Column
	private String content;
	@Column
	private boolean active;

	public Book() {
		super();
	}

	public Book(String logo, String title, String category, Long price, String author, String publisher,
			LocalDate publishedDate, String content, boolean active) {
		super();
		this.logo = logo;
		this.title = title;
		this.category = category;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.content = content;
		this.active = active;
	}

	public Book(Long bookID, String logo, String title, String category, Long price, String author, String publisher,
			LocalDate publishedDate, String content, boolean active) {
		super();
		this.bookID = bookID;
		this.logo = logo;
		this.title = title;
		this.category = category;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.content = content;
		this.active = active;
	}

	public Long getBookID() {
		return bookID;
	}

	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
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

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", logo=" + logo + ", title=" + title + ", category=" + category + ", price="
				+ price + ", author=" + author + ", publisher=" + publisher + ", publishedDate=" + publishedDate
				+ ", content=" + content + ", active=" + active + "]";
	}

}
