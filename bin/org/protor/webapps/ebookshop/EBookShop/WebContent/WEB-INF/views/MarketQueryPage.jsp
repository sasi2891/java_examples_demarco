<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Scelta Libri</title>
</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>

	<h2>Grazie per la tua richiesta.</h2>
	<p>Seleziona i libri che intendi acquistare.</p>
	<form method='get' action='order'>
		<table border='1'>
			<tr>
				<th>&nbsp;</th>
				<th>AUTORE</th>
				<th>TITOLO</th>
				<th>PREZZO</th>
				<th>QUANTITA'</th>
			</tr>

			<c:forEach items="${productList}" var="product">
				<tr>
					<td><input type='checkbox' name='id' value='${product.id}'/></td>
					<td>${product.author}</td>
					<td>${product.title}</td>
					<td>${product.price}</td>
					<td>${product.quantity}</td>
				</tr>
			</c:forEach>

		</table>
		<br />

		<table>
			<tr>
				<td>Insersci il tuo nome:</td>
				<td><input type='text' name='cust_name' /></td>
			</tr>
			<tr>
				<td>Inserisci il tup indirizzo email (es.: user@host.com):</td>
				<td><input type='text' name='cust_email' /></td>
			</tr>
			<tr>
				<td>Inserci il tuo numero di telefono cellulare (10-cifre):</td>
				<td><input type='text' name='cust_phone' /></td>
			</tr>
		</table>
		<br /> <input type='submit' value='ORDINA!' /> 
		<input type='reset' value='SVUOTA CAMPI'/>
	</form>

	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>