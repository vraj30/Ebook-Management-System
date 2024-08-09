<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Profile</title>
<%@include file="components/css.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty userobj}">
		<c:redirect url="login.jsp" />
	</c:if>

	<%@include file="components/Navbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-primary">Edit Profile</h4>
						<form action="edit" method="post">

							<c:if test="${not empty succMsg}">
								<p class="text-center text-success">${succMsg}</p>
								<c:remove var="succMsg" scope="session" />
							</c:if>

							<c:if test="${not empty failMsg}">
								<p class="text-center text-danger">${failMsg}</p>
								<c:remove var="failMsg" scope="session" />
							</c:if>


							<input type="hidden" value="${userobj.user_id}" name="id">

							<div class="form-group">
								<label for="exampleInputEmail1">Enter Full Name</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="fname"
									value="${userobj.user_name}">
							</div>


							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="email"
									value="${userobj.user_email}">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Phone No</label> <input
									type="number" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="phno"
									value="${userobj.phno}">
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									required="required" name="password">
							</div>

							<button type="submit" class="btn btn-primary btn-block btn-sm">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>