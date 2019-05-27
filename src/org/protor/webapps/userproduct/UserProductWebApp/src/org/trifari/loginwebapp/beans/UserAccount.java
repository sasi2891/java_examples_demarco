package org.trifari.loginwebapp.beans;

import org.trifari.loginwebapp.enumerations.GenderEnum;

public class UserAccount {

	private String ID;
	private String username;
	private GenderEnum gender;
	private String password;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public GenderEnum getGender() {
		return gender;
	}
	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}

