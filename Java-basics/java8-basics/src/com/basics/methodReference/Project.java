package com.basics.methodReference;

import java.time.LocalDate;

public class Project {
	public static void projectProgress() {
		System.out.println("Project is making progress...");
		System.out.println("The status is approved by client");
		LocalDate date = LocalDate.now();
		System.out.println("On: " + date.toString());
	}
}
