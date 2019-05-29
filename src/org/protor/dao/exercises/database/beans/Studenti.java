package org.protor.dao.exercises.database.beans;

public class Studenti {

	//---------------------------------------
	// VARIABLE DECLARATION
	private String matricola;
	private String nome;
	private String cognome;
	private String city;
	private String corsoDiStudi;
	
	//---------------------------------------
	// GETTERS & SETTERS
	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCorsoDiStudi() {
		return corsoDiStudi;
	}
	public void setCorsoDiStudi(String corsoDiStudi) {
		this.corsoDiStudi = corsoDiStudi;
	}
	
}
