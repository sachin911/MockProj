<%@page import="com.sapient.config.AppConfig"%>
<%@page import="com.sapient.service.BrokerService"%>
<%@page
	import="org.springframework.context.annotation.AnnotationConfigApplicationContext"%>
<%@page
	import="org.springframework.context.support.AbstractApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="com.sapient.dao.* ,com.sapient.model.Block, java.util.List ,java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Case</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
table {
	border-collapse: separate;
	border-spacing: 0 1em;
}
</style>
</head>
<body>
	<%
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();
		BrokerService brokerService = (BrokerService) container.getBean("brokerService");
		List<Block> blockList = new ArrayList();

		blockList = brokerService.findALL();
	%>
	<div class="container">
		<h3>Broker</h3>
		<ul class="nav nav-pills">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="ConfigureSecurity.jsp">Configure</a></li>
			<li><a href="ViewFills.jsp">View Fills</a></li>
			<li><a href="Login.jsp">Logout</a></li>
		</ul>
	</div>
	<div class="container" style="height: 300px; overflow-y: scroll;">
		<table style="width: 100%" class="table table-striped">

			<tr>
				<th>Block Id</th>    
				<th>Ticker</th>    
				<!-- <th>Name</th> -->
				<th>Side</th>
				<th>Type</th>
				<th>Stop Price</th>
				<th>Limit Price</th>
				<th>Executed Price</th>
				<th>Total Quantity</th>
				<th>Executed Quantity</th>
				<th>Executed Date</th>
				<th>Status</th>  
			</tr>
			<%
				for (Block blocks : blockList) {
			%> 
			<tr>
				<td><%=blocks.getId()%></td>
				<td><%=blocks.getSymbol()%></td>
				<%-- <td><%=blocks.get %></td> --%>
				<td><%=blocks.getSide()%></td>
				<td><%=blocks.getType()%></td>
				<td><%=blocks.getStop_price()%></td>
				<td><%=blocks.getLimit_price()%></td>
				<td><%=blocks.getExecuted_price()%></td>
				<td><%=blocks.getTotal_quantity()%></td>
				<td><%=blocks.getExecuted_quantity()%></td>
				<td><%=blocks.getExecuted_date()%></td>
				<td><%=blocks.getStatus()%></td>
			</tr>
			<!-- <tr>
				<td>1</td>
				<td>GOOG</td>
				<td>BUY</td>
				<td>Market</td>
				<td>0</td>
				<td>0</td>
				<td>150.36</td>
				<td>800</td>
				<td>500</td>
				<td>10/2/2016</td>
				<td>OPEN</td>
			</tr> 
			<tr>
				<td>2</td>
				<td>GOOG</td>
				<td>SELL</td>
				<td>Market</td>
				<td>0</td>
				<td>0</td>
				<td>150.36</td>
				<td>800</td>
				<td>500</td>
				<td>10/2/2016</td>
				<td>OPEN</td>
			</tr>  -->
			<%
				}
			%>
		</table>
	</div>
	<div class="container">
		<form method="post" action="startStopService">
			<input type="submit" name="start" value="start"	class="btn btn-info btn-lg"">
			<input type="submit" name="stop" value="stop" class="btn btn-info btn-lg"">
			
		</form>
	</div>
</body>
</html>



