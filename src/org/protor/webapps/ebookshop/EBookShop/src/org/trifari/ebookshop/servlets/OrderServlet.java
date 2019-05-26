package org.trifari.ebookshop.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trifari.ebookshop.beans.Book;
import org.trifari.ebookshop.beans.Order;
import org.trifari.ebookshop.dao.DAOFactory;
import org.trifari.ebookshop.dao.mysql.MySQLDAOFactory;
import org.trifari.ebookshop.enumerations.DatabaseEnum;

@WebServlet (urlPatterns = { "/order" })
public class OrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public OrderServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String[] productIDs = req.getParameterValues("id");
		String customerName = req.getParameter("cust_name");
		String customerEmail = req.getParameter("cust_email");
		String customerPhone = req.getParameter("cust_phone");
		
		MySQLDAOFactory dao = (MySQLDAOFactory) DAOFactory.getDAOFactory(DatabaseEnum.MySQL);
        List<Book> list = new ArrayList<>();
        
        if(productIDs != null && productIDs.length > 0) {
        	for (int i = 0; i < productIDs.length; i++) {
        		Book book = dao.getDAO().getBook(Integer.valueOf(productIDs[i]));
        		list.add(book);
        	}
        }
        
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
        
        // create order inside the database
        Random randomGenerator = new Random();
        Order order = new Order();
        order.setId(randomGenerator.nextInt(1000000));
        order.setCustomerName(customerName);
        order.setCustomerEmail(customerEmail);
        order.setCustomerPhone(customerPhone);
        order.setQuantityOrdered(list.size());
        
        // Store info in request attribute, before forward to views
        req.setAttribute("cust_name", customerName);
        req.setAttribute("cust_email", customerEmail);
        req.setAttribute("cust_phone", customerPhone);
        req.setAttribute("order_id", order.getId());
        req.setAttribute("order", true);
        
        // Check for errors 
        if(customerName.isEmpty() || customerEmail.isEmpty() || customerPhone.isEmpty()) {
        	RequestDispatcher dispatcher = req.getServletContext()
        			.getRequestDispatcher("/WEB-INF/views/ErrorPage.jsp");
        	dispatcher.forward(req, resp);
        	return;
        }
        
        dao.getDAO().createOrder(order);
        
        // update books quantities
        for (int i = 0; i < list.size(); i++) {
        	int quantity = list.get(i).getQuantity();
			list.get(i).setQuantity(quantity-1);
			dao.getDAO().updateBook(list.get(i));
		}
        
        // Forward to jsp
        RequestDispatcher dispatcher = req.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/Checkout.jsp");
        dispatcher.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
	
}
