<%@page import="com.sapient.model.ViewFills"%>
<%@page import="com.sapient.service.ViewFillsService"%>
<%@page import="com.sapient.config.AppConfig"%>
<%@page import="com.sapient.service.BrokerService"%>
<%@page import="org.springframework.context.annotation.AnnotationConfigApplicationContext"%>
<%@page import="org.springframework.context.support.AbstractApplicationContext"%>
<%@page import="com.sapient.dao.* ,com.sapient.model.Block, java.util.List ,java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
table {
    border-collapse: separate;
    border-spacing: 0 1em;
    
}

li:last-child {
	float: right;
}</style>

</head>
<body>

	<%
	AbstractApplicationContext container=new AnnotationConfigApplicationContext(AppConfig.class);
	container.registerShutdownHook();
 		BrokerService brokerService= (BrokerService)
 		container.getBean("brokerService");
	
		ViewFillsService viewFillsService=(ViewFillsService)container.getBean("viewfillsservice");
		List<ViewFills> viewFillsList=new ArrayList();
		viewFillsList=viewFillsService.findALL();
		
	%> 
<div class="container">
  <h3>Broker</h3>
  <ul class="nav nav-pills">
    <li ><a href="BrokerMainScreen.jsp">Home</a></li>
    <li ><a href="ConfigureSecurity.jsp">Configure</a></li>
    <li class="active"><a href="ViewFills.jsp">View Fills</a></li>
         <li><a href="Login.jsp">Logout</a></li>
         <li><a onclick="confirmstop()">Stop</a></li>
  </ul>
  <div style="height:300px;overflow-y:scroll;;">
  <table class="table table-striped" id="dataTable">
			<thead class="thead-inverse">
				<tr>
				<th onmouseover="this.style.background='#AAA'" id="nm">Block Id</th>    
				<th>Ticker</th>    
				<!-- <th>Name</th> -->
				<th>Side</th>
				<th>Type</th>
				<th>Stop Price</th>
				<th>Limit Price</th>
				<th>Executed Price</th>
				<th>Total Quantity</th>
				<th>Remaining Quantity</th>
				<th>Executed Quantity</th>
				<th>Executed Date</th>
				<th>Status</th>  
			</tr>
			</thead>
			<tbody>
				<%
					for(ViewFills views:viewFillsList) {
						Block block=brokerService.findByPrimaryKey(views.getBlock_Id());
						System.out.println(block);
				%>
				<tr>
				<td><%=views.getBlock_Id() %></td>
				<td><%=block.getSymbol() %></td>
				<%-- <td><%=blocks.get %></td> --%>
				<td><%=block.getSide() %></td>
				<td><%=block.getType() %></td>
				<td><%=block.getStop_price() %></td>
				<td><%=block.getLimit_price() %></td>
				<td><%=views.getExecutedPrice()%></td>
				<td><%=block.getTotal_quantity()%></td>
				<td><%=views.getRemainingQty()%></td>
				<td><%=views.getQtyExecuted() %></td>
				<td><%=views.getExecutedDate() %></td>
				<td><%=block.getStatus()%></td>				
			</tr>
				<%
					}
				%>
				</div>
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
			</tbody> -->

		</table>
</div >
</div>
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
			f_nm *= -1;
			var n = $(this).prevAll().length;
			sortTable(f_nm, n);
		});
		
		
	</script>
	<script type="text/javascript">
	function confirmstop()
	{
		
		var answer=confirm("Do you want to stop")
		if(answer){
		window.location.href="Login.jsp"	
		}
		
	}</script>

</body>
</html>



