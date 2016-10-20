<%@page import="java.util.ArrayList"%>
<%@page
	import="org.springframework.context.support.AbstractApplicationContext"%>
<% response.addHeader("Refresh","4"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.mock.project.config.AppConfig"%>
<%@page
	import="org.springframework.context.annotation.AnnotationConfigApplicationContext"%>

<%@ page import="java.util.List"%>
<%@ page import="com.mock.project.model.Order"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Pending Order</title>
<%@ page isELIgnored="false"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">

function amend(i){
	
	var out=document.getElementById('order_id'+i);
	console.log(i)
	var message=out.innerHTML;
	console.log(message);
 	$.ajax({
		type: "POST",
		url: "AmendOrderPMc",
		data: "message=" + message ,
		success: function(data) {
	    		window.location.href="AmendOrder.jsp";    
					},
		error:function(jqXHR, textStatus, errorThrown) {
	          	console.log(textStatus, errorThrown);
				}
	}); 
}

function cancel(i){
	
	var out=document.getElementById('order_id'+i);

	var message=out.innerHTML;
	console.log(message);
 $.ajax({
	                type: "POST",
	                url: "DeleteOrder",
	                data: "message=" + message ,
	                success: function(data) {
	                  console.log("data is sent");
	                },
	                     error:function(jqXHR, textStatus, errorThrown) {
	                       console.log(textStatus, errorThrown);
	                     
	                }
	              }); 

}

</script>
<style>
.btn {
	font-size: 0.9em;
}

#pending-order-headers {
	margin-bottom: 2px;
	font-weight: bolder;
	overflow-y: scroll;
	border-bottom-left-radius: 0px;
	border-bottom-right-radius: 0px;
}

#pending-order-headers div {
	margin: auto;
}

#pending-order-data {
	height: 70vh;
	overflow-y: scroll;
	font-size: 0.85em;
	border-top-left-radius: 0px;
	border-top-right-radius: 0px;
}

#pending-order-data div {
	margin: auto;
	margin-bottom: 8px;
	height: 35px;
	font-weight: 600;
	line-height: 35px;
	vertical-align: middle;
}

//
scroll bar cutomization . #pending-order-headers::-webkit-scrollbar {
	width: 1em;
}

#pending-order-headers::-webkit-scrollbar-track {
	-webkit-box-shadow: inset 0 0 6px transparent;
}

#pending-order-headers::-webkit-scrollbar-thumb {
	background-color: transparent;
	outline: 1px solid slategrey;
}

#pending-order-data::-webkit-scrollbar {
	width: 1em;
}

#pending-order-data::-webkit-scrollbar-track {
	-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
}

#pending-order-data::-webkit-scrollbar-thumb {
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
				<li><a href="ViewOrderBlotter">Order Blotter</a></li>
				<li class="active"><a href="ViewPendingOrder">Pending
						Orders</a></li>
				<li><a href="GeneralView">History</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<h2 id="pending-order-title">Pending Order</h2>
		<div id="pending-order-container">
			<!-- order in blotter -->
			<div class="row well" id="pending-order-headers">
				<div class="col col-sm-1">Order ID</div>
				<div class="col col-sm-1">Symbol</div>
				<div class="col col-sm-1">Side</div>
				<div class="col col-sm-1">Type</div>
				<div class="col col-sm-1">Qualifier</div>
				<div class="col col-sm-1">Trader</div>
				<div class="col col-sm-1">Quantity</div>
				<div class="col col-sm-1">Stop</div>
				<div class="col col-sm-1">Limit</div>
				<div class="col col-sm-1">Status</div>
				<div class="col col-sm-1">Amend</div>
				<div class="col col-sm-1">Cancel</div>
			</div>

			<div class="row well" id="pending-order-data">
				<c:forEach items='${Orders}' var="Orders" varStatus="loop">
					<div class="row " id="orderid1-data">
						<div class="col col-sm-1" id="order_id${loop.index +1}">
							<c:out value='${Orders.orderId}' />
						</div>
						<div class="col col-sm-1">
							<c:out value='${Orders.symbol}' />
						</div>
						<div class="col col-sm-1">
							<c:out value='${Orders.side}' />
						</div>
						<div class="col col-sm-1">
							<c:out value='${Orders.orderType}' />
						</div>
						<div class="col col-sm-1">
							<c:out value='${Orders.qualifier}' />
						</div>
						<div class="col col-sm-1">
							<c:out value='${Orders.traderId}' />
						</div>
						<div class="col col-sm-1">
							<p class="${loop.index +1}">
								<c:out value='${Orders.qtyPlaced}' />
							</p>
						</div>
						<div class="col col-sm-1">
							<c:out value='${Orders.stopPrice}' />
						</div>
						<div class="col col-sm-1">
							<c:out value='${Orders.limitPrice}' />
						</div>
						<div class="col col-sm-1">
							<c:out value='${Orders.status}' />
						</div>
						<div class="col col-sm-1">
							<button id="orderId1-cancel${loop.index +1}" type="button"
								class="btn btn-danger" onclick="amend(${loop.index +1})">Amend</button>
						</div>
						<div class="col col-sm-1">
							<button id="orderId1-cancel${loop.index +1}"
												type="button" class="btn btn-danger"
												onclick="cancel(${loop.index +1})">Cancel</button>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>
