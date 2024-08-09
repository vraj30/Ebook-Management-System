<%@page import="com.entity.User"%>
<%@page import="com.entity.BookDet"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.BookDAOImpl"%>
<%@page import="java.sql.Connection"%>
<%@ page import="com.DB.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User: Old Book</title>
<%@include file="components/css.jsp"%>

</head>
<body>
<c:if test="${empty userobj}">
<c:redirect url="login.jsp"/>
</c:if>
	<%@include file="components/Navbar.jsp"%>

	<c:if test="${not empty succMsg}">
		<div class="alert alert-success text-center">
		${succMsg}</div>
		<c:remove var="succMsg" scope="session" />
	</c:if>


	<div class="container p-5">
		<table class="table table-striped">
			<thead class="bg-primary test-white">
				<tr>
					<th scope="col">Book Name</th>
					<th scope="col">Author</th>
					<th scope="col">Price</th>
					<th scope="col">Category</th>
					<th scope="col">Action</th>

				</tr>
			</thead>
			<tbody>

				<%
				User u=(User) session.getAttribute("userobj");
				String user_email = u.getUser_email();
				BookDAOImpl dao = new BookDAOImpl(DBConnect.getconn());
				List<BookDet> list = dao.getBookByOld(user_email, "old");
				for (BookDet b : list) {
				%>

				<tr>
					<td><%=b.getBookname()%></td>
					<td><%=b.getAuthor()%></td>
					<td><%=b.getPrice()%></td>
					<td><%=b.getBookCat()%></td>
					<td><a href="delete_old_book?em=<%=user_email%>&&id=<%=b.getBook_id() %>"
						class="btn btn-sm btn-danger">Delete</a></td>
				</tr>
				<%
				}
				%>


			</tbody>
		</table>
	</div>
</body>
</html>