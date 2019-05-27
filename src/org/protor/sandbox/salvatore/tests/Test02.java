package org.protor.sandbox.salvatore.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test02 {

	public static void main(String[] args) {
		//C:\Users\PC4.DESKTOP-I9IUIOA\Desktop\github\java_examples_demarco\input

		//String fileName= "cars.xml";	
		//File carsFile=new File("input"+ File.separator +fileName); //dopo new è la chiamata al costruttore di questa classe

		if(args.length != 0 ) {
			//get the file name
			String filePath= args[0]; //in questa run configuration ho passato una stringa in inpur al main e creo unoggetto di tipo stringa e lo chiamo filename e lo associo alla mia stringa contenuta in posizione 0 dell array
			File carsFile=new File(filePath);
			//	if(!carsFile.exists()) { // . exist è un metodo della classe file che mi comunica se il file esiste o no con un booleano
            //	System.err.println("File " + carsFile.getAbsolutePath() +" not found./n"
			//						+"Terminating");
			//	System.exit(1);}
			// read file line by line
			FileReader fileReader;
			try {
				fileReader= new FileReader(carsFile); //se il costruttore file reader non trova il file crea un file di tipo filenotfoundexeption e lo chiama e a questo punto viene sollevata un eccezione e si passa al catch
				System.out.println("Found file: " +carsFile.getAbsolutePath());
				System.out.println("-------------------------------------");
				System.out.println("Reading by file, line by line...");
				
				BufferedReader br=new BufferedReader(fileReader);
				String currentLine; 
				int counter=0;
				 while((currentLine= br.readLine()) != null) {
					 System.out.println(++counter + ":" +currentLine); // ++ counter me lo incrementa prima e poi lo stampa in modo tale da non far uscire zero come prima linea e inizia con 1
				 }
				
				
			} catch (FileNotFoundException e) {
				//e.printStackTrace();
				System.err.println("File " + carsFile.getAbsolutePath() +" not found./n"
						+"Terminating");
				System.exit(1);
			} catch (IOException e) {
				//e.printStackTrace();
				System.err.println("An I/O problem occurred with file " + carsFile.getAbsolutePath() +"/n"
						+"Terminating");
				System.exit(1);
			}
		}else {
			System.err.println(" You must run this program with the arguments. \n"
					+ "Terminating.");
			System.exit(1);
		}

	}
}