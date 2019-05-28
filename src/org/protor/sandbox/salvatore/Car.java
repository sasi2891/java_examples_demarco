package org.protor.sandbox.salvatore;

import java.io.File;

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
	public static Car createCarFromXmlNode(Node node) {
		return null;
		
	}
	@Override
	protected void loadFromFile(File configFile) {
		
		
		System.out.println("[Car] Reading data from file: "
				+ configFile.getAbsolutePath());
		
		System.out.println("... function not implemented yet.");
		
		
	}
	protected void loadFromNode(Node node) {
		String carName = XMLUtils.getXMLPropertyByPath(node, "//name/text()");
		// TODO Auto-generated method stub
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

	@Override
	
}
