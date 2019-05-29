package org.protor.sandbox.agodemar.tests;

import java.io.File;

import org.protor.sandbox.agodemar.Car;

public class HelloWorld {

	public static void main(String[] args) {
		
		System.out.println("Hello world.");
		
		File file = new File("input" + File.separator + "cars.xml");
		
		String[] s = {
				file.getAbsolutePath(),
				"C:/Users/PC5/demarco/github/java_examples_demarco/input/cars.xml",
				"pippo"
				};
		
		Test05.main(s);

		System.out.println("Printing the list of cars...");
		
		for (int i = 0; i < Test05.cars.size(); i++) {
			
			System.out.println(Test05.cars.get(i));
			
		}

	}

}
