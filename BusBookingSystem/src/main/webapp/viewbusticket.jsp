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

tr:nth-child(odd) {
	background-color: #d9edf7;
	color: black;
}

tr:nth-child(even) {
	background-color: aliceblue;
	color: black;
}

tr {
	border-style: double;
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
	height: 50px;
	width: 100%;
	/* 	border-color: black;
	border-style: double;
	border-width: 2px; */
	background-color: #345;
}

.down {
	margin-top: 60px;
	height: 50px;
	width: 100%;
	padding: 20px;
	/*  	border-color: black;
	border-style: double;
	border-width: 2px; */
	background-color: #345;
	font-family: "Lucida Console", Courier, monospace;
}

.logo {
	width: 160px;
	height: 135px;
	padding-left: 40px;
}
.align{
font-family: monospace;
    font-weight: 400;
    text-transform: uppercase;
    margin-top: 0;
    margin-bottom: 80px;
    text-align: center;
    padding-left: 50px;}
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
				<h1 style="font-family: Lucida Console; color: #d9edf7;">Your
					Bus Ticket</h1>
			</div>
			<div class="form-inline" style="margin-right: 300px; margin-bottom: -90px">
				<div class="form-group" style="margin-bottom: 90px;">
					<img class="logo" height="20px" width="20px"
						src="images/buslogoonlineedit.png">
				</div>
				<div class="form-group">
					<h3 class="align">Congratulations!!! Your Ticket Booked Successfully.</h3>
				</div>
			</div>
			<div class="container">
				<table class="table table-hover active">

					<tbody>
						<tr>
							<th scope="row">Passenger Name :</th>
							<td><%=user.getFirstName()%></td>
						</tr>
						<tr>
							<th scope="row">Bus Name :</th>
							<td><%=bus.getBusName()%></td>
						</tr>
						<tr>
							<th scope="row">Bus Number :</th>
							<td><%=bus.getBusNumber()%></td>
						</tr>
						<tr>
							<th scope="row">Source :</th>
							<td><%=bus.getBusSource()%></td>
						</tr>
						<tr>
							<th scope="row">Destination :</th>
							<td><%=bus.getBusDestination()%></td>
						</tr>
						<tr>
							<th scope="row">Number of Seats :</th>
							<td><%=booking.getSeats()%></td>

						</tr>
						<tr>
							<th scope="row">Price :</th>
							<td><%=bus.getPrice()%></td>

						</tr>
						<tr>
							<th scope="row">Cost :</th>
							<td><%=booking.getCost()%></td>

						</tr>
						<tr>
							<th scope="row">Pick Up Date :</th>
							<td><%=bus.getDate()%></td>

						</tr>
						<tr>
							<th scope="row">Pick Up Time :</th>
							<td><%=bus.getTime()%></td>

						</tr>
						<tr>
							<th scope="row">Bus Booking Date :</th>
							<td><%=booking.getBookingDate()%></td>

						</tr>
					</tbody>
				</table>
				<button style="background-color: #0d6efd; color: white"
					onclick="window.print();">
					<i class="fa fa-print"></i> Print Ticket
				</button>
			</div>
			<div class="down">
				<h5 style="font-family: Lucida Console; color: white;">2022 All
					rights reserved @Follow the Road!!!</h5>
			</div>
		</div>
	</body>
</center>
</html>