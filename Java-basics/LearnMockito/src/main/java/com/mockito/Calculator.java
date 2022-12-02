package com.mockito;

public class Calculator {
	
	CalculatorService service;
	
	public Calculator(CalculatorService service) {
		this.service = service;
	}
	
	public int add (int num1, int num2) {
		return service.add(num1, num2);
	}
	public int sub (int num1, int num2) {
		return service.sub(num1, num2);
	}
	public int div (int num1, int num2) {
		return service.div(num1, num2);
	}
	public int multiply (int num1, int num2) {
		return service.multiply(num1, num2);
	}
}
