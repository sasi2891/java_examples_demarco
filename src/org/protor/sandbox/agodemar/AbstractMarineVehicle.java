package org.protor.sandbox.agodemar;

import java.io.File;

public abstract class AbstractMarineVehicle extends AbstractVehicle {

	public AbstractMarineVehicle(File configFile) {
		super(configFile);
	}

	public AbstractMarineVehicle(String name, EnumEngineType engineType, double range, double endurance,
			int numMaxPassengers, double maxPayload) {
		super(name, engineType, range, endurance, numMaxPassengers, maxPayload);
	}

	public AbstractMarineVehicle(EnumEngineType engineType) {
		super(engineType);
	}

	public AbstractMarineVehicle(String name, EnumEngineType engineType) {
		super(name, engineType);
	}

}
