package org.trifari.loginwebapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trifari.loginwebapp.beans.UserAccount;
import org.trifari.loginwebapp.utils.MyUtils;

@WebServlet(urlPatterns = { "/logout" })
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public LogoutServlet() {
        super();
    }
 
    // Show Login page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    	HttpSession session = request.getSession();
    	 
        // Check User has logged on
        UserAccount loginedUser = MyUtils.getLoginedUser(session);
 
        // Not logged in
        if (loginedUser == null) {
        	// Redirect to home page.
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }
        	
        session.removeAttribute("loginedUser");
        response.sendRedirect(request.getContextPath() + "/");
 
    }
 
    // When the user enters userName & password, and click Submit.
    // This method will be executed.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	doGet(request, response);
    	
    }

}
