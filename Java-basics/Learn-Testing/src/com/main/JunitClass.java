package com.main;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class JunitClass {
	
	String username = "samiran_97";
	public static void main(String[] args) {
		JunitClass results = new JunitClass();
		results.testUsername();
	}
	@Test
	public void junitMethod() {
		System.out.println("Test file executed");
	}
	@Test
	public void testUsername() {
		System.out.println("Testing if usename matches");
		assertEquals("samiran_970", username);
	}

}
