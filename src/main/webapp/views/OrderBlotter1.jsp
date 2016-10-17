<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<title>Order Blotter</title>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Portfolio Manager</a>
			</div>
			<ul class="nav navbar-nav">
				<li ><a href="PMHome.jsp">Home Page</a></li>		
				<li><a href="CreateTrade.jsp">Create Trader</a></li>
				<li class="active"><a href="OrderBlotter.jsp">Order Blotter</a></li>
				<li><a href="PMHistory.jsp">History</a></li>
			</ul>
		</div>
		<div class="container">
			<div class="well">
				<h2>Order Blotter</h2>
				<div class="panel-group" id="accordion">
					<div class="panel panel-default">
						<div class="panel-heading">
						
						
						<form action="PmSend" method="POST" modelAttribute="functionList" >
						
							<table class="table">

								<tr>
									<th></th>
									<th>Order ID</th>
									<th>Symbol</th>
									<th>Side</th>
									<th>Status</th>
									<th>Quantity</th>
									<th>Type</th>
									<th></th>
									<th></th>
								</tr>
								
								
								<c:forEach var="Order" varStatus="status" items="<%=request.getAttribute("Orders") %>">
								
								<tr>
									<td><label><input type=checkbox path="functionList[${status.index}].action" name="check"/></label></td>
									<td><%=request.getAttribute("Order.orderId")%></td>
									<td><%=request.getAttribute("Order.symbol")%></td>
									
									<td><%=request.getAttribute("Order.side")%></td>
									<td><%=request.getAttribute("Order.status")%></td>
									<td><%=request.getAttribute("Order.qtyPlaced")%></td>
									<td><%=request.getAttribute("Order.orderType")%></td>
									<td>
									<a href=""><button type="button" class="btn btn-default">Edit</button></a>
									</td>
									<td>
									<a href=""><button type="button" class="btn btn-default">Cancel</button></a>
									</td>
								</tr>

								 </c:forEach>


								
								
								
								
								
							</table>
							
							
							<input type="submit" class="btn btn-default" value="Send to Trader"/>
							
							</form>
							
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</nav>
</body>
</html>