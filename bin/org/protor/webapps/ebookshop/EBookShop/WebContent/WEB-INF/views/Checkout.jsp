<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Grazie per l'ordine</title>
</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>

	<h2>Grazie per il tuo ordine. Hai ordinato ${quantity} libri</h2>
	<p>Di seguito il riepilogo dell'ordine:</p>
	<ul>
		<li>Nome Utente: ${cust_name}</li>
		<li>Email: ${cust_email}</li>
		<li>Telefono: ${cust_phone}</li>
		<li>ID ordine: ${order_id}</li>
	</ul>
	<br />
	<table border='1'>
		<tr>
			<th>AUTORE</th>
			<th>TITOLO</th>
			<th>PREZZO</th>
			<th>QUANTITA'</th>
		</tr>
		<c:forEach items="${productList}" var="product">
			<tr>
				<td>${product.author}</td>
				<td>${product.title}</td>
				<td>${product.price}</td>
				<td>${product.quantity}</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	
	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>