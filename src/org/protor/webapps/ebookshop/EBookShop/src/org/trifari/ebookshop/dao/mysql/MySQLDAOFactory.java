package org.trifari.ebookshop.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.trifari.ebookshop.dao.DAOFactory;
import org.trifari.ebookshop.dao.DAOInterface;

public class MySQLDAOFactory extends DAOFactory {

	/** la classe driver */
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    /** L'url al database */
    public static final String DBURL = "jdbc:mysql://localhost:3306/ebookshop"
    		 + "?useUnicode=true"
    		 + "&useJDBCCompliantTimezoneShift=true"
    		 + "&useLegacyDatetimeCode=false"
    		 + "&serverTimezone=UTC"
    		 + "&useSSL=false"
    		 + "&allowPublicKeyRetrieval=true";
    /** Lo username per le operazioni sul DB  */
    public static final String USER = "root";
    /** La password per le operazioni sul DB */
    public static final String PASS = "1234";
    
    /**
     * Metodo per creare una connessione sul DB MySQL
     * 
     * @return l'oggetto Connection.
     */
    public static Connection createConnection() {
        Connection conn = null;
        try {
        	Class.forName(DRIVER);
            conn = DriverManager.getConnection(DBURL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
        }
        return conn;
    }
	
	@Override
	public DAOInterface getDAO() {
		return new MySQLDAOFactoryImplementation();
	}

}
