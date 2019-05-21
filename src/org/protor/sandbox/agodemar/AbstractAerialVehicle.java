package org.protor.sandbox.agodemar;

import java.io.File;

public abstract class AbstractAerialVehicle extends AbstractVehicle {

	public AbstractAerialVehicle(EnumEngineType type) {
		super(type);
	}

	public AbstractAerialVehicle(String name, EnumEngineType type) {
		super(name, type);
	}

	public AbstractAerialVehicle(File configFile) {
		super(configFile);
	}

	public AbstractAerialVehicle(String name, EnumEngineType engineType, double range, double endurance,
			int numMaxPassengers, double maxPayload) {
		super(name, engineType, range, endurance, numMaxPassengers, maxPayload);
	}
	

}
