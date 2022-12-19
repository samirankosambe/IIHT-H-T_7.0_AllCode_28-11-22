package com.book.exception;

public class SubscriptionNotFoundExceptionHandler extends RuntimeException{
	private static final long serialVersionUID = 1l;
	private String fieldName;
	private Object fieldValue;
	
	public SubscriptionNotFoundExceptionHandler(String fieldName, Object fieldValue) {
		super(String.format("Subscription not found with %s : %s", fieldName, fieldValue));
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	public String getFieldName() {
		return fieldName;
	}
	public Object getFieldValue() {
		return fieldValue;
	}

}
