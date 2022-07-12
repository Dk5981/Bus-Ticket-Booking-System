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
</style>
<title>Booking Report</title>
</head>
<body>
	<script>
		$(document).ready(function() {
			$('#myTable').dataTable();
		});
	</script>
	<%@include file="header.jsp"%>
	<%
	int cnt = 0;
	%>
	<!-- busList shows all the records of buses it is comes from the ViewAllBooking Servlet. -->
	<%
	List<Bus> busList = (List<Bus>) request.getAttribute("busList");
	%>
	<%
	List<Booking> bookingList = (List<Booking>) request.getAttribute("allBookingList");
	%>
	<%
	List<User> userList = (List<User>) request.getAttribute("userList");
	%>
	<%
	String noBookingMsg = (String) request.getAttribute("noBookingMsg");
	%>
	<div class="container" style="border: t">
		<h2 style="text-align: center; margin-top: 20px;">Booking Report</h2>
		<br> <br>

		<%
		if (noBookingMsg != null) {
		%>
		<h4 style="text-align: center; color: red; font-family: monospace;"><%=noBookingMsg%></h4>
		<%
		} else {
		%>
		<table id="myTable" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>Sr. No</th>
					<th>Passenger Name</th>
					<th>Bus Name</th>
					<th>Bus Number</th>
					<th>Source</th>
					<th>Destination</th>
					<th>Number of Seats</th>
					<th>Price</th>
					<th>Total Cost</th>
					<th>Pick Up Date</th>
					<th>Pick UP Time</th>
					<th>Booking Date</th>
				</tr>
			</thead>
			<tbody>

				<%
				for (Booking booking : bookingList) {
				%>
				<%
				cnt = cnt + 1;
				%>
				<tr>
					<td><%=cnt%></td>
					<%
					for (User userObj : userList) {
					%>
					<%
					if (booking.getUserId() == userObj.getUserId()) {
					%>
					<td><%=userObj.getFirstName()%></td>
					<%
					}
					%>
					<%
					}
					%>
					<%
					for (Bus bus : busList) {
					%>
					<%
					if (booking.getBusId() == bus.getBusId()) {
					%>
					<td><%=bus.getBusName()%></td>
					<td><%=bus.getBusNumber()%></td>
					<td><%=bus.getBusSource()%></td>
					<td><%=bus.getBusDestination()%></td>
					<td><%=booking.getSeats()%>
					<td><%=bus.getPrice()%></td>
					<td><%=booking.getCost()%></td>
					<td><%=bus.getDate()%></td>
					<td><%=bus.getTime()%></td>
					<td><%=booking.getBookingDate()%></td>
				</tr>

				<%
				}
				%>
				<%
				}
				%>
				<%
				}
				%>


			</tbody>
		</table>
		<%
		}
		%>
	</div>
</body>
</html>