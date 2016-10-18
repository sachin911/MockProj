<%@page import="java.util.ArrayList"%>
<%@page import="org.springframework.context.support.AbstractApplicationContext"%>
<% response.addHeader("Refresh","10"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
	<%@page import="com.mock.project.config.AppConfig"%>
	<%@page import="org.springframework.context.annotation.AnnotationConfigApplicationContext"%>
	
	<%@ page import="java.util.List" %>
    <%@ page import="com.mock.project.model.Order"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<script>
    function send(){
    	var data=[];
 		var status=[];	 
    	 $('#orderBlotter tr').each(function(){
    		    	if($(this).find("input[type=checkbox]").prop("checked")===true)
    		    	{
    		    		var out1=$(this).find('.OrderId').html();
    		    		var out3=$(this).find('.OrderStatus').html();data.push(out1);status.push(out3);
    		    	}});
    	 console.log(data);
    	 $.ajax({
   		  type: "POST",
   		  url: "SendToTrader",
   		  data: "data="+data ,
   		  success: function(data) {
   		    console.log("data is sent");
   		  },
   	  		error:function(jqXHR, textStatus, errorThrown) {
   	  		  console.log(textStatus, errorThrown);
   	  		
     		  }
   		});
     }
    
    </script>
<title>Order Blotter</title>
</head>
<body>

<%-- <%
	AbstractApplicationContext container=new AnnotationConfigApplicationContext(AppConfig.class);
	container.registerShutdownHook();
	PMSendToTrader pmSendToTraderService= (PMSendToTrader)container.getBean("traderservice");
	List<Order> orderList=new ArrayList();
		
	PMSendToTraderImpl pMSendToTraderImpl=new PMSendToTraderImpl();
	orderList=pMSendToTraderImpl.display();
	%>  --%>
 
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Portfolio Manager</a>
			</div>
			<ul class="nav navbar-nav">
				<li ><a href="PMHome.jsp">Home Page</a></li>		
				<li><a href="CreateTrade.jsp">Create Trader</a></li>
				<li class="active"><a href="ViewOrderBlotter">Order Blotter</a></li>
				<li><a href="PMHistory.jsp">History</a></li>
			</ul>
		</div>
		<div class="container">
			<div class="well">
				<h2>Order Blotter</h2>
				<div class="panel-group" id="accordion">
					<div class="panel panel-default">
						<div class="panel-heading">
						
						
						<!--  <form action="SendToTrader" method="POST" >  -->
						
							<table class="table" id="orderBlotter">

								<tr>
									<th></th>
									<th>Order ID</th>
									<th>Symbol</th>
									<th>Side</th>
									<th>Status</th>
									<th>Quantity</th>
									<th>Order Type</th>
									<th>Account Type</th>
									<th></th>
									<th></th>
								</tr>
								
								
								 <c:forEach items='${Orders}'  var="Orders">     
    <c:forEach var="listValue" items="${lists}">
				<li>${listValue}</li>
			</c:forEach>

			<tr>
			 <td> <label><input type="checkbox" id="checkbox" name="check" ></label></td>
			 <td class="OrderId"><c:out value='${Orders.orderId}'/></td> 
			 <td><c:out value='${Orders.symbol}'/></td>
			  <td><c:out value='${Orders.side}'/></td>
			  <td class="OrderStatus"><c:out value='${Orders.status}'/></td>
			  <td><c:out value='${Orders.qtyPlaced}'/></td>
			   <td><c:out value='${Orders.orderType}'/></td>
			   <td><c:out value='${Orders.accountType}'/></td>

			</tr> 
			
			</c:forEach> 
			
			
			
				</table>
						 <!-- <input type="submit" class="btn btn-default" value="Send to Trader" id="check"/>	
					</form>		 -->		 
							 
							  <button type="submit" class="btn btn-info" data-toggle="collapse" id="check" onclick="send()">Send to Trader
      </button>
							  
							
							

					
							
						<!-- 	</form> -->
							
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</nav>
</body>
</html>