package org.protor.sandbox.agodemar;

public class MyVehicle {
	
	private String name = "";
	private MyVehicleType type;
	
	public MyVehicle(MyVehicleType type) {
		this.type = type;
	}
	public MyVehicle(String name, MyVehicleType type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public MyVehicleType getType() {
		return type;
	}
	public void setType(MyVehicleType type) {
		this.type = type;
	}


}
