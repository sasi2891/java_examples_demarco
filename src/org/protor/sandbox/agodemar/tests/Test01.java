package org.protor.sandbox.agodemar.tests;

import org.protor.sandbox.agodemar.MyVehicle;
import org.protor.sandbox.agodemar.MyVehicleType;

public class Test01 {

	public static void main(String[] args) {
		
		MyVehicle v1 = new MyVehicle(MyVehicleType.TERRESTRIAL);
		v1.setName("Fiat 700");
		
		MyVehicle v2 = new MyVehicle("Eurofighter", MyVehicleType.AERIAL);

		System.out.println("v1 - Name: " + v1.getName());
		System.out.println("v1 - Type: " + v1.getType());
		
		System.out.println("v2 - Name: " + v2.getName());
		System.out.println("v2 - Type: " + v2.getType());
		
	}

}
