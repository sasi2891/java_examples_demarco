package org.protor.sandbox.salvatore;

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
	/*    TASK
		//verify that xmlfle exist
		//serach for //cars/car nodes ----> nodelist
		 * create an empty list<car>
		 -cycle through node
		 -construct Car objects from the nodes
		 -construct Car objects from the nodes
		 -add the object to a list
		 -return the list
		 */
	
	
	/**
	 * Parses an XML file and searches for all occurences of "//cars/car"
	 * @param xmlFile
	 * @return a list of car objects
	 */
	public static List<Car> loadListOfCars(File xmlFile){
		List<Car> cars = new ArrayList<>();
		if (!xmlFile.exists()) {
			System.err.println("[VehicleUtils.loadListOfCars] ");
			System.err.println("File " + xmlFile.getAbsolutePath() + " not found.");
			return cars;
		}
		System.out.println("[VehicleUtils.loadListOfCars] ");
		System.out.println("Found file: " + xmlFile.getAbsolutePath());
		System.out.println("--- Now reading XML content ---");

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		try {

			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);

			System.out.println("File XML parsed.");

			doc.getDocumentElement().normalize();

			System.out.println(
					"Root element: " 
							+ doc.getDocumentElement().getNodeName());

			NodeList nodeList = doc.getElementsByTagName("car");
			System.out.println("N. cars: " + nodeList.getLength());

			
			for (int iNode = 0; iNode < nodeList.getLength(); iNode++) {

				Node node = nodeList.item(iNode);

				System.out.println("\nCurrent Element :" + node.getNodeName());
               Car car=new Car(node);
               cars.add(car);
			}
		}
			
		catch (ParserConfigurationException e) {
			e.printStackTrace();
			return cars;
		} catch (SAXException e) {
			e.printStackTrace();
			return cars;
		} catch (IOException e) {
			e.printStackTrace();
			return cars;
		}
		
	
		
		
		return cars;
		
		
		
		
		
	
		}
	}
