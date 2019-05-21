package org.protor.sandbox.MR;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class mainRubrica {

	public static void main(String[] args) {

		//Variabili
		Scanner tastiera = new Scanner(System.in);
		String nomeFile;
		Scanner letturaFile;
		
		//Lettura file di input
		System.out.println("BENVENUTO NELLA RUBRICA");
		System.out.println("\nInserire il nome del file di input con estensione (es: \"file.txt\") ");
		
		nomeFile = tastiera.nextLine();
		
		File fileInput = new File("input"+ File.separator + nomeFile);
		try {
			letturaFile = new Scanner(fileInput);
			System.out.println("File letto correttamente!");
			while (letturaFile.hasNextLine()) {
				System.out.println(letturaFile.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Serena hai sbagliato classe!");
		}
		System.out.println("Fine Programma!");
		
	}

}
