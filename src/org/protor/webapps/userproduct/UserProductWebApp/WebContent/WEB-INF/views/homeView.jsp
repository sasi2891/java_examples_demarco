<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
     <title>Home Page</title>
  </head>
  <body>
 
     <jsp:include page="_header.jsp"></jsp:include>
     <jsp:include page="_menu.jsp"></jsp:include>
    
      <h3>Home Page</h3>
      
      Questa è una semplice web application che fa uso di jsp, servlet &amp; JDBC con il DAO pattern. <br><br>
      <b>Include le seguenti funzioni:</b>
      <ul>
         <li>Registrazione</li>
         <li>Login</li>
         <li>Logout</li>
         <li>Archiviazione dati in cookies</li>
         <li>List Prodotti dell'account attivo</li>
         <li>Creazione prodotto nella lista</li>
         <li>Modifica prodotto nella lista</li>
         <li>Cancellazione prodotto nella lista</li>
      </ul>
 
     <jsp:include page="_footer.jsp"></jsp:include>
 
  </body>
</html>