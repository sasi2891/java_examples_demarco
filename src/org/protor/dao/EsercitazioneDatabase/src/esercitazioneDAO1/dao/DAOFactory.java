package esercitazioneDAO1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {

	//-----------------------------------
	// VARIABLE DECLARATION
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DATABASE_USER = "root";
	public static final String DATABASE_PASSWORD = "1234";
	public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/esercizio1" 
			+ "?useUnicode=true"				     
			+ "&useJDBCCompliantTimezoneShift=true"  
			+ "&useLegacyDatetimeCode=false"         
			+ "&serverTimezone=UTC"                  
			+ "&useSSL=false"
			;	

	protected Connection connection;
	protected DAOFactory daoFactoryImplementation;
	
	//-----------------------------------
	// BUILDER
	public DAOFactory () {
		createConnection();
	}
	
	//-----------------------------------
	// METHODS
	private void createConnection() {
		
		try {
			Class.forName(DRIVER);
			this.connection = DriverManager.getConnection(
					DATABASE_URL,
					DATABASE_USER,
					DATABASE_PASSWORD
					);
					
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//-----------------------------------
	// GETTERS & SETTERS
	public Connection getConnection() {
		return connection;
	}
	
	public DAOFactory getDaoFactoryImplementation() {
		return daoFactoryImplementation;
	};
}
