package com.user.exception;

public class UserNotFoundExceptionHandler extends RuntimeException{
	private static final long serialVersionUID = 1l;
	private String userName;
	private String fieldName;
	private Object fieldValue;
	
	
	
	public UserNotFoundExceptionHandler(String userName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : %s", userName, fieldName, fieldValue));
		this.userName = userName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	public String getUserName() {
		return userName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public Object getFieldValue() {
		return fieldValue;
	}

}
