package org.protor.sandbox.agodemar.tests;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.protor.sandbox.agodemar.Car;
import org.protor.sandbox.agodemar.VehicleUtils;

public class Test05 {

	public static List<Car> cars = new ArrayList<Car>();

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
			
			Test05.cars = cars;
			
		} else {
			System.err.println(
					"This program must be used with arguments!\n"
							+ "Terminating.");
			System.exit(1);
		}
	}
}
