package org.protor.sandbox.salvatore.tests;

import org.protor.sandbox.salvatore.MyVehicle;
import org.protor.sandbox.salvatore.MyVehicleType;

//import org.protor.polymorphism.Vehicle;
//import org.protor.polymorphism.VehicleType;

public class Test01 {

	public static void main(String[] args) {
		
		MyVehicle v1 = new MyVehicle(MyVehicleType.TERRESTRIAL);
		v1.setName("Fiat 600");
		
		MyVehicle v2 = new MyVehicle("Eurofighter", MyVehicleType.AERIAL);

		System.out.println("v1 - Name: " + v1.getName());
		System.out.println("v1 - Type: " + v1.getType());
		
		System.out.println("v2 - Name: " + v2.getName());
		System.out.println("v2 - Type: " + v2.getType());
		
	}

}
