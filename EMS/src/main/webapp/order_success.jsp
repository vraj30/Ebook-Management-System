<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Success</title>
<%@include file="components/css.jsp"%>
</head>
<body style="background-color: #f0f1f2">
	<%@include file="components/Navbar.jsp"%>
	<div class="container text-center mt-3">
	<i class="fas fa-check-circle fa-5x text-success"></i>
	<h1>Thank You</h1>
	<h2>Order Placed Successfully.</h2>
	<h5>Within 7 Days Your Product will be Delivered.</h5>
	<a href="index.jsp" class="btn btn-primary mt-3">Home</a>
	<a href="order.jsp" class="btn btn-danger mt-3">View Order</a>	
	</div>

</body>
</html>