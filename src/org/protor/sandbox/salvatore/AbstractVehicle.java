package org.protor.sandbox.salvatore;

import java.io.File;

public abstract class AbstractVehicle {

	private String name = "";
	private EnumEngineType engineType= EnumEngineType.NONE;
	private double range = 0.0; //kilometres
	private double endurance = 0.0; //hours
	private int numMaxPassegers= 0;
	private double maxPayload = 0.0; //kg
	private File configFile;
	//-------------------------- CONSTRUCTORS
	public AbstractVehicle(File configFile) {
		super();
		this.configFile = configFile;
		this.loadFromFile(configFile);
	}



	protected abstract boolean loadFromFile(File configFile);

	public AbstractVehicle(EnumEngineType type) {
		this.engineType = type;
	}
	public AbstractVehicle(String name, EnumEngineType type) {
		this.name = name;
		this.engineType = type;
	}
	/**
	 * 
	 * @param name Name of Vehicle
	 * @param engineType Type of Vehicle
	 * @param range Number of kilometries (km)
	 * @param endurance km with full fuel (hours)
	 * @param numMaxPassegers Numbers of Passengers
	 * @param maxPayload Maximum Payload (kg)
	 */
	public AbstractVehicle(String name, 
			EnumEngineType engineType, double range, 
			double endurance, int numMaxPassegers,
			double maxPayload) {


		this.name = name;
		this.engineType = engineType;
		this.range = range;
		this.endurance = endurance;
		this.numMaxPassegers = numMaxPassegers;
		this.maxPayload = maxPayload;
	}

	//-----------------------------	 METHODS
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



	public int getNumMaxPassegers() {
		return numMaxPassegers;
	}



	public void setNumMaxPassegers(int numMaxPassegers) {
		this.numMaxPassegers = numMaxPassegers;
	}



	public double getMaxPayload() {
		return maxPayload;
	}



	public void setMaxPayload(double maxPayload) {
		this.maxPayload = maxPayload;
	}





}
