package com.book.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subscription_id")
	private Integer id;
	@Column
	private Long bookID;
	@Column
	private Integer userID;
	@Column
	private LocalDateTime subscriptionDateTime;
	@Column
	private String invoice;

	public Subscription() {
		super();
	}

	public Subscription(Long bookID, Integer userID, LocalDateTime subscriptionDateTime, String invoice) {
		super();
		this.bookID = bookID;
		this.userID = userID;
		this.subscriptionDateTime = subscriptionDateTime;
		this.invoice = invoice;
	}

	public Subscription(Integer id, Long bookID, Integer userID, LocalDateTime subscriptionDateTime, String invoice) {
		super();
		this.id = id;
		this.bookID = bookID;
		this.userID = userID;
		this.subscriptionDateTime = subscriptionDateTime;
		this.invoice = invoice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getBookID() {
		return bookID;
	}

	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public LocalDateTime getSubscriptionDateTime() {
		return subscriptionDateTime;
	}

	public void setSubscriptionDateTime(LocalDateTime subscriptionDateTime) {
		this.subscriptionDateTime = subscriptionDateTime;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	@Override
	public String toString() {
		return "Subscription [id=" + id + ", bookID=" + bookID + ", userID=" + userID + ", subscriptionDateTime="
				+ subscriptionDateTime + ", invoice=" + invoice + "]";
	}

}
