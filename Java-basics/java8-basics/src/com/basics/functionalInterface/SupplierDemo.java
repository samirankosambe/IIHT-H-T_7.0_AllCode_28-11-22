package com.basics.functionalInterface;

import java.util.function.Supplier;

public class SupplierDemo{

	public static void main(String[] args) {
		Supplier<String> supplier = () -> {return "Hello World";};
		System.out.println(supplier.get());
	}


}
