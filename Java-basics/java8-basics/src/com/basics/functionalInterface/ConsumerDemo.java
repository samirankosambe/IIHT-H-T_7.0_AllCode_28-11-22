package com.basics.functionalInterface;

import java.util.function.Consumer;

public class ConsumerDemo {

	public static void main(String[] args) {
		Consumer<Integer> consumer = (t) -> System.out.println("Printing : " + t);
		consumer.accept(100);
	}

}
