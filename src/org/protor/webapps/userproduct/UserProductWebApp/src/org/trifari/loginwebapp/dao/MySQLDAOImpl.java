package org.trifari.loginwebapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.trifari.loginwebapp.beans.Product;
import org.trifari.loginwebapp.beans.UserAccount;
import org.trifari.loginwebapp.enumerations.GenderEnum;

public class MySQLDAOImpl extends MySQLDAOFactory implements DAOInterface {

	//----------------------------------------------------------------------------------------
	// DEFINIZIONE DELLE QUERY (Prepared Statements per evitare problemi di 'SQL Injection'
	//----------------------------------------------------------------------------------------
	// USER ACCOUNT
	/** La query per l'inserimento di un nuovo 'UserAccount' */
    private static final String CREATE_USER_ACCOUNT_QUERY = "INSERT INTO user_account (ID, USER_NAME, GENDER, PASSWORD) VALUES (?,?,?,?)";
    /** La query per la lettura di un singolo 'UserAccount'. */
    private static final String READ_USER_ACCOUNT_QUERY = "SELECT * FROM user_account WHERE USER_NAME = ?";
    /** La query per la lettura di tutti gli ID in 'UserAccount' */
    private static final String READ_ALL_USER_ID_QUERY = "SELECT ID FROM user_account";
    /** La query per la lettura di tutti gli 'UserAccount'. */
    private static final String READ_ALL_USER_ACCOUNT_QUERY = "SELECT * FROM user_account";
    /** La query per l'aggiornamento di un singolo 'UserAccount'. */
    private static final String UPDATE_USER_ACCOUNT_QUERY = "UPDATE user_account SET USER_NAME=? , GENDER=?, PASSWORD=? WHERE ID = ?";
    /** La query per la cancellazione di un singolo 'UserAccount'. */
    private static final String DELETE_USER_ACCOUNT_QUERY = "DELETE FROM user_account WHERE USER_NAME = ?";
	//----------------------------------------------------------------------------------------
	// USER ACCOUNT
    /** La query per l'inserimento di un nuovo 'Product' */
    private static final String CREATE_PRODUCT_QUERY = "INSERT INTO product (CODE, NAME, PRICE) VALUES (?,?,?)";
    /** La query per la lettura di un singolo 'Product'. */
    private static final String READ_PRODUCT_QUERY = "SELECT * FROM product WHERE CODE = ?";
    /** La query per la lettura di tutti gli 'Product'. */
    private static final String READ_ALL_PRODUCT_QUERY = "SELECT * FROM product";
    /** La query per l'aggiornamento di un singolo 'Product'. */
    private static final String UPDATE_PRODUCT_QUERY = "UPDATE product SET NAME=? , PRICE=? WHERE CODE = ?";
    /** La query per la cancellazione di un singolo 'Product'. */
    private static final String DELETE_PRODUCT_QUERY = "DELETE FROM product WHERE CODE = ?";
    
	//----------------------------------------------------------------------------------------
	// IMPLEMENTAZIONE METODI INTERFACCIA DAO
	//----------------------------------------------------------------------------------------
    
    @Override
	public List<String> getAllUserIDs() {
	
		List<String> idList = new ArrayList<>();
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = super.getConnection();            
            preparedStatement = conn.prepareStatement(READ_ALL_USER_ID_QUERY);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
 
            while (result.next()) {            	
            	idList.add(result.getString(1)); 
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
        }
        
        return idList;
	}
    
    @Override
	public List<UserAccount> getAllUserAccounts() {
		List<UserAccount> accounts = new ArrayList<>();
		UserAccount account = null;
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = super.getConnection();            
            preparedStatement = conn.prepareStatement(READ_ALL_USER_ACCOUNT_QUERY);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
 
            while (result.next()) {            	
            	account = new UserAccount();
            	account.setID(result.getString(1)); 
            	account.setUsername(result.getString(2));
            	account.setGender(GenderEnum.valueOf(result.getString(3)));
            	account.setPassword(result.getString(4));            	
            	accounts.add(account);
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
        }
        
        return accounts;
	}

	@Override
	public UserAccount getUserAccount(String name) {
		UserAccount account = null;
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
        	conn = super.getConnection();              
            preparedStatement = conn.prepareStatement(READ_USER_ACCOUNT_QUERY);
            preparedStatement.setString(1, name);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
 
            if (result.next() && result != null) {        	
            	account = new UserAccount();
            	account.setID(result.getString(1)); 
            	account.setUsername(result.getString(2));
            	account.setGender(GenderEnum.valueOf(result.getString(3)));
            	account.setPassword(result.getString(4));            	
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
        }
        
        return account;
	}

	@Override
	public void createUserAccount(UserAccount account) {
		
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
        	conn = super.getConnection();   
            preparedStatement = conn.prepareStatement(CREATE_USER_ACCOUNT_QUERY, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, account.getID());
            preparedStatement.setString(2, account.getUsername());
            preparedStatement.setString(3, account.getGender().toString());
            preparedStatement.setString(4, account.getPassword());
            preparedStatement.execute();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
        }
 
	}

	@Override
	public boolean updateUserAccount(UserAccount account) {
		
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
        	conn = super.getConnection();   
            preparedStatement = conn.prepareStatement(UPDATE_USER_ACCOUNT_QUERY);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getGender().toString());
            preparedStatement.setString(3, account.getPassword());
            preparedStatement.setString(4, account.getID());
            
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
        }
        
        // ERROR STATUS
        return false;
	}

	@Override
	public boolean deleteUserAccount(String username) {
		
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
        	conn = super.getConnection();   
            preparedStatement = conn.prepareStatement(DELETE_USER_ACCOUNT_QUERY);
            preparedStatement.setString(1, username);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
        }
        return false;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		Product product = null;
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
        	conn = super.getConnection();               
            preparedStatement = conn.prepareStatement(READ_ALL_PRODUCT_QUERY);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
 
            while (result.next()) {            	
            	product = new Product();
            	product.setCode(result.getString(1)); 
            	product.setName(result.getString(2));
            	product.setPrice(result.getDouble(3));
            	products.add(product);
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
        }
        
        return products;
	}

	@Override
	public Product getProduct(String code) {
		Product product = null;
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
        	conn = super.getConnection();               
            preparedStatement = conn.prepareStatement(READ_PRODUCT_QUERY);
            preparedStatement.setString(1, code);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
 
            if (result.next() && result != null) {        	
            	product = new Product();
            	product.setCode(result.getString(1)); 
            	product.setName(result.getString(2));
            	product.setPrice(result.getDouble(3));
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
        }
        
        return product;
	}

	@Override
	public void createProduct(Product product) {
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
        	
        	conn = super.getConnection();   
            preparedStatement = conn.prepareStatement(CREATE_PRODUCT_QUERY, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, product.getCode());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.execute();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
        }
	}

	@Override
	public boolean updateProduct(Product product) {
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
        	conn = super.getConnection();   
            preparedStatement = conn.prepareStatement(UPDATE_PRODUCT_QUERY);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getCode());
            
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
        }
        
        // ERROR STATUS
        return false;
	}

	@Override
	public boolean deleteProduct(String code) {
		
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
        	conn = super.getConnection();   
            preparedStatement = conn.prepareStatement(DELETE_PRODUCT_QUERY);
            preparedStatement.setString(1, code);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
        }
        return false;
	}

}
