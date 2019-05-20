package org.protor.polymorphism;

public class Vehicle {
	
	private String name = "";
	private VehicleType type;
	
	public Vehicle(VehicleType type) {
		this.type = type;
	}
	public Vehicle(String name, VehicleType type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public VehicleType getType() {
		return type;
	}
	public void setType(VehicleType type) {
		this.type = type;
	}


}
