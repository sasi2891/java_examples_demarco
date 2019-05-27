package esercitazioneDAO1.dao;

import java.util.List;

public interface DAOInterface {

	/* CRUD operations */
	public void create(String nometabella, Object obj);
	public List<Object> readAll(String nomeTabella);
	public Object read(String nomeTabella, String nomeParametro, Object obj);
	public void update(String nomeTabella, String nomeParametri, Object obj);
	public void delete(String nomeTabella, String nomeParametro, Object obj);
	
}
