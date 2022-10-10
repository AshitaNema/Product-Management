<%@page import="com.nagarro.training.Advance_Java_Assignment_3.constants.Constants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.List, java.util.ArrayList" %>
<%@ page import="org.hibernate.cfg.Configuration, org.hibernate.SessionFactory, org.hibernate.Session" %>

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
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
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
<style type="text/css">
.panel-heading {
	color: #00415d;
	border-color: #fff;
	text-align: center;
}
</style>
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




	<header>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header" style="margin-left: 30%;">
					<h2>Product Management Tool</h2>
				</div>
				<ul class="nav navbar-nav navbar-right">
					<li>
						<form action="logout">
							<label>Hi <%
								out.print(currUser.getUname());
							%>&nbsp&nbsp&nbsp</label> <input
								type="submit" value="logout">
						</form>
					</li>
				</ul>
			</div>
		</nav>
	</header>
	<br>
	<br>
	<div class="p-2" style="margin-left: 5%;">
		<h5>Please enter product details to add to stock</h5>

		<div style="width: 110px;">
			<form action="addProduct" method="post" class="upload-form">
				<table>
					<tr>
						<td>Title</td>
						<td><input type="text" name="title" required /></td>

					</tr>
					<tr>
						<td>Quantity</td>
						<td><input type="number" name="quantity" required /></td>

					</tr>
					<tr>
						<td>Size</td>
						<td><input type="number" name="size" required /></td>

					</tr>
					<tr>
						<td>Image</td>
						<td><input class="upload-file" type="file" name="image"
							data-max-size="1000000" required /></td>

					</tr>
				</table>
				<button type="submit" class="btn btn-primary">Add Product</button>
			</form>
		</div>


	</div>
	
	<div class="row mt-8 p-2">
            <table class="table table-bordered border border-dark mt-4" cellpadding="3" width=100%>
             <tr>
                <th>S. No.</th>
                <th>Title</th>
                <th>Quantity</th>
                <th>Size</th>
                <th>Image</th>
                <th>Actions</th>
             </tr>

            <%
            SessionFactory factory = new Configuration().configure().
                                                     addAnnotatedClass(Product.class).buildSessionFactory();
            Session session2 = factory.openSession();
            session2.beginTransaction();
            List<Product> productList = session2.createQuery("from Product").getResultList();
            session2.getTransaction().commit();
            session2.close();
            factory.close();
           Constants.dbImageLimit=0;
           int i=1;
            for(Product product : productList){
            	Constants.dbImageLimit += (product.getImage().length / Constants.byteunit);
    			System.out.println(product.getImage().length);
    			System.out.println(Constants.dbImageLimit);
            %>
            <tr>
                <td> <%= i %> </td>
                <td> <%= product.getProductTitle() %> </td>
                <td> <%= product.getProductQuantity() %> </td>
                <td> <%= product.getProductSize() %> </td>
                <td> <img src="data:image/jpg;base64,<%= product.getProductImage() %> " style="width:100px; height:100px;" /></td>
                <td class="text-center p-2">
                   <a href="<%=request.getContextPath()%>/editProduct?id=<%= product.getProductId() %>"><i class="fa fa-pencil-square-o p-2" style="font-size:36px"></i></a>
                   <a href="<%=request.getContextPath()%>/deleteProduct?id=<%= product.getProductId() %>"><i class="fa fa-trash-o" style="font-size:36px"></i></a>
                </td>
            </tr>
            

            <%
               i++; }
            %>
           </table>
           
           <h3 class="panel-heading">Total Size of the Uploaded Products => <% out.print(Constants.dbImageLimit); %> MB</h3>
           
          </div>

	
</body>
</html>