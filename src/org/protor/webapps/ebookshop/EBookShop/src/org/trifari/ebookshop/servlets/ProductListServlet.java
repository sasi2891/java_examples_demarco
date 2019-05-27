package org.trifari.ebookshop.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trifari.ebookshop.beans.Book;
import org.trifari.ebookshop.dao.DAOFactory;
import org.trifari.ebookshop.dao.mysql.MySQLDAOFactory;
import org.trifari.ebookshop.enumerations.DatabaseEnum;

@WebServlet(urlPatterns = { "/productList" })
public class ProductListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public ProductListServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    	MySQLDAOFactory dao = (MySQLDAOFactory) DAOFactory.getDAOFactory(DatabaseEnum.MySQL);
        List<Book> list = dao.getDAO().getAllBooks();
        
        // Store info in request attribute, before forward to views
        request.setAttribute("productList", list);
         
        // Forward to jsp
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/ProductListPage.jsp");
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}