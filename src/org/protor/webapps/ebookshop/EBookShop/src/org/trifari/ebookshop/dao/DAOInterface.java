package org.trifari.ebookshop.dao;

import java.util.List;

import org.trifari.ebookshop.beans.Book;
import org.trifari.ebookshop.beans.Order;

public interface DAOInterface {

	/*
	 * L'interfaccia DAO per le diverse implementazioni del DAO. Definisce le operazioni CRUD.
	 * E' possibile avere diverse implementazioni di questa interfaccia per diversi RDBMS (MySQL, Oracle, ecc...) 
	 * ma le operazioni restano sempre le stesse a fissato database.
	 * 
	 * Nel nostro caso il database è 'ebookshop' per la gestione di 'books' e 'orders' (vedi Java Beans associati)
	 * pertanto dovremmo implementare le operazioni CRUD per ogni 'table' del database.
	 */

	//---------------------------------------------------------------------
	// BOOKS
	//---------------------------------------------------------------------
	
	/** Recupera tutti gli oggetti 'Books' dal DB in base all'autore per quantità e prezzo crescnenti. */
	public List<Book> getAllBooksByAuthor(String author);
	
	/** Recupera tutti gli oggetti 'Books' dal DB. */
	public List<Book> getAllBooks();
	
	/** Recupera un oggetto 'Books' esistente a partire dall'ID. */
	public Book getBook(int id);
	
	/** Crea un oggetto 'Book'. Restutisce 'true' se l'operazione è andata a buon fine. */
	public boolean createBook(Book book);
	
	/** Aggiorna un oggetto 'Book' esistente. Restutisce 'true' se l'operazione è andata a buon fine.*/
	public boolean updateBook(Book book);
	
	/** Cancella un oggetto 'Book' esistente in base all'ID. */
	public boolean deleteBook(int id);
	
	//---------------------------------------------------------------------
	// ORDERS
	//---------------------------------------------------------------------
	
	/** Recupera tutti gli oggetti 'Order' dal DB. */
	public List<Order> getAllOrders();
	
	/** Recupera un oggetto 'Order' esistente a partire dall'ID. */
	public Order getOrder(int id);
	
	/** Crea un oggetto 'Order' e restituisce il codice. Ritorna 'true' se l'operazione è andata a buon fine.*/
	public boolean createOrder(Order order);
	
	/** Aggiorna un oggetto 'Order' esistente. Restutisce 'true' se l'operazione è andata a buon fine.*/
	public boolean updateOrder(Order order);
	
	/** Cancella un oggetto 'Order' esistente a partire dall'ID. */
	public boolean deleteOrder(int id);
	
	
}
