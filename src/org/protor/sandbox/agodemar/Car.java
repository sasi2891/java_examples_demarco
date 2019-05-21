package org.protor.sandbox.agodemar;

import java.io.File;

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

	@Override
	protected boolean loadFromFile(File configFile) {
		
		// TODO agodemar: implement the logic here
		
		return false;
	}

}
