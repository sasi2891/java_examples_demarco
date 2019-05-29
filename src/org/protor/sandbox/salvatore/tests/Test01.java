package org.protor.sandbox.salvatore.tests;

import java.util.ArrayList;
import java.util.List;

import org.protor.sandbox.salvatore.AbstractVehicle;
import org.protor.sandbox.salvatore.MyCar;
import org.protor.sandbox.salvatore.EnumEngineType;
import org.protor.sandbox.salvatore.EnumGroundContactType;

public class Test01 {

	public static void main(String[] args) {

		/*
		AbstractVehicle v1 = new AbstractVehicle(MyVehicleType.TERRESTRIAL);
		v1.setName("Fiat 700");

		AbstractVehicle v2 = new AbstractVehicle("Eurofighter", MyVehicleType.AERIAL);

		System.out.println("v1 - Name: " + v1.getName());
		System.out.println("v1 - Type: " + v1.getType());

		System.out.println("v2 - Name: " + v2.getName());
		System.out.println("v2 - Type: " + v2.getType());
		 */
		MyCar car1 = new MyCar(
				"Tesla model 3", 
				EnumEngineType.ELECTRIC, 
				500.0, 4.5,  4, 500.0, EnumGroundContactType.WHEELS);

		MyCar car2 = new MyCar(EnumEngineType.THERMICAL);
		car2.setName("BMW X1");

//		System.out.println(car1.toString());
//		System.out.println(car2);

		System.out.println("--------------------------");

		List<MyCar> list = new ArrayList<MyCar>();
		
		list.add(car1);
		list.add(car2);
		list.add(
				new MyCar(
						"Nissan XTrail", 
						EnumEngineType.THERMICAL, 
						500.0, 4.5,  4, 500.0, EnumGroundContactType.WHEELS
						)
				);
		
		for(MyCar c : list) {
			System.out.println(c);
		}

	}

}
