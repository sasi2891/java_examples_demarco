package esercitazioneDAO1.beans;

import java.sql.Date;

public class Esami {

	//---------------------------------------
	// VARIABLE DECLARATION
	private String matricola;
	private int codice;
	private Date data;
	private int voto;
	
	//---------------------------------------
	// GETTERS & SETTERS
	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	
}
