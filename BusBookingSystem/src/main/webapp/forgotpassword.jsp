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
<!-- <script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/mvc/3.0/jquery.validate.unobtrusive.min.js"></script> -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	/* $("form").submit(function() {
		if ($(this).valid()) { //<<< I was missing this check
			$("#loading").show();
		}
	}); */
	/* Validation of Email i.e. Email Id is Not Found. */
	$(document).ready(function() {
		$("input[type=email]").blur(function() {
			var str = $(".mail").val();
			$.get("UserRegistration", {
				email : str
			}).done(function(data) {

				if (data == 'false') {
					//alert("This email id is not matched.");
					$('#email-error').html("This Email Id is not Matched.");
					$(document).ready(function() {
						$("input[type=email]").val('').focus();
					});
				}
			});
		});
	});
</script>

</head>

<body>

	<%@include file="header.jsp"%>

	<div class="container">

		<h2 style="text-align: center; margin-top: 20px;">Forgot Password</h2>
		<br>
		<form class="form validity" method="post"
			action="ForgotPasswordSendEmail"
			style="width: 450px; margin-left: 350px; margin-top: 50px; font-variant: small-caps; font-weight: bold; font-size: large;">
			<div class="form-group">

				<label for="email2">E-mail</label> <input id="email2" name="email"
					class="form-control mail"
					data-mismatch="Please include a valid email" type="email" required>
				<span id="email-error" style="color: red; font-size: 15px;"></span>
			</div>

			<a href="login.jsp">Back to Log In</a> <br> <br>
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