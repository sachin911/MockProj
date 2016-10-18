<%@page import="com.sapient.config.AppConfig"%>
<%@page import="com.sapient.service.SecuritiesService"%>
<%@page import="org.springframework.context.annotation.AnnotationConfigApplicationContext"%>
<%@page import="org.springframework.context.support.AbstractApplicationContext"%>
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
</head>
<body>
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
	AbstractApplicationContext container=new AnnotationConfigApplicationContext(AppConfig.class);
	container.registerShutdownHook();
 SecuritiesService securityService= (SecuritiesService)
 container.getBean("securitiesService");
	List<Securities> securityList=new ArrayList();
		
	securityList=securityService.findALL();
	%> 
	<div class="container">
		<h3>Broker</h3>
		<ul class="nav nav-pills">
			<li><a href="BrokerMainScreen.jsp">Home</a></li>
			<li class="active"><a href="ConfigureSecurity.jsp">Configure</a></li>
			<li><a href="ViewFills.jsp">View Fills</a></li>
			<li><a href="Login.jsp">Logout</a></li>

		</ul>
	</div>
	<div class="container" style="height:300px;overflow-y:scroll;;">
		<table  id="securities" style="width: 100%"  class="table table-striped"  height: 100px;
  overflow-y: scroll>

			<tr>
				   
				<th>Ticker</th>    
				<th>Name</th>    
				<th>Last Traded Price</th>
				<th>Maximum price Spread(%)</th>
				<th>Maximum executions</th>
				<th>Maximum Interval</th>
				<th>Max Probable(%)</th>  
			</tr>
			
			<% for(Securities security:securityList) { %>
  <tr>
    <th><%=security.getSecurity_symbol()%></th>
    <th><%=security.getSecurity_name() %></th>
    <th><%=security.getLast_trade_price() %></th>
    <th><%=security.getMax_price_spread() %></th>
    <th><%=security.getMax_executions() %></th>
    <th><%=security.getMax_interval() %></th>
    <th><%=security.getProb_percent() %></th>
    <td ><button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" onclick=GetSecuritiesData(this) name="Editbutton">edit</button></td>
  </tr>
  <% } %>
 
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
 --%>		</table>
	</div>
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Edit configuration of Securities</h4>
				</div>
				<div class="modal-body">
					<p>
					<form method="post" class="container">

						<!-- CSS -->
						<style>
.myForm {
	font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif;
	font-size: 0.8em;
	width: 30em;
	padding: 1em;
	border: 1px solid #ccc;
}

.myForm * {
	box-sizing: border-box;
}

.myForm fieldset {
	border: none;
	padding: 0;
}

.myForm legend, .myForm label {
	padding: 0;
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
	padding: 0.3em;
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

						</head>
						<body>
							<div allign="centre">
							<form class="myForm" method="post" action="editSecurity">

								<p>
									<label>Ticker <input type="text"  allign=right"name="ticker" id="ticker1" placeholder="Ticker";
										disabled>
									</label>
								</p>

								<p>
									<label>Name <input type="text" allign=right" name="Symbol name" placeholder="Symbol Name"  id="Symbol" value="Google" disabled>
									</label>
								</p>

								<p>
									<label>Last traded Price <input type="Number" allign=right" name="Last traded Price" id="Last traded Price" value="120.0">
									</label>
								</p>
								<p>
									<label>Maximum Price Spread <input type="Number" allign=right" name="Maximum Price Spread " id="Maximum Price Spread "value="12">
									</label>
								</p>
								<p>
									<label>Maximum Executions Per Order <input type="Number" allign=right" name="Maximum Executions Per Order " id="Maximum Executions Per Order " value="100">
									</label>
								</p>
								<p>
									<label>Maximum Interval<input type="Number" allign=right" name="Maximum Interval " id="Maximum Interval" value="100">
									</label>
								</p>
								<p>
									<label>Maximum Probable Percentage<input type="Number" allign=right" name="Maximum Probable Percentage" id="Maximum Probable Percentage" value="10">
									</label>
								</p>

								<p>
									<input type="submit" class="btn btn-primary" value="Save"/></input>
								</p>

							</form>
</div>
						</body>
</html>
</form>
</p>
</div>
<div class="modal-footer">
	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
</div>
</div>

</div>
</div>
<script>
function GetSecuritiesData(button)
{
	var rown = button.parentNode.parentNode.rowIndex;
	/* var u=document.getElementById("securities").rows[rown].cells[0].innerHTML; */
	//alert(u);
/* 	document.Removeform.action="RemoveServlet?uname="+u;
	//alert(document.Removeform.action);
	window.location.href="RemoveServlet?uname="+u; */
	
	//document.Removeform.submit();

document.getElementById("ticker1").value =document.getElementById("securities").rows[rown].cells[0].innerHTML;
document.getElementById("Symbol").value =document.getElementById("securities").rows[rown].cells[1].innerHTML;
document.getElementById("Last traded Price").value =document.getElementById("securities").rows[rown].cells[2].innerHTML;
document.getElementById("Maximum Price Spread ").value =document.getElementById("securities").rows[rown].cells[3].innerHTML;
document.getElementById("Maximum Executions Per Order ").value =document.getElementById("securities").rows[rown].cells[4].innerHTML;
document.getElementById("Maximum Interval").value =document.getElementById("securities").rows[rown].cells[5].innerHTML;
document.getElementById("Maximum Probable Percentage").value =document.getElementById("securities").rows[rown].cells[6].innerHTML;
}
</script>
</body>
</html>



