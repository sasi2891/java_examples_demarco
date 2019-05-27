import java.sql.Date;
import java.util.List;

import esercitazioneDAO1.beans.Corsi;
import esercitazioneDAO1.beans.Esami;
import esercitazioneDAO1.beans.Studenti;
import esercitazioneDAO1.dao.MySQLFactoryImplementation;
import esercitazioneDAO1.enumerations.DatabaseType;

public class Demo {

	public static void main(String[] args) {

		//------------------------------------------
		// INPUT DATA
		DatabaseType type = DatabaseType.MySQL;
		
		//-------------------------------------------
		// MAIN
		switch (type) {
		case MySQL:
			MySQLFactoryImplementation daoSQL = new MySQLFactoryImplementation();
			
			/* Test READ_ALL */
			System.out.println("-> READ ALL ...\n");
			System.out.println("\tCORSI");
			List<Object> listaCorsi = daoSQL.readAll("corsi");
			listaCorsi.stream()
			.map(lc -> (Corsi) lc)
			.forEach(lc -> System.out.println(
					"\t" + String.valueOf(lc.getCodice())
					+ ", " + String.valueOf(lc.getTitolo())
					+ ", " + String.valueOf(lc.getNomeDocente())
					)
					);	
			System.out.println("\n");
			
			System.out.println("\tESAMI");
			List<Object> listaEsami = daoSQL.readAll("esami");
			listaEsami.stream()
			.map(le -> (Esami) le)
			.forEach(le -> System.out.println(
					"\t" + String.valueOf(le.getMatricola())
					+ ", " + String.valueOf(le.getCodice())
					+ ", " + String.valueOf(le.getData())
					+ ", " + String.valueOf(le.getVoto())
					)
					);	
			System.out.println("\n");
			
			System.out.println("\tSTUDENTI");
			List<Object> listaStudenti = daoSQL.readAll("studenti");
			listaStudenti.stream()
			.map(ls -> (Studenti) ls)
			.forEach(ls -> System.out.println(
					"\t" + String.valueOf(ls.getMatricola())
					+ ", " + String.valueOf(ls.getNome())
					+ ", " + String.valueOf(ls.getCognome())
					+ ", " + String.valueOf(ls.getCittà())
					+ ", " + String.valueOf(ls.getCorsoDiStudi())
					)
					);	
			System.out.println("\n\n");
			
			/* Test READ */
			System.out.println("-> READ ...\n");
			System.out.println("\tCORSI ('codiceCorso')");
			Corsi corso = (Corsi) daoSQL.read("corsi", "codiceCorso", 1);
			System.out.println(
					"\t" + String.valueOf(corso.getCodice())
					+ ", " + String.valueOf(corso.getTitolo())
					+ ", " + String.valueOf(corso.getNomeDocente())
					);	
			System.out.println("\n");
			
			System.out.println("\tESAMI ('codiceCorso')");
			
			@SuppressWarnings("unchecked") 
			List<Esami> listaEsamiByCodice = (List<Esami>) daoSQL.read("esami", "codiceCorso", 2);
			
			listaEsamiByCodice.stream()
			.map(le -> (Esami) le)
			.forEach(le -> System.out.println(
					"\t" + String.valueOf(le.getMatricola())
					+ ", " + String.valueOf(le.getCodice())
					+ ", " + String.valueOf(le.getData())
					+ ", " + String.valueOf(le.getVoto())
					)
					);	
			System.out.println("\n");
			
			System.out.println("\tSTUDENTI ('matricola')");
			Studenti studente = (Studenti) daoSQL.read("studenti", "matricola", "'M001'");
			System.out.println(
					"\t" + String.valueOf(studente.getMatricola())
					+ ", " + String.valueOf(studente.getNome())
					+ ", " + String.valueOf(studente.getCognome())
					+ ", " + String.valueOf(studente.getCittà())
					+ ", " + String.valueOf(studente.getCorsoDiStudi())
					);	
			System.out.println("\n\n");
			
			/* Test DELETE */
			System.out.println("-> DELETE ...\n");
			System.out.println("\n\tCORSI ('codiceCorso')");
			daoSQL.delete("corsi", "codiceCorso", 1);
			System.out.println("\n\tESAMI('codiceCorso')");
			daoSQL.delete("esami", "codiceCorso", 2);
			System.out.println("\n\tSTUDENTI ('matricola')");
			daoSQL.delete("studenti", "matricola", "'M001'");
			System.out.println("\n\n");
			
			/* Test CREATE */
			System.out.println("-> CREATE ...\n");
			
			System.out.println("\n\tCORSI");
			Corsi corsoAnalisi = new Corsi();
			corsoAnalisi.setCodice(1);
			corsoAnalisi.setTitolo("Analisi 2");
			corsoAnalisi.setNomeDocente("Alvino");
			daoSQL.create("corsi", corsoAnalisi);
			
			System.out.println("\n\tSTUDENTI");
			Studenti studenteVittorio = new Studenti();
			studenteVittorio.setMatricola("M001");
			studenteVittorio.setNome("Vittorio");
			studenteVittorio.setCognome("Trifari");
			studenteVittorio.setCittà("Napoli");
			studenteVittorio.setCorsoDiStudi("ING_AER");
			daoSQL.create("studenti", studenteVittorio);
			
			System.out.println("\n\tESAMI");
			Esami esameInformatica = new Esami();
			esameInformatica.setMatricola("M001");
			esameInformatica.setCodice(2);
			esameInformatica.setData(Date.valueOf("2018-05-21"));
			esameInformatica.setVoto(25);
			daoSQL.create("esami", esameInformatica);
			System.out.println("\n\n");
			
			/* Test UPDATE */
			System.out.println("-> UPDATE ...\n");
			System.out.println("\n\tCORSI");
			corsoAnalisi.setTitolo("Analisi 3");
			corsoAnalisi.setNomeDocente("Mercaldo");
			daoSQL.update("corsi", "codiceCorso", corsoAnalisi);
			
			System.out.println("\n\tSTUDENTI");
			studenteVittorio.setNome("Valerio");
			studenteVittorio.setCognome("Booo");
			studenteVittorio.setCittà("Taormina");
			studenteVittorio.setCorsoDiStudi("ING_MECC");
			daoSQL.update("studenti", "matricola", studenteVittorio);
			
			System.out.println("\n\tESAMI");
			esameInformatica.setMatricola("M001");
			esameInformatica.setData(Date.valueOf("2018-10-03"));
			esameInformatica.setVoto(28);
			daoSQL.update("esami", "codiceCorso", esameInformatica);
			System.out.println("\n\n");
			
			/* Test READ_ALL (VERIFICA) */
			System.out.println("-> READ ALL (VERIFICA)...\n");
			System.out.println("\tCORSI");
			listaCorsi = daoSQL.readAll("corsi");
			listaCorsi.stream()
			.map(lc -> (Corsi) lc)
			.forEach(lc -> System.out.println(
					"\t" + String.valueOf(lc.getCodice())
					+ ", " + String.valueOf(lc.getTitolo())
					+ ", " + String.valueOf(lc.getNomeDocente())
					)
					);	
			System.out.println("\n");
			
			System.out.println("\tESAMI");
			listaEsami = daoSQL.readAll("esami");
			listaEsami.stream()
			.map(le -> (Esami) le)
			.forEach(le -> System.out.println(
					"\t" + String.valueOf(le.getMatricola())
					+ ", " + String.valueOf(le.getCodice())
					+ ", " + String.valueOf(le.getData())
					+ ", " + String.valueOf(le.getVoto())
					)
					);	
			System.out.println("\n");
			
			System.out.println("\tSTUDENTI");
			listaStudenti = daoSQL.readAll("studenti");
			listaStudenti.stream()
			.map(ls -> (Studenti) ls)
			.forEach(ls -> System.out.println(
					"\t" + String.valueOf(ls.getMatricola())
					+ ", " + String.valueOf(ls.getNome())
					+ ", " + String.valueOf(ls.getCognome())
					+ ", " + String.valueOf(ls.getCittà())
					+ ", " + String.valueOf(ls.getCorsoDiStudi())
					)
					);	
			System.out.println("\n\n");
			
			break;
		case ORACLE:
			/* TODO */
			break;
		case SQLServer:
			/* TODO */
			break;
		default:
			break;
		}
	}
}
