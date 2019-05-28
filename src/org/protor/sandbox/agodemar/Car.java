package org.protor.sandbox.agodemar;

import java.io.File;
import java.util.List;

import org.protor.filesio.utils.XMLUtils;
import org.w3c.dom.Node;

public class Car extends AbstractTerrestrialVehicle {

	public Car(EnumEngineType engineType) {
		super(engineType);
	}

	public Car(File configFile) {
		super(configFile);
	}

	public Car(String name, EnumEngineType engineType, double range, double endurance, int numMaxPassengers,
			double maxPayload, EnumGroundContactType groundContactType) {
		super(name, engineType, range, endurance, numMaxPassengers, maxPayload, groundContactType);

	}

	public Car(String name, EnumEngineType engineType, double range, double endurance, int numMaxPassengers,
			double maxPayload) {
		super(name, engineType, range, endurance, numMaxPassengers, maxPayload);
	}

	public Car(String name, EnumEngineType engineType) {
		super(name, engineType);
	}
	
	public Car(Node node) {
		super(node);
	}

	@Override
	protected void loadFromFile(File configFile) {
		
		// TODO agodemar: implement the logic here
		
		System.out.println("[Car] Reading data from file: "
				+ configFile.getAbsolutePath());
		
		System.out.println("... function not implemented yet.");

	}

	@Override
	protected void loadFromNode(Node node) {
		
		if (node.getNodeType() == Node.ELEMENT_NODE) {

			this.name = XMLUtils.getXMLPropertyByPath(node, "//name/text()");

			List<String> passengersValuesList = XMLUtils.getXMLAttributesByPath(
					node, "//passengers", "value");

			if (passengersValuesList.size() > 0) {
				try {
					this.numMaxPassengers = 
							Integer.parseInt(
									passengersValuesList.get(0)
									);
				} catch (NumberFormatException e) {
					// e.printStackTrace();
					System.err.println("[Car.loadFromNode]");
					System.err.println("Car \"" + this.name +"\" incorrect passenger number.");
					System.err.println("Keeping default value: " + this.numMaxPassengers);
					// do nothing, continue
				}
			} else 
				System.err.println("Keeping default numMaxPassengers: " + this.numMaxPassengers);
			
			List<String> rangeValuesList = XMLUtils.getXMLAttributesByPath(
					node, "//range_km", "value");

			if (rangeValuesList.size() > 0) {
				try {
					this.range = 
							Double.parseDouble(
									rangeValuesList.get(0)
									);
				} catch (NumberFormatException e) {
					// e.printStackTrace();
					System.err.println("[Car.loadFromNode]");
					System.err.println("Car \"" + this.name +"\" incorrect range_km number.");
					System.err.println("Keeping default value: " + this.range);
					// do nothing, continue
				}
			} else
				System.err.println("Keeping default range: " + this.range);
			
			List<String> enduranceValuesList = XMLUtils.getXMLAttributesByPath(
					node, "//endurance_hr", "value");

			if (enduranceValuesList.size() > 0) {
				try {
					this.endurance = 
							Double.parseDouble(
									enduranceValuesList.get(0)
									);
				} catch (NumberFormatException e) {
					// e.printStackTrace();
					System.err.println("[Car.loadFromNode]");
					System.err.println("Car \"" + this.name +"\" incorrect endurance_hr number.");
					System.err.println("Keeping default value: " + this.endurance);
					// do nothing, continue
				}
			} else
				System.err.println("Keeping default endurance: " + this.endurance);
			
			List<String> payloadValuesList = XMLUtils.getXMLAttributesByPath(
					node, "//payload_kg", "value");

			if (payloadValuesList.size() > 0) {
				try {
					this.maxPayload = 
							Double.parseDouble(
									payloadValuesList.get(0)
									);
				} catch (NumberFormatException e) {
					// e.printStackTrace();
					System.err.println("[Car.loadFromNode]");
					System.err.println("Car \"" + this.name +"\" incorrect payload_kg number.");
					System.err.println("Keeping default value: " + this.maxPayload);
					// do nothing, continue
				}
			} else
				System.err.println("Keeping default maxPayload: " + this.maxPayload);
			
			List<String> engineTypeValuesList = XMLUtils.getXMLAttributesByPath(
					node, "//engine_type", "value");
			if (engineTypeValuesList.size() > 0) {
				String engineTypeString = 
						engineTypeValuesList.get(0).toUpperCase();

				switch (engineTypeString) {
				case "THERMICAL":
					this.engineType = EnumEngineType.THERMICAL;
					break;
				case "HYBRID":
					this.engineType = EnumEngineType.HYBRID;
					break;
				case "ELECTRIC":
					this.engineType = EnumEngineType.ELECTRIC;
					break;
				default:
					this.engineType = EnumEngineType.NONE;
					break;
				}
			} else
				System.err.println("Keeping default engineType: " + this.engineType);
			
		} else {
			System.err.println("[Car.loadFromNode]");
			System.err.println("Node is not an ELEMENT_NODE.");
			System.err.println("Keeping default values.");
			// do nothing, continue
		}	
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("--- Car Object ---\n");
		sb.append("Name: " + this.name + "\n");
		sb.append("Ground contact: " + this.groundContactType + "\n");
		sb.append("Engine type: " + this.engineType + "\n");
		sb.append("------------------------\n");
		return sb.toString();
	}
	
}
