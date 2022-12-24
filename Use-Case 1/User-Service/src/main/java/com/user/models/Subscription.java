package com.user.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Subscription {

	private Long id;
	private Long bookID;
	private Long userID;
	private LocalDateTime subscriptionDateTime;
	private boolean active;
	private String invoice;

	public Subscription() {
		super();
	}

	public Subscription(Long bookID, Long userID, LocalDateTime subscriptionDateTime, boolean active, String invoice) {
		super();
		this.bookID = bookID;
		this.userID = userID;
		this.subscriptionDateTime = subscriptionDateTime;
		this.active = active;
		this.invoice = invoice;
	}

	public Subscription(Long id, Long bookID, Long userID, LocalDateTime subscriptionDateTime, boolean active, String invoice) {
		super();
		this.id = id;
		this.bookID = bookID;
		this.userID = userID;
		this.subscriptionDateTime = subscriptionDateTime;
		this.active = active;
		this.invoice = invoice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBookID() {
		return bookID;
	}

	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public LocalDateTime getSubscriptionDateTime() {
		return subscriptionDateTime;
	}

	public void setSubscriptionDateTime(LocalDateTime subscriptionDateTime) {
		this.subscriptionDateTime = subscriptionDateTime;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
				+ subscriptionDateTime + ", active=" + active + ", invoice=" + invoice + "]";
	}

	

}

