package org.protor.sandbox.MR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumeroDiTelefono {

	// variabili
	String prefissoInternazionale = "0",
	prefissoNazionale = "0",
	numero = "0";

	// metodi

	public NumeroDiTelefono(String numeroCompleto) {

		List<String> numeroPrefissi = toStrings(numeroCompleto);

		if(numeroPrefissi.size() == 2) {
			this.prefissoNazionale = numeroPrefissi.get(0);
			this.numero = numeroPrefissi.get(1);
		}
		else if(numeroPrefissi.size() == 3) {
			this.prefissoInternazionale = numeroPrefissi.get(0);
			this.prefissoNazionale = numeroPrefissi.get(1);
			this.numero = numeroPrefissi.get(2);
		}
		else {
			System.out.println("Formato numero non corretto!");
		}
	};

	public List<String> toStrings(String numeroCompleto){

		List<String> numeroPrefissi = new ArrayList<String>();

		String[] arrayStringhe = numeroCompleto.split("-");
		numeroPrefissi = Arrays.asList(numeroCompleto.split("-"));
		//		
		//		for(int i =0 ; i<arrayStringhe.length; i++) {
		//			numeroPrefissi.add(i, arrayStringhe[i]);
		//		}
		return numeroPrefissi;

	}
	@Override
	public String toString() {
		String numeroOutput = "";
		if(!prefissoInternazionale.equals("0"))
		numeroOutput = prefissoInternazionale + "-" + 
				prefissoNazionale + "-"+
				numero;
		else
			numeroOutput = prefissoNazionale + "-"+
					numero;
		
		return numeroOutput;
	}
}
