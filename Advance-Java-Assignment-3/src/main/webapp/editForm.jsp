<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, java.util.ArrayList"%>
<%@ page
	import="org.hibernate.cfg.Configuration, org.hibernate.SessionFactory, org.hibernate.Session"%>

<%@ page
	import="com.nagarro.training.Advance_Java_Assignment_3.model.Users"%>
<%@ page
	import="com.nagarro.training.Advance_Java_Assignment_3.model.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" />
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
</head>
<body>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	%>
	<%
		String name = (String) session.getAttribute("userSession");
		Users currUser = new Users();
		currUser.setUname(name);
	%>





	<div class="container">
		<div class="row mb-3">
			<label class="col-sm-2 col-form-label"><h2>Edit</h2></label>
		</div>

		<form action="<%=request.getContextPath()%>/saveEditedProduct"
			method="post">

			<table>
				<tr>
					<td>Title</td>
					<td><input type="text" name="title"
						value="<%out.print(session.getAttribute("title")); %>" required /></td>

				</tr>
				<tr>
					<td>Quantity</td>
					<td><input type="number" name="quantity"
						value="<%out.print(session.getAttribute("quantity")); %>" required /></td>

				</tr>
				<tr>
					<td>Size</td>
					<td><input type="number" name="size"
						value="<%out.print(session.getAttribute("size")); %>" required /></td>

				</tr>
				<tr>
					<td>Image</td>
					<td><input class="upload-file" type="file" name="image"
						value="<%out.print(session.getAttribute("image")); %>"
						data-max-size="1000000" required /></td>

				</tr>
			</table>

			<button type="submit" class="btn btn-primary">Edit Product</button>
		</form>

	</div>



</body>
</html>