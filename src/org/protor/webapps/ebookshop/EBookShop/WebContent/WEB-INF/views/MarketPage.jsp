<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ordine Libri</title>
</head>

<body>

	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>

	<h2>Scegli autore:</h2>
	<form method="get" action="marketQuery">
		<input type="checkbox" name="author" value="Tan Ah Teck">Tan <input
			type="checkbox" name="author" value="Mohammad Ali">Ali <input
			type="checkbox" name="author" value="Kumar">Kumar <input
			type="checkbox" name="author" value="Kevin Jones">Jones <input
			type="submit" value="Ordina">
	</form>

	<br />
	<a href="${pageContext.request.contextPath}/market">Annulla Scelta</a>

	<jsp:include page="_footer.jsp"></jsp:include>
<body>
</html>