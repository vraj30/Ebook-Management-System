<%@page import="com.entity.BookDet"%>
<%@page import="com.entity.User"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.BookDAOImpl"%>
<%@page import="java.sql.Connection"%>
<%@ page import="com.DB.DBConnect"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All New Books</title>
<%@include file="components/css.jsp"%>
<style type="text/css">
.crd-ho:hover {
	background-color: #fcfbe8;
}

#toast {
	min-width: 300px;
	position: fixed;
	bottom: 30px;
	left: 50%;
	margin-left: -125px;
	background: #333;
	padding: 10px;
	color: white;
	text-align: center;
	z-index: 1;
	font-size: 18px;
	visibility: hidden;
	box-shadow: 0px 0px 100px #000;
}

#toast.display {
	visibility: visible;
	animation: fadeIn 0.5, fadeOut 0.5s 2.5s;
}

@
keyframes fadeIn {from { bottom:0;
	opacity: 0;
}

to {
	bottom: 30px;
	opacity: 1;
}

}
@
keyframes fadeOut {form { bottom:30px;
	opacity: 1;
}

to {
	bottom: 0;
	opacity: 0;
}
}
</style>
</head>
<body>

	<%
	User us = (User) session.getAttribute("userobj");
	%>


	<c:if test="${not empty failedmsg}">
		<h5 class="tex-center text-danger">${failedmsg}</h5>
		<c:remove var="failedmsg" scope="session" />
	</c:if>


	<c:if test="${not empty succMsg}">
		<div id="toast">${succMsg}</div>

		<script type="text/javascript">
		showToast();
		function showToast(content)
		{
		    $('#toast').addClass("display");
		    $('#toast').html(content);
		    setTimeout(()=>{
		        $("#toast").removeClass("display");
		    },2000)
		}	
</script>

		<c:remove var="succMsg" scope="session"></c:remove>
	</c:if>

	<%@include file="components/Navbar.jsp"%>
	<div class="container-fluid">
		<div class="row p-3">

			<%
			BookDAOImpl dao = new BookDAOImpl(DBConnect.getconn());
			List<BookDet> list = dao.getAllNewBooks();

			for (BookDet b : list) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho mt-2">
					<div class="card-body text-center">
						<img alt="" src="bookimg/<%=b.getPhoto()%>"
							style="height: 150px; width: 150px" class="img-thumblin">
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
							<a href="cart?bid=<%=b.getBook_id()%>&&uid=<%=us.getUser_id()%>"
								class="btn btn-danger btn-sm ml-1"> <i
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
	</div>
</body>
</html>