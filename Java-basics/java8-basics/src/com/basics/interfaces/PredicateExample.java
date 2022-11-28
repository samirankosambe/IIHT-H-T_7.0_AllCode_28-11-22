package com.basics.interfaces;

import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {
		Predicate<Integer> predicate1 = num -> (num>20);
		System.out.println(predicate1.test(21));
	}
}
