<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>User: Home</h1>
	<c:if test = "${not empty userobj }">
		<h1>Name	: ${userobj.user_name }</h1>
		<h1>Email	: ${userobj.user_email }</h1>
	</c:if>
</body>
</html>