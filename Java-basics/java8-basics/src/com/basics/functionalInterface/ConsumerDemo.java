package com.basics.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

	public static void main(String[] args) {
		Consumer<Integer> consumer = (t) -> System.out.println("Printing : " + t);
		consumer.accept(100);

		List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5);
		numberList.forEach(consumer);
		numberList.forEach(number -> System.out.println("Printing : " + number));
	}

}
