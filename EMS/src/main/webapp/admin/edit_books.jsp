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
<title>Admin: Edit books</title>
<%@include file="/admin/css.jsp"%>

</head>
<body style="background-color: #f0f1f2">
	<%@include file="/admin/Navbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center">Edit Books</h4>

						<%
						int id = Integer.parseInt(request.getParameter("id"));
						BookDAOImpl dao = new BookDAOImpl(DBConnect.getconn());

						BookDet b = dao.getBooksById(id);
						%>


						<form action="../edit_books" method="post">
							<input type="hidden" name="id" value="<%=b.getBook_id()%>">
							<div class="form-group">
								<label for="exampleInputEmaiL1">Book Name*</label> <input
									name="bname" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									value="<%=b.getBookname()%>">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Author Name*</label> <input
									name="author" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHeLp"
									value="<%=b.getAuthor()%>">
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">Price*</label> <input
									name="price" type="number" class="form-control"
									id="exampleInputPassword1" value="<%=b.getPrice()%>">
							</div>


							<div class="form-group">
								<label for="inputState">Book Status</label> <select
									id="inputState" name="bstatus" class="form-control">
									<%
									if ("active".equals(b.getStatus().toLowerCase())) {
									%>
									<option value="active" selected>Active</option>
									<option value="inactive">Inactive</option>
									<%
									} else {
									%>
									<option value="inactive" selected>Inactive</option>
									<option value="active">Active</option>
									<%
									}
									%>
								</select>
							</div>



							<button type="submit" class="btn btn-primary">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="margin-top: 230px;">
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>