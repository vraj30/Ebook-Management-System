<%@page import="com.entity.BookOrder"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.OrderDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Admin : Orders</title>
<%@include file="/admin/css.jsp"%>

</head>
<body>

	<c:if test="${empty userobj}">
		<c:redirect url="login.jsp" />
	</c:if>
	<%@include file="/admin/Navbar.jsp"%>
	

	<table class="table table-striped">
		<thead class="bg-primary text-white">
			<tr>
				<th scope="col">Order ID</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">Address</th>
				<th scope="col">Phone no.</th>
				<th scope="col">Book Name</th>
				<th scope="col">Author</th>
				<th scope="col">Price</th>
				<th scope="col">Payment Type</th>

			</tr>
		</thead>
		<tbody>

			<%
			OrderDAOImpl dao = new OrderDAOImpl(DBConnect.getconn());
			List<BookOrder> blist = dao.getAllBook();
			for (BookOrder b : blist) {
			%>
			<tr>
				<th scope="row"><%=b.getOrder_id()%></th>
				<td><%=b.getName()%></td>
				<td><%=b.getEmail()%></td>
				<td><%=b.getAddr()%></td>
				<td><%=b.getPhno()%></td>
				<td><%=b.getBookname()%></td>
				<td><%=b.getAuthor()%></td>
				<td><%=b.getPrice()%></td>
				<td><%=b.getPayT()%></td>
			</tr>

			<%
			}
			%>

		</tbody>
	</table>
	<div style="margin-top: 240px;">
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>