<%@page import="com.entity.User"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.BookDAOImpl"%>
<%@page import="com.entity.BookDet"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="IS0-8859-1">
<title>Book Details</title>
<%@include file="components/css.jsp"%>
</head>
<body style="background-color: #f0f1f2">

	<%
	User us = (User) session.getAttribute("userobj");
	%>
	<%@include file="components/Navbar.jsp"%>

	<%
	int bid = Integer.parseInt(request.getParameter("book_id"));
	BookDAOImpl dao = new BookDAOImpl(DBConnect.getconn());
	BookDet b = dao.getBooksById(bid);
	%>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-6 text-center p-5 border bg-white">
				<img src="bookimg/<%=b.getPhoto()%>"
					style="height: 150px; width: 100px"><br>
				<h4 class="mt-3">
					Book Name: <span class="text-success"><%=b.getBookname()%></span>
				</h4>
				<h4>
					Author Name:<span class="text-success"> <%=b.getAuthor()%></span>
				</h4>
				<h4>
					Category:<span class="text-success"><%=b.getBookCat()%></span>
				</h4>
			</div>
			<div class="col-md-6 text-center p-5 border bg-white">
				<h2><%=b.getBookname()%></h2>

				<%
				if ("Old".equals(b.getBookCat())) {
				%>
				<h5 class="text-primary">Contact to Seller</h5>
				<h5 class="text-primary">
					<i class="fa-regular fa-envelope"></i> Email:
					<%=b.getUser_email()%></h5>
				<%
				}
				%>

				<div class="row">
					<div class="col-md-4 text-danger text-centern p-2">
						<i class="fas fa-money-bill-wave fa-2x"></i>
						<p>Cash on Delivery</p>
					</div>
					<div class="col-md-4 text-danger text-centern p-2">
						<i class="fas fa-undo-alt fa-2x"></i>
						<p>Return Available</p>
					</div>
					<div class="col-md-4 text-danger text-centern p-2">
						<i class="fas fa-truck-moving fa-2x"></i>
						<p>Free Shipping</p>
					</div>
				</div>

				<%
				if ("Old".equals(b.getBookCat())) {
				%>
				<div class="text-center p-3">
					<a href="index.jsp" class="btn btn-success"><i
						class="fa-solid fa-cart-plus"></i> Continue Shopping</a> <a href=""
						class="btn btn-danger"><i
						class="fa-solid fa-indian-rupee-sign"></i> 200</a>

				</div>
				<%
				} else {
				%>
				<div class="text-center p-3">
					<%
					if (us == null) {
					%>

					<a href="login.jsp" class="btn btn-success btn-sm ml-1"> <i
						class="fa-solid fa-cart-shopping"></i> Add cart
					</a>

					<%
					} else {
					%>
					<a href="cart?bid=<%=b.getBook_id()%>&&uid=<%=us.getUser_id()%>"
						class="btn btn-danger btn-sm ml-1"> <i
						class="fa-solid fa-cart-shopping"></i> Add cart
					</a>

					<%
					}
					%>
					<a href="" class="btn btn-danger"><i
						class="fa-solid fa-indian-rupee-sign"></i> 200</a>

				</div>
				<%
				}
				%>


			</div>
		</div>
	</div>
</body>
</html>