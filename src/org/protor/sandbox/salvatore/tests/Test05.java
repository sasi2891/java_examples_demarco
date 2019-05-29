package org.protor.sandbox.salvatore.tests;

import java.io.File;

import org.protor.sandbox.salvatore.VehicleUtils;

public class Test05 {

	public static void main(String[] args) {
	
			if (args.length != 0) {

				// get the file name
				String filePath = args[0];
				File carsFile = new File(filePath);
				VehicleUtils.loadListOfCars(carsFile);
				System.out.println("List of cars: " + VehicleUtils.loadListOfCars(carsFile).size());
				}
			else {
		System.err.println(
				"This program must be used with arguments!\n"
						+ "Terminating.");
		System.exit(1);
	}
			
}
}