<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>

	<h3>Lista prodotti</h3>

	<p style="color: red;">${errorString}</p>

	<table border="1" cellpadding="5" cellspacing="1">
		<tr>
			<th>Codice</th>
			<th>Nome</th>
			<th>Prezzo</th>
			<th>Modifica</th>
			<th>Elimina</th>
		</tr>
		<c:forEach items="${productList}" var="product">
			<tr>
				<td>${product.code}</td>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td><a href="editProduct?code=${product.code}">Modifica</a></td>
				<td><a href="deleteProduct?code=${product.code}">Elimina</a></td>
			</tr>
		</c:forEach>
	</table>

	<a href="createProduct">Crea Prodotto</a>

	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>