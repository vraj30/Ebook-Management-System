<%@page import="com.entity.User"%>
<%@page import="com.entity.BookDet"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.BookDAOImpl"%>
<%@page import="java.sql.Connection"%>
<%@ page import="com.DB.DBConnect"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ebook index page</title>
<%@include file="components/css.jsp"%>

<style type="text/css">
.back-img {
	background: url("img/eb.jpg");
	height: 50vh;
	width: 100%;
	background-repeat: no-repeat;
	background-size: cover;
}

.crd-ho:hover {
	background-color: #fcfbe8;
}
</style>

</head>
<body style="background-color: #e4f2f2">

	<%
	User us = (User) session.getAttribute("userobj");
	%>

	<%@include file="components/Navbar.jsp"%>
	<div class="container-fluid back-img">
		<h2 class="text-center text-danger font-weight-bold">EBook
			Management System</h2>
	</div>

	<!-- Start of recent Book -->
	<div class="container ">
		<h3 class="text-center font-weight-bold">Recent Books</h3>
		<div class="row">

			<%
			BookDAOImpl dao2 = new BookDAOImpl(DBConnect.getconn());
			List<BookDet> list2 = dao2.getRecentBooks();
			for (BookDet b : list2) {
			%>


			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="bookimg/<%=b.getPhoto()%>"
							style="height: 200px; width: 150px" class="img-thumblin">
						<p><%=b.getBookname()%></p>
						<p><%=b.getAuthor()%></p>

						<p>
							<%
							if (b.getBookCat().equals("old")) {
							%>
							Categories:<%=b.getBookCat()%></p>
						<div class="row">
							<a href="view_books.jsp?book_id=<%=b.getBook_id()%>"
								class="btn btn-success btn-sm ml-5">View Details</a>
							<a href=""
								class="btn btn-danger btn-sm ml-1"><%=b.getPrice()%><i
								class="fa-solid fa-indian-rupee-sign"></i></a>	

						</div>

						<%
						} else {
						%>
						Categories:<%=b.getBookCat()%>

						<div class="row">
							
							<%
							if (us == null) {
							%>

							<a href="login.jsp" class="btn btn-danger btn-sm ml-1"> <i
								class="fa-solid fa-cart-shopping"></i> Add cart
							</a>

							<%
							} else {
							%>
							<a href="cart?bid=<%=b.getBook_id()%>&&uid=<%=us.getUser_id() %>" class="btn btn-danger btn-sm ml-1"> <i
								class="fa-solid fa-cart-shopping"></i> Add cart
							</a>

							<%
							}
							%>
								 
								<a href="view_books.jsp?book_id=<%=b.getBook_id()%>"
								class="btn btn-success btn-sm ml-1">View Details</a> <a href=""
								class="btn btn-danger btn-sm ml-1"><%=b.getPrice()%><i
								class="fa-solid fa-indian-rupee-sign"></i></a>
						</div>
						<%
						}
						%>
					</div>

				</div>
			</div>
			<%
			}
			%>


		</div>
		<div class="text-center">
			<a href="all_recent_book.jsp" class="btn btn-danger btn-sm mt-2">View
				All</a>
		</div>
	</div>

	<!-- End of recent Book -->

	<hr>
	<!-- Start of New Book -->
	<div class="container ">
		<h3 class="text-center font-weight-bold">New Books</h3>
		<div class="row">

			<%
			BookDAOImpl dao = new BookDAOImpl(DBConnect.getconn());
			List<BookDet> list = dao.getNewBook();

			for (BookDet b : list) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="bookimg/<%=b.getPhoto()%>"
							style="height: 200px; width: 150px" class="img-thumblin">
						<p><%=b.getBookname()%></p>
						<p><%=b.getAuthor()%></p>
						<p>
							Categories :
							<%=b.getBookCat()%></p>
						<div class="row">

							<%
							if (us == null) {
							%>

							<a href="login.jsp" class="btn btn-danger btn-sm ml-1"> <i
								class="fa-solid fa-cart-shopping"></i> Add cart
							</a>

							<%
							} else {
							%>
							<a href="cart?bid=<%=b.getBook_id()%>&&uid=<%=us.getUser_id() %>" class="btn btn-danger btn-sm ml-1"> <i
								class="fa-solid fa-cart-shopping"></i> Add cart
							</a>

							<%
							}
							%>

							<a href="view_books.jsp?book_id=<%=b.getBook_id()%>"
								class="btn btn-success btn-sm ml-1">View Details</a> <a href=""
								class="btn btn-danger btn-sm ml-1"><%=b.getPrice()%><i
								class="fa-solid fa-indian-rupee-sign"></i></a>
						</div>
					</div>

				</div>
			</div>


			<%
			}
			%>

		</div>
		<div class="text-center">
			<a href="all_new_book.jsp" class="btn btn-danger btn-sm mt-2">View
				All</a>
		</div>
	</div>
	<!-- End of New Book -->

	<hr>

	<!-- Start of Old Book -->
	<div class="container ">
		<h3 class="text-center font-weight-bold">Old Books</h3>
		<div class="row">

			<%
			BookDAOImpl dao3 = new BookDAOImpl(DBConnect.getconn());
			List<BookDet> list3 = dao3.getOldBooks();
			for (BookDet b : list3) {
			%>


			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="bookimg/<%=b.getPhoto()%>"
							style="width: 150px; height: 200px" class="img-thumblin">
						<p><%=b.getBookname()%></p>
						<p><%=b.getAuthor()%></p>
						<p><%=b.getBookCat()%></p>

						<div class="row">
							<a href="view_books.jsp?book_id=<%=b.getBook_id()%>"
								class="btn btn-success btn-sm ml-5">View Details</a> <a href=""
								class="btn btn-danger btn-sm"><%=b.getPrice()%><i
								class="fa-solid fa-indian-rupee-sign"></i></a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>

		</div>
		<div class="text-center">
			<a href="all_old_book.jsp" class="btn btn-danger btn-sm mt-2">View
				All</a>
		</div>
	</div>
	<!-- End of Old Book -->

	<%@include file="components/footer.jsp"%>

</body>
</html>