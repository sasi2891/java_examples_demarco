package org.trifari.ebookshop.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.trifari.ebookshop.beans.Book;
import org.trifari.ebookshop.beans.Order;
import org.trifari.ebookshop.dao.DAOInterface;

public class MySQLDAOFactoryImplementation implements DAOInterface {

	//----------------------------------------------------------------------------
	// BOOK
	//----------------------------------------------------------------------------
	/** La query per l'inserimento di un nuovo 'Book' */
    private static final String CREATE_QUERY_BOOK = "INSERT INTO books (id, title, author, price, qty) VALUES (?,?,?,?,?)";
    /** La query per la lettura di un singolo 'Book'. */
    private static final String READ_QUERY_BOOK = "SELECT * FROM books WHERE id = ?";
    /** La query per la lettura di tutti i 'Book'. */
    private static final String READ_ALL_QUERY_BOOK = "SELECT * FROM books";
    /** La query per la lettura di tutti i 'Book' per autore in ordine di nome e prezzo crescenti. */
    private static final String READ_ALL_QUERY_BOOK_BY_AUTHOR = "SELECT * FROM books WHERE author = ? ORDER BY title ASC, price ASC";
    /** La query per l'aggiornamento di un singolo 'Book'. */
    private static final String UPDATE_QUERY_BOOK = "UPDATE books SET title=?, author=?, price=?, qty=? WHERE id=?";
    /** La query per la cancellazione di un singolo 'Book'. */
    private static final String DELETE_QUERY_BOOK = "DELETE FROM books WHERE id = ?";
	
    @Override
	public List<Book> getAllBooksByAuthor(String author) {
    	
    	List<Book> bookList = new ArrayList<>();
		Book book = null;
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MySQLDAOFactory.createConnection();            
            preparedStatement = conn.prepareStatement(READ_ALL_QUERY_BOOK_BY_AUTHOR);
            preparedStatement.setString(1, author);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
 
            while (result.next()) {            	
            	book = new Book();
            	book.setId(result.getInt(1));
            	book.setTitle(result.getString(2));
            	book.setAuthor(result.getString(3));
            	book.setPrice(result.getDouble(4));
            	book.setQuantity(result.getInt(5));
            	bookList.add(book);
            }     
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                rse.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        
        return bookList;
	}
    
	@Override
	public List<Book> getAllBooks() {
		List<Book> bookList = new ArrayList<>();
		Book book = null;
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MySQLDAOFactory.createConnection();            
            preparedStatement = conn.prepareStatement(READ_ALL_QUERY_BOOK);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
 
            while (result.next()) {            	
            	book = new Book();
            	book.setId(result.getInt(1));
            	book.setTitle(result.getString(2));
            	book.setAuthor(result.getString(3));
            	book.setPrice(result.getDouble(4));
            	book.setQuantity(result.getInt(5));
            	bookList.add(book);
            }     
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                rse.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        
        return bookList;
	}
	
	@Override
	public Book getBook(int id) {
		Book book = null;
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MySQLDAOFactory.createConnection();            
            preparedStatement = conn.prepareStatement(READ_QUERY_BOOK);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
 
            while (result.next()) {            	
            	book = new Book();
            	book.setId(result.getInt(1));
            	book.setTitle(result.getString(2));
            	book.setAuthor(result.getString(3));
            	book.setPrice(result.getDouble(4));
            	book.setQuantity(result.getInt(5));
            }     
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                rse.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        
        return book;
	}
	
	@Override
	public boolean createBook(Book book) {
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        boolean output = false;
        try {
            conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(CREATE_QUERY_BOOK);
            preparedStatement.setInt(1, book.getId());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setDouble(4, book.getPrice());
            preparedStatement.setInt(5, book.getQuantity());
            preparedStatement.execute();
            output = true;
                
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
 
        return output;
	}
	
	@Override
	public boolean updateBook(Book book) {

		boolean output = false;
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
        	conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(UPDATE_QUERY_BOOK);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setDouble(3, book.getPrice());
            preparedStatement.setInt(4, book.getQuantity());
            preparedStatement.setInt(5, book.getId());
            
            preparedStatement.execute();
            output = true;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        return output;
		
	}
	
	@Override
	public boolean deleteBook(int id) {
		
		boolean output = false;
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(DELETE_QUERY_BOOK);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            output = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        return output;
		
	}
	
	//----------------------------------------------------------------------------
	// ORDER
	//----------------------------------------------------------------------------
	/** La query per l'inserimento di un nuovo 'Order' */
	private static final String CREATE_QUERY_ORDER = "INSERT INTO order_records (id, qty_ordered, cust_name, cust_email, cust_phone) VALUES (?,?,?,?,?)";
	/** La query per la lettura di un singolo 'Order'. */
	private static final String READ_QUERY_ORDER = "SELECT * FROM order_records WHERE id = ?";
	/** La query per la lettura di tutti i 'Order'. */
	private static final String READ_ALL_QUERY_ORDER = "SELECT * FROM order_records";
	/** La query per l'aggiornamento di un singolo 'Order'. */
	private static final String UPDATE_QUERY_ORDER = "UPDATE order_records SET qty_ordered=?, cust_name=?, cust_email=?, cust_phone=? WHERE id=?";
	/** La query per la cancellazione di un singolo 'Order'. */
	private static final String DELETE_QUERY_ORDER = "DELETE FROM order_records WHERE id = ?";

	@Override
	public List<Order> getAllOrders() {
		
		List<Order> orderList = new ArrayList<>();
		Order order = null;
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MySQLDAOFactory.createConnection();            
            preparedStatement = conn.prepareStatement(READ_ALL_QUERY_ORDER);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
 
            while (result.next()) {            	
            	order = new Order();
            	order.setId(result.getInt(1));
            	order.setQuantityOrdered(result.getInt(2));
            	order.setCustomerName(result.getString(3));
            	order.setCustomerEmail(result.getString(4));
            	order.setCustomerPhone(result.getString(5));
            	orderList.add(order);
            }     
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                rse.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        
        return orderList;
        
	}
	@Override
	public Order getOrder(int id) {
		
		Order order = null;
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MySQLDAOFactory.createConnection();            
            preparedStatement = conn.prepareStatement(READ_QUERY_ORDER);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
 
            while (result.next()) {            	
            	order = new Order();
            	order.setId(result.getInt(1));
            	order.setQuantityOrdered(result.getInt(2));
            	order.setCustomerName(result.getString(3));
            	order.setCustomerEmail(result.getString(4));
            	order.setCustomerPhone(result.getString(5));
            }     
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                rse.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        
        return order;
		
	}
	@Override
	public boolean createOrder(Order order) {
		
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        boolean output = false;
        try {
            conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(CREATE_QUERY_ORDER);
            preparedStatement.setInt(1, order.getId());
            preparedStatement.setInt(2, order.getQuantityOrdered());
            preparedStatement.setString(3, order.getCustomerName());
            preparedStatement.setString(4, order.getCustomerEmail());
            preparedStatement.setString(5, order.getCustomerPhone());
            preparedStatement.execute();
            output = true;
                
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
 
        return output;
		
	}
	@Override
	public boolean updateOrder(Order order) {
		
		boolean output = false;
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
        	conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(UPDATE_QUERY_ORDER);
            preparedStatement.setInt(1, order.getQuantityOrdered());
            preparedStatement.setString(2, order.getCustomerName());
            preparedStatement.setString(3, order.getCustomerEmail());
            preparedStatement.setString(4, order.getCustomerPhone());
            preparedStatement.setInt(5, order.getId());
            
            preparedStatement.execute();
            output = true;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        return output;
		
	}
	@Override
	public boolean deleteOrder(int id) {

		boolean output = false;
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(DELETE_QUERY_ORDER);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            output = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        return output;
		
	}

}
