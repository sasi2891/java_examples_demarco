package esercitazioneDAO1.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import esercitazioneDAO1.beans.Corsi;
import esercitazioneDAO1.beans.Esami;
import esercitazioneDAO1.beans.Studenti;

public class MySQLFactoryImplementation extends DAOFactory implements DAOInterface{

	//-----------------------------------
	// VARIABLE DECLARATION
	/* Parametrizzare in funzione della tabella in esame */
	public static final String CREATE_QUERY = "INSERT INTO ";
	public static final String READ_QUERY = "SELECT * FROM ";
	public static final String UPDATE_QUERY = "UPDATE ";
	public static final String DELETE_QUERY = "DELETE FROM ";
	public static final String READ_COLUMN_NAMES_QUERY = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.columns WHERE TABLE_NAME = '";
	
	private PreparedStatement statement = null;
	private ResultSet result = null;
	
	//-----------------------------------
	// BUILDER
	public MySQLFactoryImplementation() {
		super();
	}

	//-----------------------------------
	// METHODS
	public void create(String nomeTabella, Object obj) {
		
		PreparedStatement statementReadColumnNames = null;
		try {
			statementReadColumnNames = super.connection.prepareStatement(
					READ_COLUMN_NAMES_QUERY 
					+ nomeTabella 
					+ "'"
					);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			result = statementReadColumnNames.executeQuery();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		switch (nomeTabella) {
		case "corsi":
			try {
				
				Corsi corso = (Corsi) obj;
				
				String queryFinal = CREATE_QUERY + nomeTabella + " (";
				while (result.next()) {
					queryFinal += result.getString(1) + ",";
				}
				queryFinal = queryFinal.substring(0, queryFinal.length()-1);
				queryFinal += ") VALUES ("
						+ "" + corso.getCodice() + ", "
						+ "'" + corso.getTitolo() + "', "
						+ "'" + corso.getNomeDocente() + "'"
						+ ");";
				
				statement = super.connection.prepareStatement(queryFinal);
				statement.execute();
				System.out.println("\tCreazione dell'oggetto in tabella '"
						+ nomeTabella  
						+ " riuscita.");

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		case "esami":
			try {

				Esami esame = (Esami) obj;
				
				String queryFinal = CREATE_QUERY + nomeTabella + " (";
				while (result.next()) {
					queryFinal += result.getString(1) + ",";
				}
				queryFinal = queryFinal.substring(0, queryFinal.length()-1);
				queryFinal += ") VALUES ("
						+ "'" + esame.getMatricola() + "', "
						+ "" + esame.getCodice() + ", "
						+ "'" + esame.getData() + "', "
						+ "" + esame.getVoto() + ""
						+ ");";
				
				statement = super.connection.prepareStatement(queryFinal);
				statement.execute();
				System.out.println("\tCreazione dell'oggetto in tabella '"
						+ nomeTabella  
						+ " riuscita.");
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		case "studenti":
			try {

				Studenti studente = (Studenti) obj;
				
				String queryFinal = CREATE_QUERY + nomeTabella + " (";
				while (result.next()) {
					queryFinal += result.getString(1) + ",";
				}
				queryFinal = queryFinal.substring(0, queryFinal.length()-1);
				queryFinal += ") VALUES ("
						+ "'" + studente.getMatricola() + "', "
						+ "'" + studente.getNome() + "', "
						+ "'" + studente.getCognome() + "', "
						+ "'" + studente.getCittà() + "', "
						+ "'" + studente.getCorsoDiStudi() + "'"
						+ ");";
				
				statement = super.connection.prepareStatement(queryFinal);
				statement.execute();
				System.out.println("\tCreazione dell'oggetto in tabella '"
						+ nomeTabella  
						+ " riuscita.");
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		default:
			break;
		}
		
	}

	public List<Object> readAll(String nomeTabella) {
		
		List<Object> lista = new ArrayList<>();
		
		switch (nomeTabella) {
		case "corsi":
			Corsi corso;
			try {
				statement = super.connection.prepareStatement(READ_QUERY + nomeTabella);
				result = statement.executeQuery();
				
				while (result.next()) {
					corso = new Corsi();
					corso.setCodice(result.getInt(1));
					corso.setTitolo(result.getString(2));
					corso.setNomeDocente(result.getString(3));
					
					lista.add(corso);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		case "esami":
			Esami esame;
			try {
				statement = super.connection.prepareStatement(READ_QUERY + nomeTabella);
				result = statement.executeQuery();
				
				while (result.next()) {
					esame = new Esami();
					esame.setMatricola(result.getString(1));
					esame.setCodice(result.getInt(2));
					esame.setData(result.getDate(3));
					esame.setVoto(result.getInt(4));
					
					lista.add(esame);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		case "studenti":
			Studenti studente;
			try {
				statement = super.connection.prepareStatement(READ_QUERY + nomeTabella);
				result = statement.executeQuery();
				
				while (result.next()) {
					studente = new Studenti();
					studente.setMatricola(result.getString(1));
					studente.setNome(result.getString(2));
					studente.setCognome(result.getString(3));
					studente.setCittà(result.getString(4));
					studente.setCorsoDiStudi(result.getString(5));
					
					lista.add(studente);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		default:
			break;
		}
		
		return lista;
	}

	public Object read(String nomeTabella, String nomeParametro, Object obj) {
		Object output = null;
		
		switch (nomeTabella) {
		case "corsi":
			try {
				statement = super.connection.prepareStatement(
						READ_QUERY 
						+ nomeTabella
						+ " WHERE "
						+ nomeParametro
						+ " = "
						+ (Integer) obj);
				result = statement.executeQuery();
				
				while (result.next() && result != null) {
					Corsi corso = new Corsi();
					corso.setCodice(result.getInt(1));
					corso.setTitolo(result.getString(2));
					corso.setNomeDocente(result.getString(3));
					
					output = corso;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		case "esami":
			List<Esami> listaEsami = new ArrayList<>();
			try {
				statement = super.connection.prepareStatement(
						READ_QUERY 
						+ nomeTabella
						+ " WHERE "
						+ nomeParametro
						+ " = "
						+ (Integer) obj);
				result = statement.executeQuery();
				
				while (result.next()) {
					Esami esame = new Esami();
					esame.setMatricola(result.getString(1));
					esame.setCodice(result.getInt(2));
					esame.setData(result.getDate(3));
					esame.setVoto(result.getInt(4));
					
					listaEsami.add(esame);
				}
				
				output = listaEsami;
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		case "studenti":
			try {
				statement = super.connection.prepareStatement(
						READ_QUERY 
						+ nomeTabella
						+ " WHERE "
						+ nomeParametro
						+ " = "
						+ (String) obj);
				result = statement.executeQuery();
				
				while (result.next() && result != null) {
					Studenti studente = new Studenti();
					studente.setMatricola(result.getString(1));
					studente.setNome(result.getString(2));
					studente.setCognome(result.getString(3));
					studente.setCittà(result.getString(4));
					studente.setCorsoDiStudi(result.getString(5));
					
					output = studente;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		default:
			break;
		}
		
		return output;
	}

	public void update(String nomeTabella, String nomeParametro, Object obj) {
		
		PreparedStatement statementReadColumnNames = null;
		try {
			statementReadColumnNames = super.connection.prepareStatement(
					READ_COLUMN_NAMES_QUERY 
					+ nomeTabella 
					+ "'"
					);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			result = statementReadColumnNames.executeQuery();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		switch (nomeTabella) {
		case "corsi":
			try {
				
				Corsi corso = (Corsi) obj;
				
				result.next();
				result.next();
				String queryFinal = UPDATE_QUERY + nomeTabella + " SET "
						+ result.getString(1) + " = '" + corso.getTitolo() + "', ";
				result.next();
				queryFinal += result.getString(1) + " = '" + corso.getNomeDocente() + "'";
				queryFinal += " WHERE " + nomeParametro + " = '" + corso.getCodice() + "'";
				
				statement = super.connection.prepareStatement(queryFinal);
				statement.execute();
				System.out.println("\tAggiornamento dell'oggetto in tabella '"
						+ nomeTabella  
						+ "' in concomitanza del valore "
						+ corso.getCodice() 
						+ " riuscita.");

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		case "esami":
			try {

				Esami esame = (Esami) obj;
				
				result.next();
				String queryFinal = UPDATE_QUERY + nomeTabella + " SET "
						+ result.getString(1) + " = '" + esame.getMatricola() + "', ";
				result.next();
				result.next();
				queryFinal += result.getString(1) + " = '" + esame.getData() + "', ";
				result.next();
				queryFinal += result.getString(1) + " = '" + esame.getVoto() + "'";
				queryFinal += " WHERE " + nomeParametro + " = '" + esame.getCodice() + "'";
				
				statement = super.connection.prepareStatement(queryFinal);
				statement.execute();
				System.out.println("\tAggiornamento dell'oggetto in tabella '"
						+ nomeTabella  
						+ "' in concomitanza del valore "
						+ esame.getCodice() 
						+ " riuscita.");
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		case "studenti":
			try {

				Studenti studente = (Studenti) obj;
				
				result.next();
				result.next();
				String queryFinal = UPDATE_QUERY + nomeTabella + " SET "
						+ result.getString(1) + " = '" + studente.getNome() + "', ";
				result.next();
				queryFinal += result.getString(1) + " = '" + studente.getCognome() + "', ";
				result.next();
				queryFinal += result.getString(1) + " = '" + studente.getCittà() + "', ";
				result.next();
				queryFinal += result.getString(1) + " = '" + studente.getCorsoDiStudi() + "'";
				queryFinal += " WHERE " + nomeParametro + " = '" + studente.getMatricola() + "'";
				
				statement = super.connection.prepareStatement(queryFinal);
				statement.execute();
				System.out.println("\tAggiornamento dell'oggetto in tabella '"
						+ nomeTabella  
						+ "' in concomitanza del valore "
						+ studente.getMatricola() 
						+ " riuscita.");
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		default:
			break;
		}
		
	}

	public void delete(String nomeTabella, String nomeParametro, Object obj) {
		
		switch (nomeTabella) {
		case "corsi":
			try {
				statement = super.connection.prepareStatement(
						DELETE_QUERY 
						+ nomeTabella
						+ " WHERE "
						+ nomeParametro
						+ " = "
						+ (Integer) obj);
				statement.execute();
				System.out.println("\tEliminazione di " 
						+ nomeParametro 
						+ " in tabella '"
						+ nomeTabella 
						+ "' in concomitanza del valore "
						+ (Integer) obj 
						+ " riuscita.");

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		case "esami":
			try {
				statement = super.connection.prepareStatement(
						DELETE_QUERY 
						+ nomeTabella
						+ " WHERE "
						+ nomeParametro
						+ " = "
						+ (Integer) obj);
				statement.execute();
				System.out.println("\tEliminazione di " 
						+ nomeParametro 
						+ " in tabella '"
						+ nomeTabella 
						+ "' in concomitanza del valore "
						+ (Integer) obj 
						+ " riuscita.");
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		case "studenti":
			try {
				statement = super.connection.prepareStatement(
						DELETE_QUERY 
						+ nomeTabella
						+ " WHERE "
						+ nomeParametro
						+ " = "
						+ (String) obj);
				statement.execute();
				System.out.println("\tEliminazione di " 
						+ nomeParametro 
						+ " in tabella '"
						+ nomeTabella 
						+ "' in concomitanza del valore "
						+ (String) obj 
						+ " riuscita.");

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		default:
			break;
		}
	}
}
