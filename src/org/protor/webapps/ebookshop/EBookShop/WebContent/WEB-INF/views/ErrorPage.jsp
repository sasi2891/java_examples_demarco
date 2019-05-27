<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ops!</title>
</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>


	<h2>Qualcosa è andato storto!</h2>
	
	<c:if test="${cust_name.isEmpty() && order == true}">   
	<p>Nome Utente non inserito!</p>
	</c:if>
	
	<c:if test="${cust_email.isEmpty() && order == true}">   
	<p>Email Utente non inserita!</p>
	</c:if>
	
	<c:if test="${cust_phone.isEmpty() && order == true}">   
	<p>Telefono Utente non inserito!</p>
	</c:if>
	
	<c:if test="${quantity == 0}">   
	<p>Nessun prodotto selezionato!</p>
	</c:if>

	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>