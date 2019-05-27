package org.trifari.loginwebapp.dao;

import org.trifari.loginwebapp.enumerations.DAOFactoryEnum;

public abstract class DAOFactory {

	/** Metodo statico per CustomerDAO */
	public abstract void implementDAO();

	/**
	 * Metodo Factory
	 * 
	 * @param database, il database da scegliere
	 * @return la factory corrispondente
	 */
	public static DAOFactory getDAOFactory(DAOFactoryEnum databaseType) {
		switch (databaseType) {
		case MySQL:
			return new MySQLDAOFactory();
		case ORACLE:
			/*Implementare se necessario*/
		case SQLServer:
			/*Implementare se necessario*/
		default:
			return null;
		}
	}

}
