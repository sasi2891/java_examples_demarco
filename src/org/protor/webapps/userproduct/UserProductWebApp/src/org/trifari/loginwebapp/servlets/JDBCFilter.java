package org.trifari.loginwebapp.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.Collection;
import java.util.Map;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.trifari.loginwebapp.dao.DAOFactory;
import org.trifari.loginwebapp.dao.MySQLDAOFactory;
import org.trifari.loginwebapp.enumerations.DAOFactoryEnum;
import org.trifari.loginwebapp.utils.ConnectionUtils;
import org.trifari.loginwebapp.utils.MyUtils;

/**
 * JDBCFilter controlla la 'request' per assicurare che vengano aperte 'JDBC Connections' solo per le 
 * richieste che effettivamente ne necessitano come le servlet, o le JPS. 
 * (per esempio non si aprirà il JDBC per le richieste di immagini, css, javaScript, ecc...) 
 * 
 * @author Vittorio Trifari
 *
 */

@WebFilter(filterName = "jdbcFilter", urlPatterns = { "/*" })
public class JDBCFilter implements Filter {
 
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
 
    }
 
    @Override
    public void destroy() {
 
    }
 
    // Check the target of the request is a servlet?
    private boolean needJDBC(HttpServletRequest request) {
        System.out.println("JDBC Filter");
        // 
        // Servlet Url-pattern: /servletPath/*
        // 
        // => /servletPath
        String servletPath = request.getServletPath();
        // => pathInfo
        String pathInfo = request.getPathInfo();
 
        String urlPattern = servletPath;
 
        if (pathInfo != null) {
            // => /servletPath/*
            urlPattern = servletPath + "/*";
        }
 
        // Key: servletName.
        // Value: ServletRegistration
        Map<String, ? extends ServletRegistration> servletRegistrations = request.getServletContext()
                .getServletRegistrations();
 
        // Collection of all servlet in your Webapp.
        Collection<? extends ServletRegistration> values = servletRegistrations.values();
        for (ServletRegistration sr : values) {
            Collection<String> mappings = sr.getMappings();
            if (mappings.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
 
        HttpServletRequest req = (HttpServletRequest) request;
 
        // Only open connections for the special requests.
        // (For example, the path to the servlet, JSP, ..)
        // 
        // Avoid open connection for commons request.
        // (For example: image, css, javascript,... )
        // 
        if (this.needJDBC(req)) {
 
            System.out.println("Open Connection for: " + req.getServletPath());
 
            Connection conn = null;
            DAOFactory dao = null;
            try {
            	
                // Create a Connection. DEFAULT = MYSQL (MODIFY IF NEEDED)
            	dao = DAOFactory.getDAOFactory(DAOFactoryEnum.MySQL);
                conn = ((MySQLDAOFactory) dao).getConnection();
                // Set outo commit to false.
                conn.setAutoCommit(false);
 
                // Store Connection and DAO objects in attribute of request.
                MyUtils.storeConnection(request, conn);
                MyUtils.storeDAOFactory(request, dao);
 
                // Allow request to go forward
                // (Go to the next filter or target)
                chain.doFilter(request, response);
 
                // Invoke the commit() method to complete the transaction with the DB.
                conn.commit();
            } catch (Exception e) {
                e.printStackTrace();
                ConnectionUtils.rollbackQuietly(conn);
                throw new ServletException();
            } finally {
                ConnectionUtils.closeQuietly(conn);
            }
        }
        // With commons requests (images, css, html, ..)
        // No need to open the connection.
        else {
            // Allow request to go forward
            // (Go to the next filter or target)
            chain.doFilter(request, response);
        }
 
    }
 
}
