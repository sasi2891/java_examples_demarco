package org.protor.polymorphism.tests;

import org.protor.polymorphism.Vehicle;
import org.protor.polymorphism.VehicleType;

public class Test01 {

	public static void main(String[] args) {
		
		Vehicle v1 = new Vehicle(VehicleType.TERRESTRIAL);
		v1.setName("Fiat 600");
		
		Vehicle v2 = new Vehicle("Eurofighter", VehicleType.AERIAL);

		System.out.println("v1 - Name: " + v1.getName());
		System.out.println("v1 - Type: " + v1.getType());
		
		System.out.println("v2 - Name: " + v2.getName());
		System.out.println("v2 - Type: " + v2.getType());
		
	}

}
