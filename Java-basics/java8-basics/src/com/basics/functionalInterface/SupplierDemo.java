package com.basics.functionalInterface;

import java.util.function.Supplier;

public class SupplierDemo implements Supplier<String> {

	public static void main(String[] args) {
		Supplier<String> supplier = new SupplierDemo();
		System.out.println(supplier.get());
	}

	@Override
	public String get() {
		return "Hello World";
	}

}
