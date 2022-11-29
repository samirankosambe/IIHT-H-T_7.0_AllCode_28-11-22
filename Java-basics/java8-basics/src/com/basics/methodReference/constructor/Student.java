package com.basics.methodReference.constructor;

public class Student {

	public Student() {
		System.out.println("Creating object of student class");
	}

	public void display(String name, String standard) {
		System.out.println("This is a student");
		System.out.println("Student's name: " + name);
		System.out.println("Student's standard: " + standard);
	}
}
