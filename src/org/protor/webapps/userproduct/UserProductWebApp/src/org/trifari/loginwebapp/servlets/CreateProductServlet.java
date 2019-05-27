package org.trifari.loginwebapp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trifari.loginwebapp.beans.Product;
import org.trifari.loginwebapp.dao.MySQLDAOFactory;
import org.trifari.loginwebapp.utils.MyUtils;

@WebServlet(urlPatterns = { "/createProduct" })
public class CreateProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public CreateProductServlet() {
        super();
    }
 
    // Show product creation page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
        dispatcher.forward(request, response);
    }
 
    // When the user enters the product information, and click Submit.
    // This method will be called.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        MySQLDAOFactory dao = (MySQLDAOFactory) MyUtils.getDAOFactory(request);
        dao.implementDAO();
 
        String code = (String) request.getParameter("code");
        String name = (String) request.getParameter("name");
        String priceStr = (String) request.getParameter("price");
        
        double price = 0.0;
        try {
        	price = Double.parseDouble(priceStr);
        } catch (Exception e) {
        }

        Product product = new Product();
        product.setCode(code);
        product.setName(name);
        product.setPrice(price);
 
        String errorString = null;
 
        // Product ID is the string literal [a-zA-Z_0-9]
        // with at least 1 character
        String regex = "\\w+";
 
        if (code == null || !code.matches(regex)) {
            errorString = "Product Code invalid!";
        }
 
        if (errorString == null) {
        	
        	boolean productExists = true;
        	if(dao.getDAOImplementation().getProduct(code) == null) {
        		
        		productExists = false;

        		// Add user to the DB.
        		dao.getDAOImplementation().createProduct(product);

        	}
        	if (productExists == true ) {
        		errorString = "This product already exists";
        	}
        }
 
        // Store infomation to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("product", product);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the product listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/productList");
        }
    }
}
