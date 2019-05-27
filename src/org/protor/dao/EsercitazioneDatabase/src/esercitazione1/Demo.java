package esercitazione1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Vittorio Trifari
 * @see https://www.youtube.com/watch?v=5vzCjvUwMXg
 *
 * Java JDBC Pattern Tutorial
 *
 * 1) Import the package
 * 2) Load and Register driver --> com.mysql.jdbc.Driver (need to import the mysql.jar)
 * 3) Create Connection
 * 4) Create Statement
 * 5) Execute the query
 * 6) Process the results
 * 7) Close connection
 * 
 */

public class Demo {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		//--------------------------------------------------------------------
		// LOAD AND REGISTER THE DRIVER 
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//--------------------------------------------------------------------
		// CREATE CONNECTION
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/acquisti"   // url
				+ "?useUnicode=true"				     // unicode
				+ "&useJDBCCompliantTimezoneShift=true"  // timezone shift
				+ "&useLegacyDatetimeCode=false"         // legacy datetime
				+ "&serverTimezone=UTC"                  // server timezone
				+ "&useSSL=false",	                     // ssl
				"root",							         // username
				"1234"							         // password
				);
		
		//--------------------------------------------------------------------
		// CREATE STATEMENT
		Statement statement = con.createStatement();
		
		//--------------------------------------------------------------------
		// EXECUTE THE QUERY
		String query = "SELECT * FROM Prodotti WHERE Marca='IBM' AND Nome='Desktop'";
		ResultSet resultSet = statement.executeQuery(query);
		
		//--------------------------------------------------------------------
		// PROCESS RESULTS
		resultSet.next();
		System.out.println(
				resultSet.getInt("CodiceProdotto") + ", "
						+ resultSet.getString("Nome") + ", "
						+ resultSet.getString("Marca") + ", "
						+ resultSet.getString("Modello"));
		
		//--------------------------------------------------------------------
		// CLOSE CONNECTION, STATEMENT, RESULT
		resultSet.close();
		statement.close();
		con.close();
		
	}

}
