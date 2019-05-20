package org.protor.filesio.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Test02 {

	public static void main(String[] args) {

		System.out.println("Java example - 02");

		// Print out the list of arguments
		System.out.println("Argument count: " + args.length);
		for (int i = 0; i < args.length; ++i)
			System.out.println("Arg. " + i + " --> " + args[i]);
		
		if (args.length == 3) {
			// we are given a correct command line of arguments
			File outputFile = new File(args[0]);
			
			System.out.println(
					"Output file full path: " + outputFile.getAbsolutePath());
			
			// DON'T DO THIS: args[1] == "-nrows"
			if (args[1].toUpperCase().equals("-NROWS")) {
				
				// now get the number of rows
				int nRows;
				
				try {
					
					nRows = Integer.parseInt(args[2]);
					System.out.println("Number of rows parsed: " + nRows);
					
					System.out.println("Now writing in file...");
					
					PrintWriter writer = new PrintWriter(outputFile, "UTF-8");
					
					writer.println("-----");
					
					for (int k = 0; k < nRows; ++k) {
						
						writer.println(k + ") Hello world!");
					}
					writer.close();
					System.out.println("File closed.");
					
				} catch (NumberFormatException e) {
					System.err.println("Unable to parse argv[2] into an integer number.");
					e.printStackTrace();
					System.out.println("Terminating.");
					return;
				} catch (FileNotFoundException e) {
					System.err.println("Unable to find file.");
					e.printStackTrace();
					System.out.println("Terminating.");
					return;
				} catch (UnsupportedEncodingException e) {
					System.err.println("Incorrect file encoding.");
					e.printStackTrace();
					System.out.println("Terminating.");
					return;
				}		
			} else {
				System.out.println("Incorrect program use!");
				System.out.println("Second argument must be: -nrows");
				System.out.println("Terminating.");
				return;
			}
			
		} else {
			System.out.println("Incorrect program use!");
			System.out.println("Must be:");
			System.out.println("\t<program name> <file name> -nrows <int>");
		}
		
	}

}
