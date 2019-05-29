package org.protor.sandbox.salvatore;

import java.io.File;
import java.util.List;

import org.protor.filesio.utils.XMLUtils;
import org.w3c.dom.Node;

public class MyCar extends AbstractTerrestrialVehicle {

	public MyCar(EnumEngineType engineType) {
		super(engineType);
	}

	public MyCar(File configFile) {
		super(configFile);
	}

	public MyCar(String name, EnumEngineType engineType, double range, double endurance, int numMaxPassengers,
			double maxPayload, EnumGroundContactType groundContactType) {
		super(name, engineType, range, endurance, numMaxPassengers, maxPayload, groundContactType);

	}

	public MyCar(String name, EnumEngineType engineType, double range, double endurance, int numMaxPassengers,
			double maxPayload) {
		super(name, engineType, range, endurance, numMaxPassengers, maxPayload);
	}

	public MyCar(String name, EnumEngineType engineType) {
		super(name, engineType);
	}
	public MyCar(Node node) {
		super (node);
	}
	public static MyCar createCarFromXmlNode(Node node) {
		return null;

	}
	@Override
	protected void loadFromFile(File configFile) {


		System.out.println("[Car] Reading data from file: "
				+ configFile.getAbsolutePath());

		System.out.println("... function not implemented yet.");


	}
	@Override
	protected void loadFromNode(Node node) {
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			this.name = XMLUtils.getXMLPropertyByPath(node, "//name/text()");
			List<String> passengersValueList = XMLUtils.getXMLAttributesByPath(node, "//passengers","value");
			if(passengersValueList.size() >0) {
				try {
					this.numMaxPassengers=Integer.parseInt(passengersValueList.get(0));
				} catch (NumberFormatException e) {
					System.err.println("[Car.loadFromNode]");
					System.err.println("Car \'" + this.name+ "\' incorrect passengers number.");
					System.err.println("Keeping default values"+this.numMaxPassengers);
					//e.printStackTrace();
				}
			}
			List<String> rangeValueList = XMLUtils.getXMLAttributesByPath(node, "//range_km","value");
			if(rangeValueList.size() >0) {
				try {
					this.range=Double.parseDouble(rangeValueList.get(0));
				} catch (NumberFormatException e) {
					System.err.println("[Car.loadFromNode]");
					System.err.println("Car \'" + this.name+ "\' incorrect range_km number.");
					System.err.println("Keeping default values"+this.range);
					//e.printStackTrace();
				}
			}
			List<String> enduranceValueList = XMLUtils.getXMLAttributesByPath(node, "//endurance_hr","value");
			if(enduranceValueList.size() >0) {
				try {
					this.endurance=Double.parseDouble(enduranceValueList.get(0));
				} catch (NumberFormatException e) {
					System.err.println("[Car.loadFromNode]");
					System.err.println("Car \'" + this.name+ "\' incorrect passengers number.");
					System.err.println("Keeping default values"+this.endurance);
					//e.printStackTrace();
				}
			}
		}else {
			System.err.println("[Car.loadFromNode]");
		System.err.println("Node is not an ELEMENT_NODE");
		
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
