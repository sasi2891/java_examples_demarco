package org.protor.sandbox.MR;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mainRubrica {

	public static void main(String[] args) {

		//Variabili
		Scanner tastiera = new Scanner(System.in);
		String nomeFile;
		Scanner letturaFile;
		List<NumeroDiTelefono> listaNumeri = new ArrayList<NumeroDiTelefono>();
		int scelta = 0;
		
		//Lettura file di input
		System.out.println("BENVENUTO NELLA RUBRICA");
		System.out.println("\nInserire il nome del file di input con estensione (es: \"file.txt\") ");
		
		nomeFile = tastiera.nextLine();
		
		File fileInput = new File("input"+ File.separator + nomeFile);
		try {
			letturaFile = new Scanner(fileInput);
			System.out.println("File letto correttamente!");
			int i=0;
			while (letturaFile.hasNextLine()) {
//				NumeroDiTelefono numero = new NumeroDiTelefono(letturaFile.nextLine());
//				listaNumeri.add(numero);
				listaNumeri.add(new NumeroDiTelefono(letturaFile.nextLine()));
				i++;
			}
			stampaLista(listaNumeri);
			
			System.out.println("\nVuoi apportare qualche modifica alla rubrica? (y/n)");
			String continua = tastiera.nextLine();
			
			if(continua.equalsIgnoreCase("y")) {
				System.out.println("\n\tQuale modifica vuoi apportare? \n1-Aggiungi numero \n2-Cancella numero \n3-Modifica numero");
				scelta = tastiera.nextInt();
				switch (scelta) {
				case 1:
					//Aggiunta numero
					System.out.println("Scrivi il numero da inserire");
					listaNumeri.add(new NumeroDiTelefono(tastiera.next()));
					break;
				case 2:
					//Cancellazione numero
					System.out.println("Quale numero vuoi cancellare?");
					listaNumeri.remove(tastiera.nextInt()-1);
					break;
				case 3:
					//Modifica numero
					System.out.println("Inserire la posizione del numero "
							+ "che si vuole modificare");
					int indice = tastiera.nextInt();
					System.out.println("Inserire il nuovo numero "
							+ "che si vuole modificare");
					listaNumeri.set(indice-1,new NumeroDiTelefono(tastiera.next()));
					break;
				default:
					System.out.println("Attenzione il numero inserito non è corretto");
					break;
				}
				stampaLista(listaNumeri);
			
			}
			else if(continua.equalsIgnoreCase("n"))
				System.out.println("Arrivederci!");
			else
				System.out.println("Valore inserito non valido");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Il file non è stato trovato!");
		}
		System.out.println("Fine Programma!");
		
	}

	public static void stampaLista(List<NumeroDiTelefono> listaDaStampare) {
		int j=0;
		for(int i=0; i<listaDaStampare.size(); i++) {
			j=i+1;
			System.out.println(j +") " + listaDaStampare.get(i).toString());
		}
	}
}
