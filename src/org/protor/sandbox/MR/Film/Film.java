package org.protor.sandbox.MR.Film;

import java.util.HashMap;
import java.util.Map;

public class Film {

	// Variabili
	String titoloFilm;
	ClassificazioneENUM classificazione;
	Map<votazioniENUM, Integer> mappaVotazioni = new HashMap<votazioniENUM, Integer>();
	

	//Getter setter
	public String getTitoloFilm() {
		return titoloFilm;
	}
	public void setTitoloFilm(String titoloFilm) {
		this.titoloFilm = titoloFilm;
	}
	public ClassificazioneENUM getClassificazione() {
		return classificazione;
	}
	public void setClassificazione(ClassificazioneENUM classificazione) {
		this.classificazione = classificazione;
	}}
