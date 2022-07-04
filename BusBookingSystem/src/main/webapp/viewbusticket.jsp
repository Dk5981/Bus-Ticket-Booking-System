<%@page import="com.busticketbooking.bean.Booking"%>
<%@page import="com.busticketbooking.bean.Bus"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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

<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
<script type="text/javascript"
	src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<style>
body {
	background-image: url("images/busimage.jpg");
	background-repeat: no-repeat;
	background-size: 4500px;
}


tr:nth-child(odd) {background-color: black; color:white;}
tr:nth-child(even) {background-color: grey; color:white;}


tr {
	border-style: solid;
	border-top: 1px;
	border-top-color: #6c757d;
	border-left: none;
	border-right: none;
	font-family: "Lucida Console", Courier, monospace;
}

.main {
	border-color: black;
	border-style: double;
	border-width: 2px;
	width: 80%;
	margin-top: 40px;
	font-family: "Lucida Console", Courier, monospace;
	background-color: white;
}

.up {
	margin-bottom: 40px;
	height: 50px;
	width: 100%;
	/* 	border-color: black;
	border-style: double;
	border-width: 2px; */
	background-color: #345;
	font-family: "Lucida Console", Courier, monospace;
}

.down {
	margin-top: 60px;
	height: 50px;
	width: 100%;
	/*  	border-color: black;
	border-style: double;
	border-width: 2px; */
	background-color: #345;
	font-family: "Lucida Console", Courier, monospace;
}
</style>
<title>Bus Ticket</title>
</head>
<center>
	<body>
		<%@include file="header.jsp"%>

		<!-- busList shows all the records of buses it is comes from the ViewBusesReport Servlet. -->
		<%
		Bus bus = (Bus) request.getAttribute("bus");
		Booking booking = (Booking) request.getAttribute("booking");
		%>

		<div class="main">
			<div class="up">
				<h1 style="font-family: Lucida Console; color: white;">Your Bus
					Ticket</h1>
			</div>
			<h1 style="padding-bottom: 40px;">Congoratulations!</h1>
			<div class="container">
				<table class="table table-hover active">

					<tbody>
						<tr>
							<th scope="row">Bus Name :</th>
							<td>yfytftyf</td>
						</tr>
						<tr>
							<th scope="row">Source :</th>
							<td>123</td>
						</tr>
						<tr>
							<th scope="row">Destination :</th>
							<td>fuck off</td>
						</tr>
						<tr>
							<th scope="row">Number of Seats :</th>
							<td>huhu</td>

						</tr>
						<tr>
							<th scope="row">Price :</th>
							<td>huhu</td>

						</tr>
						<tr>
							<th scope="row">Cost :</th>
							<td>huhu</td>

						</tr>
						<tr>
							<th scope="row">Date :</th>
							<td>huhu</td>

						</tr>
						<tr>
							<th scope="row">Time :</th>
							<td>huhu</td>

						</tr>
					</tbody>
				</table>
				<button  style="background-color:#0d6efd; color: white" onclick="window.print();">
					<i class="fa fa-print"></i> Print
				</button>

			</div>
			<div class="down">
				<h1 style="font-family: Lucida Console; color: white;">Your Bus
					Ticket</h1>
			</div>
		</div>
	</body>
</center>
</html>