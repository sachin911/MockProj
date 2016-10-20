
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List,com.mock.project.model.Order"%>
<!DOCTYPE html>
<html>
<head>
<title>Order History</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="./css/pm-pending-order.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@ page isELIgnored="false"%>

<script type="text/javascript">
	function addMessage() {
		var mess = "${message}";
		console.log("ADDED HTML TO BODY: " + mess);
		var orderContainer = document.getElementById("pending-order-data");
		orderContainer.innerHTML = mess;
		orderContainer.innerHTML = mess;
	}
</script>


</head>
<body onload="addMessage()">
	<!-- Navigation Bar -->
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="./PMHome.jsp">Portfolio Manager</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="./PMHome.jsp">Home</a></li>
				<li><a href="./CreateTrade.jsp">Create Order</a></li>
				<li><a href="ViewOrderBlotter">Order Blotter</a></li>
				<li><a href="ViewPendingOrder">Pending Orders</a></li>
				<li class="active"><a href="GeneralView">History</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<%
			String portfolioType = (String) session.getAttribute("PortfolioType");
		%>

		<h2 id="pending-order-title">
			<%
				out.println(portfolioType);
			%>
		</h2>
		<div id="pending-order-container">
			<!-- order in blotter -->
			<div class="row well" id="pending-order-headers">
				<!--<div class="col col-sm-1"> Order ID </div>-->
				<div class="col col-sm-1">Symbol</div>
				<div class="col col-sm-1">Quantity</div>
			</div>
			<div class="row well" id="pending-order-data">
		</div>
	</div>

</body>
</html>