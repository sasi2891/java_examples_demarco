package org.trifari.ebookshop.servlets;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet(urlPatterns = { "/marketQuery" })
public class MarketQueryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public MarketQueryServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		String[] authors = (String[]) req.getParameterValues("author");
		
		MySQLDAOFactory dao = (MySQLDAOFactory) DAOFactory.getDAOFactory(DatabaseEnum.MySQL);
        List<Book> list = new ArrayList<>();
        
        if(authors != null && authors.length > 0) {
        	for (int i = 0; i < authors.length; i++) {
        		list.addAll(dao.getDAO().getAllBooksByAuthor(authors[i]));
        	}
        }
        
        // Store info in request attribute, before forward to views
        req.setAttribute("productList", list);
        req.setAttribute("quantity", list.size());
        req.setAttribute("order", false);
        
        // Check for errors 
        if(list.isEmpty()) {
        	RequestDispatcher dispatcher = req.getServletContext()
        			.getRequestDispatcher("/WEB-INF/views/ErrorPage.jsp");
        	dispatcher.forward(req, resp);
        	return;
        }
         
        // Forward to jsp
        RequestDispatcher dispatcher = req.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/MarketQueryPage.jsp");
        dispatcher.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
