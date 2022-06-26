<%@page import="com.busticketbooking.bean.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Basic -->
<title>Bus Ticket Booking System | Home</title>

<!-- Define Charset -->
<meta charset="utf-8">

<!-- Responsive Metatag -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- Page Description and Author -->
<meta name="description" content="Sulfur - Responsive HTML5 Template">
<meta name="author" content="Shahriyar Ahmed">

<!-- Bootstrap CSS  -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"
	type="text/css">

<!-- Font Awesome CSS -->
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css"
	type="text/css">

<!-- Owl Carousel CSS -->
<link rel="stylesheet" href="css/owl.carousel.css" type="text/css">
<link rel="stylesheet" href="css/owl.theme.css" type="text/css">
<link rel="stylesheet" href="css/owl.transitions.css" type="text/css">

<!-- Css3 Transitions Styles  -->
<link rel="stylesheet" type="text/css" href="css/animate.css">

<!-- Lightbox CSS -->
<link rel="stylesheet" type="text/css" href="css/lightbox.css">

<!-- Sulfur CSS Styles  -->
<link rel="stylesheet" type="text/css" href="css/style.css">

<!-- Responsive CSS Style -->
<link rel="stylesheet" type="text/css" href="css/responsive.css">

<script src="js/modernizrr.js"></script>
</head>
<body>
	<%
	HttpSession httpSession = request.getSession(false);
	User user = (User) httpSession.getAttribute("userObject");
	%>
	<header class="clearfix">

		<!-- Start  Logo & Naviagtion  -->
		<div class="navbar navbar-default navbar-top">
			<div class="container">
				<div class="navbar-header">
					<!-- Stat Toggle Nav Link For Mobiles -->
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<i class="fa fa-bars"></i>
					</button>
					<!-- End Toggle Nav Link For Mobiles -->
					<a class="navbar-brand" href="index.jsp">Follow the Road!</a>
				</div>
				<div class="navbar-collapse collapse">

					<!-- Start Navigation List -->
					<ul class="nav navbar-nav navbar-right">

						<%
						if (null == httpSession.getAttribute("userObject")) {
						%>
						<li><a href="index.jsp">Home</a></li>
						<li><a href="about.html">About Us</a></li>
						<li><a href="registration.jsp">Registration</a></li>
						<li><a href="login.jsp">Log In</a></li>
						<li><a href="blog.html">Blog</a></li>
						<li><a href="contact.html">Contact</a></li>
						<%
						} else if (user.getRole().equals("Admin")) {
						%>
						<li><a href="index.jsp">Home</a></li>
						<li><a href="addbus.jsp">Add Bus</a></li>
						<li><a href="#">Bus Report</a></li>
						<li><a href="#">Book Ticket Report</a></li>
						<li><a href="LoginAndLogout">Log Out</a></li>
						<%
						} else {
						%>
						<li><a href="index.jsp">Home</a></li>
						<li><a href="#">Search Bus</a></li>
						<li><a href="#">My Booking</a></li>
						<li><a href="LoginAndLogout">Log Out</a></li>
						<%
						}
						%>
					</ul>
					<!-- End Navigation List -->
				</div>
			</div>
		</div>
		<!-- End Header Logo & Naviagtion -->
	</header>
</body>
</html>