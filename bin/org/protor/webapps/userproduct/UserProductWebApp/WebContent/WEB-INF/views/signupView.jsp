<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>

	<h3>Registrazione</h3>
	<p style="color: red;">${errorString}</p>


	<form method="POST" action="${pageContext.request.contextPath}/signup">
		<table border="0">
			<tr>
				<td>Username</td>
				<td><input type="text" name="userName"/>
				</td>
			</tr>
			<tr>
				<td>Sesso</td>
				<td><select name="gender" size="1"> 
				<option value="M">M</option> 
				<option value="F">F</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /> 
				<a href="${pageContext.request.contextPath}/">Cancel</a></td>
			</tr>
		</table>
	</form>
	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>