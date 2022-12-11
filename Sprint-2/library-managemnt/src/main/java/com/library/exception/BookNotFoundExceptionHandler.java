package com.library.exception;

public class BookNotFoundExceptionHandler extends RuntimeException{
	private static final long serialVersionUID = 1l;
	private String bookName;
	private String fieldName;
	private Object fieldValue;
	
	
	
	public BookNotFoundExceptionHandler(String bookName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : %s", bookName, fieldName, fieldValue));
		this.bookName = bookName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	public String getBookName() {
		return bookName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public Object getFieldValue() {
		return fieldValue;
	}

}
