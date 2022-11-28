package com.basics.lambda;

public class LearnLambda {

	// parameter -> expression body

	public static void main(String[] args) {
		System.out.println("Hello World");

		MathOperation add = (Integer num1, Integer num2) -> num1 + num2;

		MathOperation sub = (Integer num1, Integer num2) -> num1 - num2;

		MathOperation div = (Integer num1, Integer num2) -> num1 / num2;

		MathOperation multiply = (Integer num1, Integer num2) -> num1 * num2;

		System.out.println("Addition of two numbers 100,50 = " + add.operation(100, 50));
		System.out.println("Substracion of two numbers 100,50 = " + sub.operation(100, 50));
		System.out.println("Division of two numbers 100,50 = " + div.operation(100, 50));
		System.out.println("Multiplication of two numbers 100,50 = " + multiply.operation(100, 50));

	}

}
