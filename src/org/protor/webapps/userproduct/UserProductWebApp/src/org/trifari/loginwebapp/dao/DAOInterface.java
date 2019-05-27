package org.trifari.loginwebapp.dao;

import java.util.List;

import org.trifari.loginwebapp.beans.Product;
import org.trifari.loginwebapp.beans.UserAccount;

public interface DAOInterface {

	/*
	 * L'interfaccia DAO per le diverse implementazioni del DAO. Definisce le operazioni CRUD.
	 * E' possibile avere diverse implementazioni di questa interfaccia per diversi RDBMS (MySQL, Oracle, ecc...) 
	 * ma le operazioni restano sempre le stesse a fissato database.
	 * 
	 * Nel nostro caso il database è 'user_product' per la gestione di utenti e prodotti (vedi Java Beans associati)
	 * pertanto dovremmo implementare le operazioni CRUD per ogni 'table' del database.
	 */

	//---------------------------------------------------------------------
	// USER ACCOUNTS
	//---------------------------------------------------------------------
	
	/** Recupera tutti gli ID di 'UserAccount' dal DB. */
	public List<String> getAllUserIDs();
	
	/** Recupera tutti gli oggetti 'UserAccount' dal DB. */
	public List<UserAccount> getAllUserAccounts();
	
	/** Recupera un oggetto 'UserAccount' esistente a partire dall'ID. */
	public UserAccount getUserAccount(String name);
	
	/** Crea un oggetto 'UserAccount' e restituisce l'ID. */
	public void createUserAccount(UserAccount account);
	
	/** Aggiorna un oggetto 'UserAccount' esistente. Restutisce 'true' se l'operazione è andata a buon fine.*/
	public boolean updateUserAccount(UserAccount account);
	
	/** Cancella un oggetto 'UserAccount' esistente. */
	public boolean deleteUserAccount(String username);
	
	//---------------------------------------------------------------------
	// PRODUCTS
	//---------------------------------------------------------------------
	
	/** Recupera tutti gli oggetti 'Product' dal DB. */
	public List<Product> getAllProducts();
	
	/** Recupera un oggetto 'Product' esistente a partire dal codice. */
	public Product getProduct(String code);
	
	/** Crea un oggetto 'Product' e restituisce il codice. Ritorna '-1' se l'operazione non è andata a buon fine.*/
	public void createProduct(Product product);
	
	/** Aggiorna un oggetto 'Product' esistente. Restutisce 'true' se l'operazione è andata a buon fine.*/
	public boolean updateProduct(Product product);
	
	/** Cancella un oggetto 'Product' esistente. */
	public boolean deleteProduct(String code);
	
}
