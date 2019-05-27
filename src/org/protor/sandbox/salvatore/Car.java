package org.protor.sandbox.salvatore;

import java.io.File;

public  class Car extends AbstractTerrestrialVehicle{

	public Car(EnumEngineType type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	public Car(File configFile) {
		super(configFile);
		// TODO Auto-generated constructor stub
	}

	public Car(String name, EnumEngineType engineType, double range, double endurance, int numMaxPassegers,
			double maxPayload, EnumGroundContactType groundContactType) {
		super(name, engineType, range, endurance, numMaxPassegers, maxPayload, groundContactType);
		// TODO Auto-generated constructor stub
	}

	public Car(String name, EnumEngineType engineType, double range, double endurance, int numMaxPassegers,
			double maxPayload) {
		super(name, engineType, range, endurance, numMaxPassegers, maxPayload);
		// TODO Auto-generated constructor stub
	}

	public Car(String name, EnumEngineType type) {
		super(name, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean loadFromFile(File configFile) {
		System.out.println("[Car] Reading data from file: "
		+configFile.getAbsolutePath());
		return false;
	}

}
