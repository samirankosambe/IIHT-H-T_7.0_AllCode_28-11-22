package com.library.entity;

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
	private String name;
	private String author;
	private float price;
	private String genre;
	private boolean status;

	public Book() {
		super();
	}

	public Book(String name, String author, float price, String genre, boolean status) {
		super();
		this.name = name;
		this.author = author;
		this.price = price;
		this.genre = genre;
		this.status = status;
	}

	public Book(Long bookID, String name, String author, float price, String genre, boolean status) {
		super();
		this.bookID = bookID;
		this.name = name;
		this.author = author;
		this.price = price;
		this.genre = genre;
		this.status = status;
	}

	public Long getBookID() {
		return bookID;
	}

	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", name=" + name + ", author=" + author + ", price=" + price + ", genre="
				+ genre + ", status=" + status + "]";
	}

}
