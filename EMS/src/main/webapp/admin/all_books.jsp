<%@page import="java.util.List"%>
<%@page import="com.entity.BookDet"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.BookDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Admin : All Books</title>
<%@include file="/admin/css.jsp"%>

</head>
<body>
	<%@include file="/admin/Navbar.jsp"%>
	
	<c:if test="${empty userobj}">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	
	<c:if test="${not empty succMsg}">
		<p class="text-center text-success">${succMsg}</p>
		<c:remove var="succMsg" scope="session" />
	</c:if>

	<c:if test="${not empty failMsg}">
		<p class="text-center text-danger">${failMsg}</p>
		<c:remove var="failMsg" scope="session" />
	</c:if>

	<table class="table table-striped">
		<thead class="bg-primary text-white">
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Image</th>
				<th scope="col">Book Name</th>
				<th scope="col">Author</th>
				<th scope="col">Price</th>
				<th scope="col">Category</th>
				<th scope="col">Status</th>
				<th scope="col">Actions</th>
			</tr>
		</thead>
		<tbody>

			<%
			BookDAOImpl dao = new BookDAOImpl(DBConnect.getconn());
			List<BookDet> list = dao.getBook();

			for (BookDet b : list) {
			%>
			<tr>
				<td><%=b.getBook_id()%></td>
				<td><img src="../bookimg/<%=b.getPhoto()%>"
					style="width: 50px; height: 50px"></td>
				<td><%=b.getBookname()%></td>
				<td><%=b.getAuthor()%></td>
				<td><%=b.getPrice()%></td>
				<td><%=b.getBookCat()%></td>
				<td><%=b.getStatus()%></td>
				<td><a href=edit_books.jsp?id=<%=b.getBook_id()%>
					class="btn btn-sm btn-primary"><i class="fa-regular fa-pen-to-square"></i></a> <a href="../delete?id=<%=b.getBook_id()%>"
					class="btn btn-sm btn-danger"><i class="fa-solid fa-trash"></i></a></td>
			</tr>
			<%
			}
			%>


		</tbody>
	</table>
	<div style="margin-top: 230px;">
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>