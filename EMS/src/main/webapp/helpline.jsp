<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
		<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Helpline</title>
<%@include file="components/css.jsp"%>

</head>
<body>
<c:if test="${empty userobj}">
<c:redirect url="login.jsp"/>
</c:if>
	<%@include file="components/Navbar.jsp"%>
	<div class="container">
		<div class="row p-5">
			<div class="col-md-4 offset-md-4 text-center">
				<div class="text-success">
					<i class="fas fa-phone-square-alt fa-3x"></i>
				</div>

				<h3>24*7 Services</h3>
				<h4>Help Line Number</h4>
				<h5>+0671 8675483939</h5>
				<a href="index.jsp" class="btn btn-primary">Home</a>
			</div>
		</div>
	</div>
</body>
</html>