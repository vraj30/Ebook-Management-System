<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.user.servlet.*"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EBook Register</title>
<%@include file="components/css.jsp"%>
</head>
<body style="background-color:#f0f1f2;">
	<%@include file="components/Navbar.jsp"%>
	<div class="container p-2">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
					<h4 class="text-center">Registration</h4>
					
					<c:if test="${not empty succMsg}">
					<p class ="text-center text-success"> ${succMsg} </p>
					<c:remove var="succMsg" scope= "session" />
					</c:if>
					
					<c:if test="${not empty failMsg}">
						<p class ="text-center text-danger"> ${failMsg}</p>
						<c:remove var="failMsg" scope= "session"/>
					</c:if>
					
						<form action="register"  method="post">
						
						<div class="form-group">
								<label for="exampleInputEmail1">Enter Full Name</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="fname">		
							</div>
							
							
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="email">		
							</div>
							
							<div class="form-group">
								<label for="exampleInputEmail1">Phone No</label> <input
									type="number" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="phno">		
							</div>
							
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1" required="required" name="password">
							</div>
							<div class="form-check">
								<input type="checkbox" class="form-check-input" name = "check" id="exampleCheck1">
								<lable class="form-check-label" for="exampleCheck1"> Agree Terms & Condtions </lable>
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>
	<%@include file="components/footer.jsp" %>
</body>
</html>