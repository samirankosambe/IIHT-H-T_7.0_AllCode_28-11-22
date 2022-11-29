package com.basics.dateandtime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class DateTime {
	public static void main(String[] args) {
		
		LocalDate today = LocalDate.now();
		LocalDate idependanceDay = LocalDate.of(2022, Month.AUGUST, 15);
		
		System.out.println(today);
		System.out.println(idependanceDay);
		
		LocalTime time = LocalTime.now();
		System.out.println(time);
		
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		//Date today = new Date();
	}
}
