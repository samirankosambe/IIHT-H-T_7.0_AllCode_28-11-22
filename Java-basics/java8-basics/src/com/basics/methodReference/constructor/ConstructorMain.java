package com.basics.methodReference.constructor;

public class ConstructorMain {

	public static void main(String[] args) {
		System.out.println("We are studying contructor reference");

		IStudent iStudent = () -> new Student();
		
		Student student = iStudent.getStudent();
		student.display("Rudra", "5th");
	}

}
