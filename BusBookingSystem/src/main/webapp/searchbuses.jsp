<%@page import="com.busticketbooking.bean.Bus"%>
<%@page import="java.util.List"%>
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

	<!-- This busNotAvailable shows that buses are not available. It comes from the SearchBus Servlet -->
	<%
	String busNotAvailable = (String) request.getAttribute("busNotAvailable");
	%>

	<div class="container">

		<h2 style="text-align: center; margin-top: 20px;">Search Bus</h2>
		<form class="form validity" method="post" action="SearchBus"
			style="width: 450px; margin-left: 350px; margin-top: 50px; font-variant: small-caps; font-weight: bold; font-size: large;">

			<%
			if (busNotAvailable != null) {
			%>
			<h4 style="text-align: center; color: red; font-family: monospace;"><%=busNotAvailable%></h4>
			<%
			}
			%>
			<div class="form-group">
				<label for="name2">Source</label> <input id="name2" name="source"
					class="form-control" data-missing="This field is required"
					type="text" required>
			</div>

			<div class="form-group">
				<label for="name2">Destination</label> <input id="name2"
					name="destination" class="form-control"
					data-missing="This field is required" type="text" required>
			</div>

			<div class="form-group">
				<label for="name2">Date</label> <input id="name2" name="date"
					class="form-control" data-missing="This field is required"
					type="date" required>
			</div>

			<div class="form-group">
				<label for="name2">Seats</label> <input id="name2" name="seats"
					class="form-control" data-missing="This field is required"
					type="text" required>

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
</body>
</html>