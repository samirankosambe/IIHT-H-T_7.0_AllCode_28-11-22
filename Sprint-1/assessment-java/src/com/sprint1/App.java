package com.sprint1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args) {
		ArrayList<CompetitiveCourse> courses = new ArrayList<>();
		courses.add(new CompetitiveCourse(1, "Java", "Nishant", 15, 15000));
		courses.add(new CompetitiveCourse(2, "HTML", "Sam", 12, 2000));
		courses.add(new CompetitiveCourse(3, "CSS", "Abhi", 25, 5000));
		courses.add(new CompetitiveCourse(4, "JavaScript", "Shiva", 10, 10000));
		courses.add(new CompetitiveCourse(5, "Typescript", "Sudahnshu", 12, 7000));
		courses.add(new CompetitiveCourse(6, "Angular", "Varsha", 5, 6500));
		courses.add(new CompetitiveCourse(7, "Bootstrap", "Nikita", 15, 8000));
		courses.add(new CompetitiveCourse(8, "Phyton", "Jay", 19, 11000));
		courses.add(new CompetitiveCourse(9, ".Net", "Priyanka", 8, 4000));
		courses.add(new CompetitiveCourse(10, "SAP", "Subhash", 13, 5500));
		courses.add(new CompetitiveCourse(11, "C languauge", "Aparna", 15, 35000));
		courses.add(new CompetitiveCourse(12, "CPP", "Akash", 17, 22000));
		courses.add(new CompetitiveCourse(13, "OOP", "Rushi", 6, 15000));
		courses.add(new CompetitiveCourse(14, "Spring", "Arihant", 22, 19000));
		courses.add(new CompetitiveCourse(15, "Microservices", "Tushar", 14, 6000));
		
		List<CompetitiveCourse> feesLowToHigh= courses.stream().sorted(Comparator.comparing(CompetitiveCourse::getCourseFees)).collect(Collectors.toList());
		System.out.println("Sorted fees low to high: ");
		System.out.println(feesLowToHigh);
		List<CompetitiveCourse> feesHighToLow= courses.stream().sorted(Comparator.comparing(CompetitiveCourse::getCourseFees).reversed()).collect(Collectors.toList());
		System.out.println("Sorted fees high to low: ");
		System.out.println(feesHighToLow);
		List<CompetitiveCourse> durationLowToHigh = courses.stream().sorted(Comparator.comparing(CompetitiveCourse::getCourseDuration)).collect(Collectors.toList());
		System.out.println("Sorted duration low to high: ");
		System.out.println(durationLowToHigh);
	}

}
