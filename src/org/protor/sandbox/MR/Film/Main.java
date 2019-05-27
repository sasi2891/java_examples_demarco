package org.protor.sandbox.MR.Film;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.protor.sandbox.MR.NumeroDiTelefono;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Variabili
		Scanner tastiera = new Scanner(System.in);
		String nomeFile;
		Scanner letturaFile;
		List<Film> listaFilm = new ArrayList<Film>();
		int scelta = 0;
		String nomeFilm;
		
		//Lettura file di input
		System.out.println("BENVENUTO NELLA GESTIONE FILM");
		System.out.println("\nInserire il nome del file di input con estensione (es: \"file.txt\") ");
		
		nomeFile = tastiera.nextLine();
		
		File fileInput = new File("input"+ File.separator + nomeFile);
		try {
			letturaFile = new Scanner(fileInput);
			System.out.println("File letto correttamente!");
			int i=0;
			while (letturaFile.hasNextLine()) {
				listaFilm.add(new Film());
				nomeFilm = letturaFile.nextLine();
				String[] arrayFilm = nomeFilm.split("\\(");
				listaFilm.get(i).setTitoloFilm(arrayFilm[0].trim());
				listaFilm.get(i).setClassificazione(ClassificazioneENUM.valueOf(
						arrayFilm[1].trim().substring(0, arrayFilm[1].length()-1)));
				i++;
			}
			stampaLista(listaFilm);
			
			System.out.println("Di quale film si vuole inserire la votazione?");
			int film = tastiera.nextInt();
			int index = film-1;
			System.out.println("Inserire le votazioni del film separate da virgola");
			tastiera.nextLine();
			
			//Continua qui
	}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Il file non è stato trovato!");
		}
	}
		public static void stampaLista(List<Film> listaDaStampare) {
			int j=0;
			for(int i=0; i<listaDaStampare.size(); i++) {
				j=i+1;
				System.out.println(j +") " + listaDaStampare.get(i).getTitoloFilm());
			}
		}

}
