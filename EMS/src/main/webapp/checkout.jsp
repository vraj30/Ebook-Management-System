<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.CartDAOImpl"%>
<%@page import="com.entity.*"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
		<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart Page</title>
<%@include file="components/css.jsp"%>
</head>
<body style="background-color: #f0f1f2;">

	<%@include file="components/Navbar.jsp"%>
<c:if test="${empty userobj }">
	<c:redirect url = "login.jsp"></c:redirect>
</c:if>

<c:if test = "${not empty succMsg}">
	<div class ="alert alert-success" role="alert">${succMsg}</div>
	<c:remove var = "succMsg" scope ="session"/>
</c:if>

<c:if test = "${not empty failMsg}">
	<div class ="alert alert-danger" role="alert">${failMsg} </div>
	<c:remove var = "failMsg" scope ="session"/>
</c:if>

	<div class="container">
		<div class="row pd-2">
			<div class="col-md-6">

				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-success">Your Selected Item</h3>
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col">#</th>
									<th scope="col">First</th>
									<th scope="col">Last</th>
									<th scope="col">Handle</th>
								</tr>
							</thead>
							<tbody>
								<%
									User u = (User)session.getAttribute("userobj");
									
									CartDAOImpl dao = new CartDAOImpl(DBConnect.getconn());
									List<Cart> cart = dao.getBookByUser(u.getUser_id());
									Double totalPrice = 0.00;
									for(Cart c:cart)
									{
										totalPrice = c.getTotalP();	
									%>
										<tr>
											<th scope ="row"><%=c.getBookname() %> </th>
											<td><%=c.getAuthor() %></td>
											<td><%=c.getPrice()%></td>
											<td>
												<a href ="remove_book?book_id=<%=c.getBid() %>&&user_id=<%=c.getUid()%>&&cart_id=<%=c.getCid()%>" class ="btn btn-sm btn-danger">Remove</a>
											</td>
										</tr>
									<%}
								%>
								<tr>
											<td>Total Price</td>
											<td></td>
											<td></td>
											<td><%=totalPrice%></td>
											
										</tr>
								
							</tbody>
						</table>
					</div>
				</div>
			</div>


			<div class="col-md-6">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-success">Your Details for Order</h3>
						<form action="order" method="post">
						<input type="hidden" value="${userobj.user_id}" name="id">
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Name</label> <input type="text"
										class="form-control" id="inputEmail4" value = "<%=u.getUser_name() %>" name="uname" required>
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Email</label> <input
										type="email" class="form-control" id="inputPassword4" value ="<%=u.getUser_email()%>" name="mail" required>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Phone Number</label> <input type="number"
										class="form-control" id="inputEmail4" value ="<%=u.getPhno()%>" name="phno" required>
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Address</label> <input
										type="text" class="form-control" id="inputEmail4"
										name="add" required>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Landmark</label> <input type="text"
										class="form-control" id="inputEmail4" name="landm" required>
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">City</label> <input
										type="text" class="form-control" id="inputPassword4"
										name="city" required>
								</div>
							</div>
							
								<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">State</label> <input type="text"
										class="form-control" id="inputEmail4" name="state" required>
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Pin Code</label> <input
										type="text" class="form-control" id="inputPassword4"
										name="pinc" required>
								</div>
							</div>
							
							<div class="form-group">
							<lable>Payment Mode</lable>
							<select class="form-control" name="payt">
							<option value="noselect">--Select--</option>
							<option value="cod">Cash on Delivery</option>
							</select>
							</div>
							
							<div class="text-center">
							<button class="btn btn-warning">Order Now</button>
							<a href="index.jsp" class="btn btn-success">Continue Shopping</a>
							</div>
							
						</form>

					</div>
				</div>

			</div>


		</div>
	</div>

</body>
</html>