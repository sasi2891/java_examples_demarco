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

@WebServlet(urlPatterns = { "/editProduct" })
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditProductServlet() {
		super();
	}

	// Show product edit page.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MySQLDAOFactory dao = (MySQLDAOFactory) MyUtils.getDAOFactory(request);
		dao.implementDAO();
		
		String code = (String) request.getParameter("code");
		Product product = null;

		product = dao.getDAOImplementation().getProduct(code);

		// If the product does not exist to edit.
		// Redirect to productList page.
		if (product == null) {
			response.sendRedirect(request.getServletPath() + "/productList");
			return;
		}

		// Store product in request attribute, before forward to views.
		request.setAttribute("product", product);

		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
		dispatcher.forward(request, response);

	}

	// After the user modifies the product information, and click Submit.
	// This method will be executed.
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

		dao.getDAOImplementation().updateProduct(product);
		
		// Store infomation to request attribute, before forward to views.
		request.setAttribute("product", product);

		// If everything nice.
		// Redirect to the product listing page.
		response.sendRedirect(request.getContextPath() + "/productList");
	}
}
