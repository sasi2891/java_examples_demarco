package org.protor.sandbox.agodemar;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class VehicleUtils {
	
	/**
	 * Parses an XML file and searches for all occurrences of "<car />"
	 * @param xmlFile
	 * @return a list of Car objects
	 */
	public static List<Car> loadListOfCars(File xmlFile) {
		
		// 0. create an empty List<Car>
		List<Car> cars = new ArrayList<>();
		
		// 1. verify that xmlFile exists
		if (!xmlFile.exists()) {
			System.err.println("[VehicleUtils.loadListOfCars]");
			System.err.println("File " + xmlFile.getAbsolutePath() + " not found.");
			return cars;
		}

		System.out.println("[VehicleUtils.loadListOfCars]");
		System.out.println("Found file: " + xmlFile.getAbsolutePath());
		System.out.println("--- Now reading XML content ---");

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		
		//2. search for //cars/car nodes --> NodeList
		try {

			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);

			System.out.println("[VehicleUtils.loadListOfCars]");
			System.out.println("File XML parsed.");

			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();
			
			// search for car elements
			NodeList nodeList = doc.getElementsByTagName("car");
			
			// 4. cycle through nodes
			for (int iNode = 0; iNode < nodeList.getLength(); iNode++) {

				Node node = nodeList.item(iNode);

				// 4a. construct Car objects from the nodes
				Car car = new Car(node);

				// 4b. add the object to a list
				cars.add(car);
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return cars;
		} catch (SAXException e) {
			e.printStackTrace();
			return cars;
		} catch (IOException e) {
			e.printStackTrace();
			return cars;
		}
		
		// 5. return the list
		return cars;
	}

}
