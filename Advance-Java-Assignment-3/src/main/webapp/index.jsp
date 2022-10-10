<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" />

<style>
@charset "ISO-8859-1";

body {
	padding-top: 90px;
}

.astrick:after {
	content: " *";
	color: red;
}

.panel-login {
	border-color: #ccc;
	-webkit-box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.2);
	-moz-box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.2);
	box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.2);
}

.panel-login>.panel-heading {
	color: #00415d;
	border-color: #fff;
	text-align: center;
}

label {
	font-weight: 500;
	font-size: 20px;
}

.panel-login input {
	height: 45px;
	border: 1px solid #ddd;
	font-size: 16px;
	-webkit-transition: all 0.1s linear;
	-moz-transition: all 0.1s linear;
	transition: all 0.1s linear;
}

.panel-login input:hover, .panel-login input:focus {
	outline: none;
	-webkit-box-shadow: none;
	-moz-box-shadow: none;
	box-shadow: none !important;
}

.forgot-password {
	text-decoration: underline;
	color: #888;
}

.forgot-password:hover, .forgot-password:focus {
	text-decoration: underline;
	color: #666;
}
</style>
</head>
<body>

	<div class="container">
		<div class="row">

			<div class=" panel-login">
				<div class="panel-heading">


					<h2>Login to Continue...</h2>


					<hr>
				</div>
				<div class="panel-body">
					<div class="row">

						<form action="login" method="post">
							<div class="form-group row p-2">
								<label class="astrick col-sm">Username</label> <input
									type="text" class="form-control col-sm" id="inputName"
									name="uname" aria-describedby="Name" placeholder="UserName"
									required />
							</div>
							<div class="form-group row p-2">
								<label class="astrick col-sm">Password</label> <input
									name="upass" type="password" id="loginPass" required
									tabindex="2" class="form-control col-sm" placeholder="Password">
							</div>
							<br>
							<div class="p-2 d-grid gap-2 d-md-block text-center">
								<button type="submit" class="btn btn-secondary">Login</button>
								<a id="forget-pass-link" tabindex="5"
                                                   class="forgot-password">Forgot Password?</a>
							</div>
							<br>
						</form>

</div>
			</div>		
				
			</div>
	</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
