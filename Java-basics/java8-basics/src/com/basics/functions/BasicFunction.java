package com.basics.functions;

public class BasicFunction {

	public static void main(String[] args) {
		System.out.println("Addition = " + add(100,50));
		System.out.println("Substrction = " + sub(100,50));
		System.out.println("Division = " + div(100,50));
		System.out.println("Multiplication = " + multiply(100,50));
		System.out.println("Square = " + square(5));
		System.out.println("Cube = " + cube(5));
		
	}
	
	static Integer add(Integer num1, Integer num2) {
		return num1+num2;
	}
	
	static Integer sub(Integer num1, Integer num2) {
		return num1-num2;
	}
	
	static Integer div(Integer num1, Integer num2) {
		return num1/num2;
	}
	
	static Integer multiply(Integer num1, Integer num2) {
		return num1*num2;
	}
	
	static Integer square(Integer x) {
		return x*x;
	}
	
	static Integer cube(Integer x) {
		return x*x*x;
	}

}
