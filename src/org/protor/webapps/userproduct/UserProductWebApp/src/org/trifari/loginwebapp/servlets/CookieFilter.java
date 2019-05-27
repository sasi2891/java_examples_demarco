package org.trifari.loginwebapp.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.trifari.loginwebapp.beans.UserAccount;
import org.trifari.loginwebapp.dao.MySQLDAOFactory;
import org.trifari.loginwebapp.utils.MyUtils;

/**
 * @author Vittorio Trifari
 *
 * Nel caso in cui in utente abbia già effettuato il login e salvato le sue info nel DB in precedenza, 
 * al suo ritorno, questo 'CookieFilter' controllerà le info nei cookie e farà il Login automatico.
 *
 */
@WebFilter(filterName = "cookieFilter", urlPatterns = { "/*" })
public class CookieFilter implements Filter {

	public CookieFilter() {
    }
 
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
 
    }
 
    @Override
    public void destroy() {
 
    }
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
 
        UserAccount userInSession = MyUtils.getLoginedUser(session);
        // 
        if (userInSession != null) {
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
            chain.doFilter(request, response);
            return;
        }
 
        // Connection was created in JDBCFilter.
        Connection conn = MyUtils.getStoredConnection(request);
        MySQLDAOFactory dao = (MySQLDAOFactory) MyUtils.getDAOFactory(request);
        dao.implementDAO();
        
        // Flag check cookie
        String checked = (String) session.getAttribute("COOKIE_CHECKED");
        if (checked == null && conn != null) {
            String userName = MyUtils.getUserNameInCookie(req);
            UserAccount user = dao.getDAOImplementation().getUserAccount(userName);
			MyUtils.storeLoginedUser(session, user);
            // Mark checked Cookies.
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
        }
 
        chain.doFilter(request, response);
    }
	
}
