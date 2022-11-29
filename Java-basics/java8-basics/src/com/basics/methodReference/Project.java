package com.basics.methodReference;

import java.time.LocalDate;

public class Project {
	public static void projectProgress() {
		System.out.println("Project is making progress...");
		System.out.println("The status is approved by client");
		LocalDate date = LocalDate.now();
		System.out.println("On: " + date.toString());
	}

	public static void threadTask() {
		for (int i = 0; i <= 10; i++) {
			System.out.println(i * 2);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void oddNumbers() {
		for (int i = 0; i <= 100; i++) {
			if(i%2 !=0) {
				System.out.println(i);
			}
		}
	}
}
