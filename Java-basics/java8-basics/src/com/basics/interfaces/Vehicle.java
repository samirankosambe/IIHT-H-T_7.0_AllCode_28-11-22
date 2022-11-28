package com.basics.interfaces;

// Using the interface by third user
public class Vehicle {

	public static void main(String[] args) {
		Drivable d1 = new Car();
		Drivable d2 = new Truck();
		Drivable d3 = new Bike();
		d1.driven();
		d2.driven();
		d3.driven();
	}

}

// Implementation done by second user
class Car implements Drivable {

	@Override
	public void driven() {
		System.out.println("The Car can be driven");

	}
}

class Truck implements Drivable {

	@Override
	public void driven() {
		System.out.println("The Truck can be driven");

	}
}

class Bike implements Drivable {

	@Override
	public void driven() {
		System.out.println("The Bike can be driven");

	}
}