package org.protor.sandbox.salvatore;

import java.io.File;

import org.w3c.dom.Node;

public abstract class AbstractTerrestrialVehicle extends AbstractVehicle {
	
	protected EnumGroundContactType groundContactType = EnumGroundContactType.WHEELS;

	public AbstractTerrestrialVehicle(EnumEngineType engineType) {
		super(engineType);
	}

	public AbstractTerrestrialVehicle(String name, EnumEngineType engineType) {
		super(name, engineType);
	}

	public AbstractTerrestrialVehicle(File configFile) {
		super(configFile);
	}

	public AbstractTerrestrialVehicle(
			String name, EnumEngineType engineType, double range, double endurance,
			int numMaxPassengers, double maxPayload) {
		super(name, engineType, range, endurance, numMaxPassengers, maxPayload);
	}

	public AbstractTerrestrialVehicle(
			String name, EnumEngineType engineType, double range, double endurance,
			int numMaxPassengers, double maxPayload, 
			EnumGroundContactType groundContactType) {
		super(name, engineType, range, endurance, numMaxPassengers, maxPayload);
		this.groundContactType = groundContactType;
	}
	
	public AbstractTerrestrialVehicle(Node node) {
		super(node);
}

	public EnumGroundContactType getGroundContactType() {
		return groundContactType;
	}

	public void setGroundContactType(EnumGroundContactType groundContactType) {
		this.groundContactType = groundContactType;
	}

}
