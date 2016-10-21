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
<title>Home Screen</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script  type="text/javascript"  src="/path/to/jquery-latest.js"></script>
 
<script  type="text/javascript"  src="/path/to/jquery.tablesorter.js"></script>
 
<style>
table {
	border-collapse: separate;
	border-spacing: 0 1em;
}

.led-red {
	margin: 20px auto;
	width: 12px;
	height: 12px;
	background-color: #940;
	border-radius: 50%;
	box-shadow: #000 0 -1px 7px 1px, inset #600 0 -1px 9px, #F00 0 2px 12px;
}

.led-green {
	margin: 20px auto;
	width: 12px;
	height: 12px;
	background-color: #690;
	border-radius: 50%;
	box-shadow: #000 0 -1px 7px 1px, inset #460 0 -1px 9px, #7D0 0 2px 12px;
}

/* th:hover {
	cursor: pointer;
	background: #AAA;
} */
li:last-child {
	float: right;
}
</style>
</head>
<body>
<div class="pen-title" >
	
	<img src="http://www.aiiria.com/wp-content/uploads/2015/11/Aiiria-original-logos_2015.png" height="90px" width="130px" style="float:left; margin-left:20px">
	
		
		
	</div>
	<%
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();
		BrokerService brokerService = (BrokerService) container.getBean("brokerService");
		List<Block> blockList = new ArrayList();

		blockList = brokerService.openPartialView();
	%>
	<div class="container">
		<h3>Broker</h3>
		<ul class="nav nav-pills">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="ConfigureSecurity.jsp">Configure</a></li>
			<li><a href="ViewFills.jsp">View Fills</a></li>
			<li><a href="logout">Logout</a></li>


			<li><a onclick="confirmstop()" class="btn btn-info btn-lg">Stop</a></li>



		</ul>
	</div>
	<div class="container" style="height: 600px; overflow-y: scroll;"
		overflow-x:>
		<table style="width: 100%" class="table table-striped tablesorter"
			id="mytable">
			<thead>
				<tr>

					<th id="sl" onmousedown="this.style.background='#AAA'" onmouseup="this.style.background='#FFF'"><pre>BlockId</pre></th>    
					<th id="nm" onmousedown="this.style.background='#AAA'" onmouseup="this.style.background='#FFF'"><pre>Ticker</pre></th>    
					<!-- <th>Name</th> -->
					<th id="nm1" onmousedown="this.style.background='#AAA'" onmouseup="this.style.background='#FFF'"><pre>Side</pre></th>
					<th id="nm2" onmousedown="this.style.background='#AAA'" onmouseup="this.style.background='#FFF'"><pre>Type</pre></th>
					<th id="nm3" onmousedown="this.style.background='#AAA'" onmouseup="this.style.background='#FFF'"><pre>Stop Price</pre></th>
					<th id="nm4" onmousedown="this.style.background='#AAA'" onmouseup="this.style.background='#FFF'"><pre>Limit Price</pre></th>
					<th id="nm5" onmousedown="this.style.background='#AAA'" onmouseup="this.style.background='#FFF'"><pre>Executed Price</pre></th>
					<th id="nm6" onmousedown="this.style.background='#AAA'" onmouseup="this.style.background='#FFF'"><pre>Total Quantity</pre></th>
					<th id="nm7" onmousedown="this.style.background='#AAA'" onmouseup="this.style.background='#FFF'"><pre>Executed Quantity</pre></th>
					<th id="nm8" onmousedown="this.style.background='#AAA'" onmouseup="this.style.background='#FFF'"><pre>Executed Date</pre>
						</th>
					<th id="nm9" onmousedown="this.style.background='#AAA'" onmouseup="this.style.background='#FFF'"><pre>Status</pre></th>  

					

				</tr>
			</thead>
			<tbody>
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
				
								
					<%}%>
				
			</tbody>
		</table>
	</div>
	<div class="container">
		<form method="post" action="startStopService">
			<input type="submit" name="start" value="start" class="btn btn-info btn-lg" style="display:inline;float:left">

			<!-- <input type="submit" name="stop" value="stop" class="btn btn-info btn-lg""> -->

			<!-- <input type="submit" name="start" value="start"	class="btn btn-info btn-lg"">
			<input type="submit" name="stop" value="stop" class="btn btn-info btn-lg""> -->

				
			<!-- 			<input type="submit"  name="stop" value="stop" class="btn btn-info btn-lg""> -->
		</form>
		
<%-- 		<form method="post" action="checkStatus">
						<span id="error-message"></span>
			<input type="submit" name="status" value="status"
				class="btn btn-info btn-lg" style="display:inline;margin-left: 8px">
				<% if(request.getSession().getAttribute("status") == "true"){ %>
			<div class="led-green" style="margin-left: 2rem"></div>
				<%} else { %>
			<div class="led-red" style="margin-left: 2rem"></div>
			<% } %>

		</form> --%>
	</div>
	<script   src="https://code.jquery.com/jquery-3.1.1.js"   
	integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="   
	crossorigin="anonymous">
	
	
	</script>
	<script>
		function sortTable(f, n) {
			var rows = $('#mytable tbody  tr').get();

			rows.sort(function(a, b) {

				var A = getVal(a);
				var B = getVal(b);

				if (A < B) {
					return -1 * f;
				}
				if (A > B) {
					return 1 * f;
				}
				return 0;
			});

			function getVal(elm) {
				var v = $(elm).children('td').eq(n).text().toUpperCase();
				if ($.isNumeric(v)) {
					v = parseInt(v, 10);
				}
				return v;
			}

			$.each(rows, function(index, row) {
				$('#mytable').children('tbody').append(row);
			});
		}
		var f_sl = 1;
		var f_nm = 1;
		$("#sl").click(function() {
			f_sl *= -1;
			var n = $(this).prevAll().length;
			sortTable(f_sl, n);
		});
		$("#nm").click(function() {
			f_sl *= -1;
			var n = $(this).prevAll().length;
			sortTable(f_sl, n);
		});
		$("#nm1").click(function() {
			f_nm *= -1;
			var n = $(this).prevAll().length;
			sortTable(f_nm, n);
		});
		$("#nm2").click(function() {
			f_nm *= -1;
			var n = $(this).prevAll().length;
			sortTable(f_nm, n);
		});
		$("#nm3").click(function() {
			f_nm *= -1;
			var n = $(this).prevAll().length;
			sortTable(f_nm, n);
		});
		$("#nm4").click(function() {
			f_nm *= -1;
			var n = $(this).prevAll().length;
			sortTable(f_nm, n);
		});
		$("#nm5").click(function() {
			f_nm *= -1;
			var n = $(this).prevAll().length;
			sortTable(f_nm, n);
		});
		$("#nm6").click(function() {
			f_nm *= -1;
			var n = $(this).prevAll().length;
			sortTable(f_nm, n);
		});
		$("#nm7").click(function() {
			f_nm *= -1;
			var n = $(this).prevAll().length;
			sortTable(f_nm, n);
		});
		$("#nm8").click(function() {
			f_nm *= -1;
			var n = $(this).prevAll().length;
			sortTable(f_nm, n);
		});
		$("#nm9").click(function() {
			f_nm *= -1;
			var n = $(this).prevAll().length;
			sortTable(f_nm, n);
		});
	</script>
	<script type="text/javascript">
		function confirmstop() {

			var answer = confirm("Do you want to stop")
			if (answer) {
				window.location.href = "stopexecution"
			}

		}
	</script>

</body>
</html>



