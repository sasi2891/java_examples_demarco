package org.protor.sandbox.agodemar.tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.protor.filesio.utils.XMLUtils;
import org.protor.sandbox.agodemar.Car;
import org.protor.sandbox.agodemar.EnumEngineType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Test04 {

	public static void main(String[] args) {

		// "C:\Users\PC5\demarco\github\java_examples_demarco\input"
		// String fileName = "cars.xml";
		// File carsFile = new File("input"+ File.separator + fileName);

		if (args.length != 0) {

			// get the file name
			String filePath = args[0];
			File carsFile = new File(filePath);

			if (!carsFile.exists()) {
				System.err.println("File " + carsFile.getAbsolutePath() + " not found.");
				System.exit(1);
			}

			System.out.println("Found file: " + carsFile.getAbsolutePath());
			System.out.println("--- Now reading XML content ---");

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;

			try {

				dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(carsFile);

				System.out.println("File XML parsed.");

				//optional, but recommended
				//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
				doc.getDocumentElement().normalize();

				System.out.println(
						"Root element: " 
								+ doc.getDocumentElement().getNodeName());

				NodeList nodeList = doc.getElementsByTagName("car");
				System.out.println("N. cars: " + nodeList.getLength());

				List<Car> cars = new ArrayList<>();

				for (int iNode = 0; iNode < nodeList.getLength(); iNode++) {

					Node node = nodeList.item(iNode);

					System.out.println("\nCurrent Element :" + node.getNodeName());
					
					Car car = new Car (node);

					System.out.println(car);

					cars.add(car);

				}

				System.out.println("---------------------------------------");
				System.out.println("List of cars: " + cars.size());

			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			System.err.println(
					"This program must be used with arguments!\n"
							+ "Terminating.");
			System.exit(1);
		}

	}
}
