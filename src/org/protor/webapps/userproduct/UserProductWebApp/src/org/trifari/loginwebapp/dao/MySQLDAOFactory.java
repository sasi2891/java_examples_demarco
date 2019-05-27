package org.trifari.loginwebapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDAOFactory extends DAOFactory {

	/** la classe driver */
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    /** L'url al database */
    public static final String DBURL = "jdbc:mysql://localhost:3306/userproduct"
    		 + "?useUnicode=true"
    		 + "&useJDBCCompliantTimezoneShift=true"
    		 + "&useLegacyDatetimeCode=false"
    		 + "&serverTimezone=UTC"
    		 + "&useSSL=false"
    		 + "&allowPublicKeyRetrieval=true";
    /** Lo username per le operazioni sul DB  */
    public static final String USER = "root";
    /** La password per le operazioni sul DB */
    public static final String PASS = "Vittorio22@Trifari90";

    /** L'oggetto Connection da utilizzare per la connssione al DB */
    protected Connection connection;
    protected MySQLDAOImpl daoImplementation;
    
    /**
     * Costruttore della classe che inizializza la connessione al DB
     */
    public MySQLDAOFactory () {
    	createConnection();
    }
    
    /**
     * Metodo per creare una connessione sul DB MySQL
     * 
     * @return l'oggetto Connection.
     */
    private void createConnection() {
        Connection conn = null;
        try {
        	Class.forName(DRIVER);
            conn = DriverManager.getConnection(DBURL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
        }
        
        this.connection = conn;
    }
    
    @Override
	public void implementDAO() {
		this.daoImplementation = new MySQLDAOImpl();
	}
    
    public Connection getConnection() {
    	return connection;
    }

    public MySQLDAOImpl getDAOImplementation() {
    	return daoImplementation;
    }
    
}

