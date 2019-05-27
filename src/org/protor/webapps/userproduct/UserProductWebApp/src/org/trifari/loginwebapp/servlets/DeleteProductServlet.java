package org.trifari.loginwebapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trifari.loginwebapp.dao.MySQLDAOFactory;
import org.trifari.loginwebapp.utils.MyUtils;

@WebServlet(urlPatterns = { "/deleteProduct" })
public class DeleteProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public DeleteProductServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        MySQLDAOFactory dao = (MySQLDAOFactory) MyUtils.getDAOFactory(request);
        dao.implementDAO();
 
        String code = (String) request.getParameter("code");
 
        dao.getDAOImplementation().deleteProduct(code); 
         
        // If everything nice.
        // Redirect to the product listing page.        
        response.sendRedirect(request.getContextPath() + "/productList");

    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}
