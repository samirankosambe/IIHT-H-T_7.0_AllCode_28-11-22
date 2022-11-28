package com.basics.interfaces;

interface Calculator{
	static Integer add(Integer num1, Integer num2) {
		return num1+num2;
	};
	static Integer sub(Integer num1, Integer num2) {
		return num1-num2;
	};
	static Integer div(Integer num1, Integer num2) {
		return num1/num2;
	};
	static Integer multiply(Integer num1, Integer num2) {
		return num1*num2;
	};
}

public class App {

	public static void main(String[] args) {
		System.out.println("The Addition of 100,50 = " + Calculator.add(100, 50));
		System.out.println("The Substracion of 100,50 = " + Calculator.sub(100, 50));
		System.out.println("The Division of 100,50 = " + Calculator.div(100, 50));
		System.out.println("The Multiplication of 100,50 = " + Calculator.multiply(100, 50));
	}

}
