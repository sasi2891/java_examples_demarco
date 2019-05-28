package org.protor.sandbox.agodemar.tests;

import java.io.File;
import java.util.List;

import org.protor.sandbox.agodemar.Car;
import org.protor.sandbox.agodemar.VehicleUtils;

public class Test05 {

	public static void main(String[] args) {
		
		if (args.length != 0) {

			// get the file name
			String filePath = args[0];
			File carsFile = new File(filePath);
			
			List<Car> cars = VehicleUtils.loadListOfCars(carsFile);
			
			if (cars.isEmpty())
				System.err.println("No cars were found!");
			else
				System.out.println("Found " + cars.size() + " cars.");
			
			
		} else {
			System.err.println(
					"This program must be used with arguments!\n"
							+ "Terminating.");
			System.exit(1);
		}
	}
}
