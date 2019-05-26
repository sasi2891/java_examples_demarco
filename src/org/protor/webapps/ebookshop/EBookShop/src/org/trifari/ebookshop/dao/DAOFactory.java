package org.trifari.ebookshop.dao;

import org.trifari.ebookshop.dao.mysql.MySQLDAOFactory;
import org.trifari.ebookshop.enumerations.DatabaseEnum;

public abstract class DAOFactory {

	 /** Metodo astratto per la DAOInterface*/
	public abstract DAOInterface getDAO();
	
	/**
	 * Metodo Factory
	 * 
	 * @param database il database da scegliere
	 * @return la factory corrispondente
	 */
	public static DAOFactory getDAOFactory(DatabaseEnum database) {
		switch (database) {
		case MySQL:
			return new MySQLDAOFactory();
		case ORACLE:
			// TODO;
		case SQLServer:
			// TODO;
		default:
			return null;
		}
	}
}
