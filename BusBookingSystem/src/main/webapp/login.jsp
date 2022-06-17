<!DOCTYPE html>
<!--[if lt IE 7]> <html class="no-js lt-ie10 lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]> <html class="no-js lt-ie10 lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]> <html class="no-js lt-ie10 lt-ie9"> <![endif]-->
<!--[if IE 9]> <html class="no-js lt-ie10"> <![endif]-->
<!--[if gt IE 9]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />


<!--  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bo
  otstrap.min.css" />-->

<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<link rel="shortcut icon" href="/images/22.jpg" />
<link rel="stylesheet" href="css1/style.css" />
<link rel="stylesheet" href="css1/bootstrap.min.css" />
<link rel="dns-prefetch" href="https://cdnjs.cloudflare.com">
<style>
body {
	background-image: url("images/busimage.jpg");
	background-repeat: no-repeat;
	background-size: 4500px;
}
</style>
</head>

<body>
	<!--registerMsg shows that your registration is done successfully on
	login page.-->
	<%
	String registerMsg = (String) request.getAttribute("registrationMsg");
	%>
	<!-- Validation message for login page that entered email or password not found.-->
	<%
	String loginValidateMsg = (String) request.getAttribute("message");
	%>
	<%@include file="header.jsp"%>

	<div class="container">

		<h2 style="text-align: center; margin-top: 20px;">Sign in</h2>
		<br> <br> <br>
		<%
		if (registerMsg != null) {
		%>
		<h1 style="text-align: center; color: green; font-family: monospace;"><%=registerMsg%></h1>
		<%
		}
		%>
		<%
		if (loginValidateMsg != null) {
		%>
		<h3 style="text-align: center; color: red; font-family: monospace;"><%=loginValidateMsg%></h3>
		<%
		}
		%>
		<br>
		<form class="form validity" method="post" action="LoginAndLogout"
			style="width: 450px; margin-left: 350px; margin-top: 50px; font-variant: small-caps; font-weight: bold; font-size: large;">
			<div class="form-group">
				<label for="email2">E-mail</label> <input id="email2" name="email"
					class="form-control" data-mismatch="Please include a valid email"
					type="email" required>
			</div>

			<div class="form-group simple">
				<label for="phone2">Password</label>
				<!--        <input id="phone2" name="phone" class="form-control" pattern="\d{3}[\-]\d{3}[\-]\d{4}" data-mismatch="Please match the requested format" type="tel" required> -->
				<input type="password" class="form-control" name="password"
					id="myInput"
					data-mismatch="Password Contail atleast 1 special character and 1 digit and Uppercase also"
					pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required> <br>
				<!-- An element to toggle between password visibility -->
				<div class="form-inline">
					<div class="form-group">
						<input type="checkbox" onclick="myFunction()">Show
						Password
					</div>
					<div class="form-group" style="float: right;">
						<div class="rounded">
							<a href="registration.jsp"
								style="font-size: medium; color: black;">Create an Account</a>
						</div>
					</div>
					<br> <br>
					<div class="rounded">
						<a href="forgotpassword.jsp"
							style="font-size: medium; color: black;">Forgot Password?</a>
					</div>
				</div>
			</div>

			<button class="btn btn-block btn-primary" type="submit">Submit</button>
		</form>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="js1/jquery.validity.min.js"></script>
	<script src="js1/script.js"></script>
	<script>
		function myFunction() {
			var x = document.getElementById("myInput");
			if (x.type === "password") {
				x.type = "text";
			} else {
				x.type = "password";
			}
		}
	</script>
</body>
</html>