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
<title>All Recent Books</title>
<%@include file="components/css.jsp"%>

<style type="text/css">
.crd-ho:hover {
	background-color: #fcfbe8;
}
</style>

</head>
<body>

	<%
	User us = (User) session.getAttribute("userobj");
	%>

	<%@include file="components/Navbar.jsp"%>
	<div class="container-fluid">
		<div class="row p-3">

			<%
			String ch = request.getParameter("ch");
			BookDAOImpl dao2 = new BookDAOImpl(DBConnect.getconn());
			List<BookDet> list2 = dao2.getBookBySearch(ch);
			for (BookDet b : list2) {
			%>


			<div class="col-md-3">
				<div class="card crd-ho mt-2">
					<div class="card-body text-center">
						<img alt="" src="bookimg/<%=b.getPhoto()%>"
							style="height: 150px; width: 150px" class="img-thumblin">
						<p><%=b.getBookname()%></p>
						<p><%=b.getAuthor()%></p>

						<p>
							<%
							if (b.getBookCat().equals("old")) {
							%>
							Categories:<%=b.getBookCat()%></p>
						<div class="row">
							<a href="view_books.jsp?book_id=<%=b.getBook_id()%>"
								class="btn btn-success btn-sm ml-5">View Details</a> <a href=""
								class="btn btn-danger btn-sm ml-1"> <%=b.getPrice()%><i
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
							<a href="cart?bid=<%=b.getBook_id()%>&&uid=<%=us.getUser_id()%>"
								class="btn btn-danger btn-sm ml-1"> <i
								class="fa-solid fa-cart-shopping"></i> Add cart
							</a>

							<%
							}
							%>

							<a href="" class="btn btn-success btn-sm ml-1">View Details</a> <a
								href="" class="btn btn-danger btn-sm ml-1"><%=b.getPrice()%><i
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
	</div>
</body>
</html>