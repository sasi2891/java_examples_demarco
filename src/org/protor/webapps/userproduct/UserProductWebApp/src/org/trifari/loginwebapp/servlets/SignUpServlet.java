package org.trifari.loginwebapp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trifari.loginwebapp.beans.UserAccount;
import org.trifari.loginwebapp.dao.MySQLDAOFactory;
import org.trifari.loginwebapp.enumerations.GenderEnum;
import org.trifari.loginwebapp.utils.MyUtils;

@WebServlet(urlPatterns = { "/signup" })
public class SignUpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public SignUpServlet() {
        super();
    }
 
    // Show Login page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Forward to /WEB-INF/views/loginView.jsp
        // (Users can not access directly into JSP pages placed in WEB-INF)
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
 
        dispatcher.forward(request, response);
 
    }
 
    // When the user enters userName & password, and click Submit.
    // This method will be executed.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        String username = request.getParameter("userName");
        GenderEnum userGender = GenderEnum.valueOf(request.getParameter("gender"));
        String password = request.getParameter("password");
   
        UserAccount user = null;
        boolean hasError = false;
        String errorString = null;
 
        if (username == null || userGender == null || password == null 
        		|| username.length() == 0 || userGender.toString().length() == 0 || password.length() == 0) {
            hasError = true;
            errorString = "Required username, gender and password!";
        } else {
            
        	MySQLDAOFactory dao = (MySQLDAOFactory) MyUtils.getDAOFactory(request);
        	dao.implementDAO();
        	List<String> userIDList = dao.getDAOImplementation().getAllUserIDs();
        	int maxID = userIDList.stream()
        			.map(idCode -> idCode.substring(1, idCode.length()))
        			.mapToInt(idCode -> Integer.valueOf(idCode))
        			.max()
        			.getAsInt();
        	
        	user = new UserAccount();
        	user.setID("U" + String.valueOf(maxID+1));
        	user.setUsername(username);
        	user.setGender(userGender);
        	user.setPassword(password);

        	boolean userExists = true;
        	if(dao.getDAOImplementation().getUserAccount(username) == null) {
        		
        		userExists = false;

        		// Add user to the DB.
        		dao.getDAOImplementation().createUserAccount(user);

        	}
        	if (userExists == true ) {
        		hasError = true;
        		errorString = "This user already exists";
        	}
        }
        // If error, forward to /WEB-INF/views/signup.jsp
        if (hasError) {

        	// Store information in request attribute, before forward.
            request.setAttribute("errorString", errorString);
 
            // Forward to /WEB-INF/views/login.jsp
            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
 
            dispatcher.forward(request, response);
        }
        // If no error
        // Store user information in Session
        // And redirect to userInfo page.
        else {
            HttpSession session = request.getSession();
            MyUtils.storeLoginedUser(session, user);
 
            // Redirect to userInfo page.
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
 
}
