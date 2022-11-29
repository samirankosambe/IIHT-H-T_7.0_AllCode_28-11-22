package com.basics.methodReference;

public class MethodReferenceDemo {

	public static void main(String[] args) {
		System.out.println("Method reference demo");

		// Implementation of IWork

		IWork iWork = Project::projectProgress;
		iWork.doProject();
		
		Runnable runnable = Project::threadTask;
		Thread t1 = new Thread(runnable);
		t1.start();
		
		//Project project = new Project();
		Runnable runnable2 = Project::oddNumbers;
		Thread t2 = new Thread(runnable2);
		t2.start();
		
	}

}
