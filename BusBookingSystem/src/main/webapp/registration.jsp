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

	<%@include file="header.jsp"%>

	<div class="container">

		<h2 style="text-align: center;">Sign Up</h2>

		<form class="form validity" method="post" action="UserRegistration"
			style="width: 450px; margin-left: 350px; font-variant: small-caps; font-weight: bold; font-size: large;">
			<div class="form-group">
				<label for="name2">First Name</label> <input id="name2"
					name="firstName" class="form-control"
					data-missing="This field is required" type="text" required>
			</div>

			<div class="form-group">
				<label for="name2">Last Name</label> <input id="name2"
					name="lastName" class="form-control"
					data-missing="This field is required" type="text" required>
			</div>


			<div class="form-group">
				<label for="name2">Address</label>
				<!--         <input id="name2" name="name" class="form-control" data-missing="This field is required" type="text" required> -->
				<textarea rows="3" cols="50" class="form-control" name="address"
					id="name2" data-missing="This field is required" required></textarea>
			</div>

			<div class="form-group">
				<label for="email2">E-mail</label> <input id="email2" name="email"
					class="form-control" data-mismatch="Please include a valid email"
					type="email" required>
			</div>

			<div class="form-group simple">
				<label for="phone2">Phone (789-999-9999)</label> <input id="contact"
					name="contact" class="form-control" pattern="[789][0-9]{9}"
					data-mismatch="Enter 10 digit only" type="tel" required>
			</div>

			<div class="form-group simple">
				<label for="phone2">Password</label>
				<!--        <input id="phone2" name="phone" class="form-control" pattern="\d{3}[\-]\d{3}[\-]\d{4}" data-mismatch="Please match the requested format" type="tel" required> -->
				<input type="password" name="password" class="form-control"
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
							<a href="login.jsp" style="font-size: medium; color: black;">Already
								have an Account?</a>
						</div>
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