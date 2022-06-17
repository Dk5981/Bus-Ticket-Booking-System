<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
	$(document).ready(function() {
						$("input[type=email]")
								.blur(
										function() {
											var str = $(".mail").val();
											$
													.get("ExistEmailCheck", {
														email : str
													})
													.done(
															function(data) {
																if (data == 'true') {
																	var lblError = document
																			.getElementById("lblError");
																	document
																			.getElementById("txtEmail").style.borderColor = "red";
																	lblError.innerHTML = "Sorry !!! Email Id is Already Exists.";
																	document
																			.getElementById("uemail").style.color = "red";
																	document
																			.getElementById("txtEmail").value = "";
																}
															});
										});
					});
</script>
</head>
<body>
</body>
</html>