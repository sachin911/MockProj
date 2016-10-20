<%@page import="com.sapient.config.AppConfig"%>
<%@page import="com.sapient.service.SecuritiesService"%>
<%@page
	import="org.springframework.context.annotation.AnnotationConfigApplicationContext"%>
<%@page
	import="org.springframework.context.support.AbstractApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="com.sapient.dao.* ,com.sapient.model.*, java.util.List ,java.util.ArrayList"%>
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
<script  type="text/javascript"  src="/path/to/jquery-latest.js"></script>
 
<script  type="text/javascript"  src="/path/to/jquery.tablesorter.js"></script>
 
</head>

<body>
<style>
li:last-child {
	float: right;
}</style>

	<!-- <style>
tbody {
    height: 200px;
    display: inline-block;
    overflow: scroll;
}
thead {
    display: inline-block;
    width: 100%;
    height: 20px;
}
</style> -->
	<%-- <%
		List<Securities> securityList = new ArrayList<>();
		SecuritiesDAO dao = new SecuritiesDAOImpl();
		securityList = dao.findAll();
	%> --%>
	<%
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();
		SecuritiesService securityService = (SecuritiesService) container.getBean("securitiesService");
		List<Securities> securityList = new ArrayList();

		securityList = securityService.findALL();
	%>
	<div class="container">
		<h3>Broker</h3>
		<ul class="nav nav-pills">
			<li><a href="BrokerMainScreen.jsp">Home</a></li>
			<li class="active"><a href="ConfigureSecurity.jsp">Configure</a></li>
			<li><a href="ViewFills.jsp">View Fills</a></li>
			<li><a href="Login.jsp">Logout</a></li>
			<li><a onclick="confirmstop()">Stop</a></li>

		</ul>
	</div>
	<div class="container" style="height: 600px; overflow-y: scroll;">
		<table id="securities" style="width: 100%" class="table table-striped"
			height: 100px;
  overflow-y: scroll>
			<thead>
				<tr>
					   
					<th id="nm" onmousedown="this.style.background='#AAA'" onmouseup="this.style.background='#FFF'">Ticker</th>
					   
					<th id="nme" onmousedown="this.style.background='#AAA'" onmouseup="this.style.background='#FFF'">Name</th>
					   
					<th id="sl" onmousedown="this.style.background='#AAA'" onmouseup="this.style.background='#FFF'">Last
						Traded Price</th>
					<th id="sl1" onmousedown="this.style.background='#AAA'" onmouseup="this.style.background='#FFF'">Maximum price Spread(%)</th>
					<th id="sl2" onmousedown="this.style.background='#AAA'" onmouseup="this.style.background='#FFF'">Maximum executions</th>
					<th id="sl3" onmousedown="this.style.background='#AAA'" onmouseup="this.style.background='#FFF'">Maximum Interval</th>
					<th id="sl4" onmousedown="this.style.background='#AAA'" onmouseup="this.style.background='#FFF'">Max Probable(%)</th>  
				</tr>
			</thead>
			<tbody>
				<%
					for (Securities security : securityList) {
				%>
				<tr>
					<td><%=security.getSecurity_symbol()%></td>    
					<td><%=security.getSecurity_name()%></td>    
					<td><%=security.getLast_trade_price()%></td>
					<td><%=security.getMax_price_spread()%></td>
					<td><%=security.getMax_executions()%></td>
					<td><%=security.getMax_interval()%></td>
					<td><%=security.getProb_percent()%></td>
					<td><button type="button" class="btn btn-info btn-lg"
							data-toggle="modal" data-target="#myModal"
							onclick=GetSecuritiesData(this) name="Editbutton">Edit</button></td>

				</tr>
				<%
					}
				%>

				<%--  <% for(int i=1;i<=10;i++){ %>

			<tr>
				<td id="ticker">APPL</td>
				<td id="name">Apple</td>
				<td id="lastTradedPrice">890</td>
				<td id="MaxPriceSpread">20</td>
				<td id="MaximumExecutions">200</td>
				<td id="MaximumInterval">60</td>
				<td id="MaxProbable"><%=i%></td>
				<td><button type="button" class="btn btn-primary"
						data-toggle="modal" data-target="#myModal">edit</button></td>
			</tr>
		
			<!-- <tr>
				<td id="ticker">APPL</td>
				<td id="name">Apple</td>
				<td id="last traded price">890</td>
				<td id="">20</td>
				<td id="maximum executions">200</td>
				<td id="maximum Interval">60</td>
				<td id="lst probable">10</td>
				<td><button type="button" class="btn btn-primary"
						data-toggle="modal" data-target="#myModal">edit</button></td>
			</tr> -->
			<%} %>
 --%>
			</tbody>
			
		<!-- 	<button style="float: right" type="button"
				class="btn btn-info btn-lg" data-toggle="modal"
				data-target="#myModal" name="Addbutton">Add</button> -->
		</table>
	</div>
	<div class="container">
		<form method="post" action="">
			<button type="button" class="btn btn-info btn-lg"
							data-toggle="modal" data-target="#myModal1"
							 name="Addbutton">Add</button></form>
							 </div>
							 
							 
							 
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<!-- <h4 class="modal-title">Edit configuration of Securities</h4> -->
				</div>
				<div class="modal-body">
					<p>
					<form method="post" class="container" action="editSecurity">

						<!-- CSS -->
						<style>
.myForm {
	font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif, cursive;
	font-size: 0.8em;
	width: 30em;
	padding: 1em;
	border: 1px solid #ccc;
}

.myForm table {
	width: 30cm;
}

.myForm * {
	box-sizing: border-box;
}

.myForm fieldset {
	border: none;
	padding: 1;
}

.myForm legend, .myForm label {
	padding: 1;
	font-weight: bold;
}

.myForm label.choice {
	font-size: 0.9em;
	font-weight: normal;
}

.myForm label {
	text-align: left;
	display: block;
}

.myForm input[type="text"], .myForm input[type="tel"], .myForm input[type="email"],
	.myForm input[type="datetime-local"], .myForm select, .myForm textarea
	{
	float: right;
	width: 60%;
	border: 1px solid #ccc;
	font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif;
	font-size: 0.9em;
	padding: 5em;
}

.myForm textarea {
	height: 100px;
}

.myForm input[type="radio"], .myForm input[type="checkbox"] {
	margin-left: 40%;
}

.myForm button {
	padding: 1em;
	border-radius: 0.5em;
	background: #eee;
	border: none;
	font-weight: bold;
	margin-left: 40%;
	margin-top: 1.8em;
}

.myForm button:hover {
	background: #ccc;
	cursor: pointer;
}
</style>

					
						
							<div allign="centre">

								<form class="container" method="post" action="editSecurity">
									<fieldset>
										<legend>Edit Configuration of Securities</legend>

										<table style="height: 293px;" width="401">
											<tbody>
												<tr>
													<td style="text-align: center;">Ticker</td>
													<td style="text-align: center;"><input id="ticker"
													readonly name="ticker" type="text" placeholder="Ticker" /></td>
												</tr>
												<tr>
													<td style="text-align: center;">Name</td>
													<td style="text-align: center;"><input id="Symbol"
														readonly name="Symbol name" type="text"
														 placeholder="Symbol Name" /></td>
												</tr>
												<tr>
													<td style="text-align: center;">Last Traded Price</td>
													<td style="text-align: center;"><input
														id="Last traded Price" name="Last traded Price"
														type="Number" step="any"  /></td>
												</tr>
												<tr>
													<td style="text-align: center;">Maximum Price Spread</td>
													<td style="text-align: center;"><input
														id="Maximum Price Spread " name="Maximum Price Spread "
														type="Number" step="any"  /></td>
												</tr>
												<tr>
													<td style="text-align: center;">Maximum exection per
														order</td>
													<td style="text-align: center;"><input
														id="Maximum Executions Per Order "
														name="Maximum Executions Per Order " type="Number"
														 /></td>
												</tr>
												<tr>
													<td style="text-align: center;">Maximum interval</td>
													<td style="text-align: center;"><input
														id="Maximum Interval" name="Maximum Interval "
														type="Number"  /></td>
												</tr>
												<tr>
													<td style="text-align: center;">Maximum Probable
														Percentage</td>
													<td style="text-align: center;"><input
														id="Maximum Probable Percentage"
														name="Maximum Probable Percentage" type="Number"
														step="any"  /></td>
												</tr>
												<tr>
													<td></td>
													<td style="text-align: center;"><input type="submit"
														class="btn btn-primary" value="save" /></td>
												</tr>
												</tbody>
												</table>
												</fieldset>
												</form>
												</div>
												</form>
												</div>
												</div>
												</div>
												<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
			
			
	<div id="myModal1" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<!-- <h4 class="modal-title">Edit configuration of Securities</h4> -->
				</div>
				<div class="modal-body">
					<p>
					<form method="post" class="container" action="addsecurity">

						<!-- CSS -->
						<style>
.myForm {
	font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif, cursive;
	font-size: 0.8em;
	width: 30em;
	padding: 1em;
	border: 1px solid #ccc;
}

.myForm table {
	width: 30cm;
}

.myForm * {
	box-sizing: border-box;
}

.myForm fieldset {
	border: none;
	padding: 1;
}

.myForm legend, .myForm label {
	padding: 1;
	font-weight: bold;
}

.myForm label.choice {
	font-size: 0.9em;
	font-weight: normal;
}

.myForm label {
	text-align: left;
	display: block;
}

.myForm input[type="text"], .myForm input[type="tel"], .myForm input[type="email"],
	.myForm input[type="datetime-local"], .myForm select, .myForm textarea
	{
	float: right;
	width: 60%;
	border: 1px solid #ccc;
	font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif;
	font-size: 0.9em;
	padding: 5em;
}

.myForm textarea {
	height: 100px;
}

.myForm input[type="radio"], .myForm input[type="checkbox"] {
	margin-left: 40%;
}

.myForm button {
	padding: 1em;
	border-radius: 0.5em;
	background: #eee;
	border: none;
	font-weight: bold;
	margin-left: 40%;
	margin-top: 1.8em;
}

.myForm button:hover {
	background: #ccc;
	cursor: pointer;
}
</style>

					
						
							<div allign="centre">

								<form class="container" method="post" action="addsecurity">
									<fieldset>
										<legend>Edit Configuration of Securities</legend>

										<table style="height: 293px;" width="401">
											<tbody>
												<tr>
													<td style="text-align: center;">Ticker</td>
													<td style="text-align: center;"><input id="Ticker2"  name="Ticker2"
														type="text" placeholder="Ticker" /></td>
												</tr>
												<tr>
													<td style="text-align: center;">Name</td>
													<td style="text-align: center;"><input id="SymbolName"
														name="SymbolName" type="text"
														 placeholder="Symbol Name" /></td>
												</tr>
												<tr>
													<td style="text-align: center;">Last Traded Price</td>
													<td style="text-align: center;"><input
														id="LastTradedPrice" name="LastTradedPrice"
														type="Number" step="any"  /></td>
												</tr>
												<tr>
													<td style="text-align: center;">Maximum Price Spread</td>
													<td style="text-align: center;"><input
														id="MaximumPriceSpread " name="MaximumPriceSpread"
														type="Number" step="any"  /></td>
												</tr>
												<tr>
													<td style="text-align: center;">Maximum Exection per
														order</td>
													<td style="text-align: center;"><input
														id="MaximumExecutionsPerOrder "
														name="MaximumExecutionsPerOrder" type="Number"
														 /></td>
												</tr>
												<tr>
													<td style="text-align: center;">Maximum interval</td>
													<td style="text-align: center;"><input
														id="MaximumInterval" name="MaximumInterval"
														type="Number" /></td>
												</tr>
												<tr>
													<td style="text-align: center;">Maximum Probable
														Percentage</td>
													<td style="text-align: center;"><input
														id="MaximumProbablePercentage"
														name="MaximumProbablePercentage" type="Number"
														step="any"  /></td>
												</tr>
												<tr>
													<td></td>
													<td style="text-align: center;"><input type="submit"
														class="btn btn-primary" value="Add" /></td>
												</tr>
												</tbody>
												</table>
												</fieldset>
												</form>
												</div>
												</form>
												</div>
												</div>
												</div>
												<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>		
				
	
	<script>
		function GetSecuritiesData(button) {
			var rown = button.parentNode.parentNode.rowIndex;
			/* var u=document.getElementById("securities").rows[rown].cells[0].innerHTML; */
			//alert(u);
			/* 	document.Removeform.action="RemoveServlet?uname="+u;
			 //alert(document.Removeform.action);
			 window.location.href="RemoveServlet?uname="+u; */

			//document.Removeform.submit();
			document.getElementById("ticker").value = document
					.getElementById("securities").rows[rown].cells[0].innerHTML;
			document.getElementById("Symbol").value = document
					.getElementById("securities").rows[rown].cells[1].innerHTML;
			document.getElementById("Last traded Price").value = document
					.getElementById("securities").rows[rown].cells[2].innerHTML;
			document.getElementById("Maximum Price Spread ").value = document
					.getElementById("securities").rows[rown].cells[3].innerHTML;
			document.getElementById("Maximum Executions Per Order ").value = document
					.getElementById("securities").rows[rown].cells[4].innerHTML;
			document.getElementById("Maximum Interval").value = document
					.getElementById("securities").rows[rown].cells[5].innerHTML;
			document.getElementById("Maximum Probable Percentage").value = document
					.getElementById("securities").rows[rown].cells[6].innerHTML;
		}
	</script>
	<script>
		function sortTable(f, n) {
			var rows = $('#securities tbody  tr').get();

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
				$('#securities').children('tbody').append(row);
			});
		}
		var f_sl = 1;
		var f_nm = 1;
		$("#sl").click(function() {
			f_sl *= -1;
			var n = $(this).prevAll().length;
			sortTable(f_sl, n);
		});
		$("#sl1").click(function() {
			f_sl *= -1;
			var n = $(this).prevAll().length;
			sortTable(f_sl, n);
		});
		$("#sl2").click(function() {
			f_sl *= -1;
			var n = $(this).prevAll().length;
			sortTable(f_sl, n);
		});
		$("#sl3").click(function() {
			f_sl *= -1;
			var n = $(this).prevAll().length;
			sortTable(f_sl, n);
		});
		$("#sl4").click(function() {
			f_sl *= -1;
			var n = $(this).prevAll().length;
			sortTable(f_sl, n);
		});
		$("#nme").click(function() {
			f_sl *= -1;
			var n = $(this).prevAll().length;
			sortTable(f_sl, n);
		});
		$("#nm").click(function() {
			f_nm *= -1;
			var n = $(this).prevAll().length;
			sortTable(f_nm, n);
		});
	</script>
	<script type="text/javascript">
		function confirmstop() {

			var answer = confirm("Do you want to stop")
			if (answer) {
				window.location.href = "Login.jsp"
			}

		}
	</script>
</body>
</html>
												