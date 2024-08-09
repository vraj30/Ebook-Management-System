<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EBook Login</title>
<%@include file="components/css.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="components/Navbar.jsp"%>
	<div class="container">
		<div class="row mt-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center">Login</h4>
						
						<c:if test = "${not empty failedmsg}">
							<h5 class="tex-center text-danger">${failedmsg}</h5>
							<c:remove var ="failedmsg" scope ="session"/>
						</c:if>
						
						<c:if test = "${not empty succMsg}">
							<h5 class="tex-center text-success">${succMsg}</h5>
							<c:remove var ="failedmsg" scope ="session"/>
						</c:if>
						
						
						<form action = "login" method = "post">

							<div class="form-group">
								<label for="exampleInputEmail1">Email Address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="email">
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1" required="required" name = "password">
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-primary">Login</button>
								<br> <a href="register.jsp">Create Account</a>
							</div>
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>
	<div style="margin-top: 120px;">
	<%@include file="components/footer.jsp"%>
	</div>
	
</body>
</html>