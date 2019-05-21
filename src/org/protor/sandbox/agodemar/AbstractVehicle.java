package org.protor.sandbox.agodemar;

import java.io.File;

public abstract class AbstractVehicle {
	
	private String name = "";
	private EnumEngineType engineType = EnumEngineType.NONE;
	private double range = 0.0; // km
	private double endurance = 0.0; // hours
	private int numMaxPassengers = 0;
	private double maxPayload = 0.0; // kg
	
	private File configFile;
	
	// --------------------------------------------- Constructors
	public AbstractVehicle(File configFile) {
		this.configFile = configFile;
		this.loadFromFile(this.configFile);
	}
	protected abstract boolean loadFromFile(File configFile);
	
	public AbstractVehicle(EnumEngineType engineType) {
		this.engineType = engineType;
	}

	public AbstractVehicle(String name, EnumEngineType engineType) {
		this.name = name;
		this.engineType = engineType;
	}

	/**
	 * 
	 * @param name Name of the Vehicle
	 * @param engine Type Type of the engine
	 * @param range Maximum possible distance (km)
	 * @param endurance Maximum possible travel time (hours)
	 * @param numMaxPassengers Maximum number of passengers
	 * @param maxPayload Maximum payload (kg)
	 */
	public AbstractVehicle(
			String name,
			EnumEngineType engineType, 
			double range, double endurance, 
			int numMaxPassengers, double maxPayload) {
		this.name = name;
		this.engineType = engineType;
		this.range = range;
		this.endurance = endurance;
		this.numMaxPassengers = numMaxPassengers;
		this.maxPayload = maxPayload;
	}

	// --------------------------------------------- Methods
	/**
	 * 
	 * @return Returns the given name of the vehicle
	 */
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public EnumEngineType getEngineType() {
		return engineType;
	}

	public void setEngineType(EnumEngineType engineType) {
		this.engineType = engineType;
	}
	public double getRange() {
		return range;
	}
	public void setRange(double range) {
		this.range = range;
	}
	public double getEndurance() {
		return endurance;
	}
	public void setEndurance(double endurance) {
		this.endurance = endurance;
	}
	public int getNumMaxPassengers() {
		return numMaxPassengers;
	}
	public void setNumMaxPassengers(int numMaxPassengers) {
		this.numMaxPassengers = numMaxPassengers;
	}
	public double getMaxPayload() {
		return maxPayload;
	}
	public void setMaxPayload(double maxPayload) {
		this.maxPayload = maxPayload;
	}

}
