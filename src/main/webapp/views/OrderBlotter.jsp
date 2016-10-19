<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page
	import="org.springframework.context.support.AbstractApplicationContext"%>
<%
	response.addHeader("Refresh", "10");
%>
<%@page import="com.mock.project.config.AppConfig"%>
<%@page
	import="org.springframework.context.annotation.AnnotationConfigApplicationContext"%>
<%@ page import="java.util.List"%>
<%@ page import="com.mock.project.model.Order"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Order Blotter</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://rawgit.com/Govind-jha/online-resources/master/pm-home.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
	function send() {
		var data = [];
		$('#order-blotter-data input:checked').each(function() {
			data.push($(this).attr('name'));
		});
		console.log(data);
		$.ajax({
			type : "POST",
			url : "SendToTrader",
			data : "data=" + data,
			success : function(data) {
				console.log("data is sent");
			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log(textStatus, errorThrown);

			}
		});
	}
</script>
<style>
.btn {
	font-size: 0.9em;
}

#order-blotter-headers {
	margin-bottom: 2px;
	font-weight: bolder;
	overflow-y: scroll;
	border-bottom-left-radius: 0px;
	border-bottom-right-radius: 0px;
}

#order-blotter-headers div {
	margin: auto;
}

#order-blotter-data {
	height: 70vh;
	overflow-y: scroll;
	font-size: 0.85em;
	border-top-left-radius: 0px;
	border-top-right-radius: 0px;
}

#order-blotter-data div {
	margin: auto;
	margin-bottom: 8px;
	height: 35px;
	font-weight: 600;
	line-height: 35px;
	vertical-align: middle;
}

#orderId1-send {
	float: right;
	font-size: 18px;
}

//
scroll bar cutomization . #order-blotter-headers::-webkit-scrollbar {
	width: 1em;
}

#order-blotter-headers::-webkit-scrollbar-track {
	-webkit-box-shadow: inset 0 0 6px transparent;
}

#order-blotter-headers::-webkit-scrollbar-thumb {
	background-color: transparent;
	outline: 1px solid slategrey;
}

#order-blotter-data::-webkit-scrollbar {
	width: 1em;
}

#order-blotter-data::-webkit-scrollbar-track {
	-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
}

#order-blotter-data::-webkit-scrollbar-thumb {
	background-color: darkgrey;
	outline: 1px solid slategrey;
}
</style>
</head>
<body>

	<!-- Navigation Bar -->
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="./PMHome.jsp">Portfolio Manager</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="./PMHome.jsp">Home</a></li>
				<li><a href="./CreateTrade.jsp">Create Order</a></li>
				<li class="active"><a href="ViewOrderBlotter">Order Blotter</a></li>
				<li><a href="./PendingOrder.jsp">Pending Orders</a></li>
				<li><a href="./PMHistory.jsp">History</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">

		<h2 id="order-blotter-title">
			Order Blotter
			<button id="orderId1-send" type="button" class="btn btn-success"
				onclick="send()">Send to Trader</button>
		</h2>

		<div id="order-blotter-container">
			<!-- order in blotter -->
			<div class="row well" id="order-blotter-headers">
				<div class="col col-sm-1">&nbsp;</div>
				<div class="col col-sm-1">Order ID</div>
				<div class="col col-sm-1">Symbol</div>
				<div class="col col-sm-1">Side</div>
				<div class="col col-sm-1">Type</div>
				<div class="col col-sm-1">Qualifier</div>
				<div class="col col-sm-1">Trader</div>
				<div class="col col-sm-1">Quantiy</div>
				<div class="col col-sm-1">Stop</div>
				<div class="col col-sm-1">Limit</div>
				<div class="col col-sm-1">&nbsp;</div>
				<div class="col col-sm-1">&nbsp;</div>
			</div>

			<div class="row well" id="order-blotter-data">
				<c:forEach items='${Orders}' var="Orders">
					<div class="row " id="orderid-data">
						<div class="col col-sm-1">
							<input type="checkbox" id="checkbox" name='${Orders.orderId}'>
						</div>
						<div class="col col-sm-1">
							<label class="OrderId"><c:out value='${Orders.orderId}' /></label>
						</div>
						<div class="col col-sm-1">
							<c:out value='${Orders.symbol}' />
						</div>
						<div class="col col-sm-1">
							<c:out value='${Orders.side}' />
						</div>
						<div class="col col-sm-1 col-centered">
							<c:out value='${Orders.orderType}' />
						</div>
						<div class="col col-sm-1">
							<c:out value='${Orders.qualifier}' />
						</div>
						<div class="col col-sm-1">
							<c:out value='${Orders.traderId}' />
						</div>
						<div class="col col-sm-1">
							<c:out value='${Orders.qtyPlaced}' />
						</div>
						<div class="col col-sm-1">
							<c:out value='${Orders.stopPrice}' />
						</div>
						<div class="col col-sm-1">
							<c:out value='${Orders.limitPrice}' />
						</div>
						<div class="col col-sm-1">
							<button id="orderId-edit" type="button" class="btn btn-warning">Edit</button>
						</div>
						<div class="col col-sm-1">
							<button id="orderId-cancel" type="button" class="btn btn-danger">Cancel</button>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>
	</div>
</body>
</html>