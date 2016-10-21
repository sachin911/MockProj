
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@ page isELIgnored="false"%>

	<link rel="stylesheet" href="https://rawgit.com/Govind-jha/online-resources/master/pm-history.css">

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
			
			<label style="margin-left:50px; font-size:18px;" >Filter by Side: </label>      
			<select class="filter" style="font-size:18px;">
			   	<option>All</option>
			    <option>Buy</option>
			    <option>Sell</option>
			</select> 
		</h2>
		<div id="pending-order-container">
			
			<div class="row well" id="pending-order-headers">
				<div class="col col-sm-1">Symbol</div>
				<div class="col col-sm-1">Side</div>
				<div class="col col-sm-1 col-centered">Type</div>
				<div class="col col-sm-1">Qualifier</div>
				<div class="col col-sm-1">Trader</div>
				<div class="col col-sm-1">Quantity</div>
				<div class="col col-sm-1">Stop</div>
				<div class="col col-sm-1">Limit</div>
				<div class="col col-sm-1">Status</div>
				<div class="col col-sm-1"><center>Account Type</center></div>
				<div class="col col-sm-2"><center>Order Date</center></div>
			</div>
			
			<div class="row well" id="pending-order-data" overflow-y="scrollable">
				<c:forEach items='${Orders}' var="Orders" varStatus="loop">   
					<div class="row " id="${Orders.orderId}-data" position='${Orders.side}'>
						<div class="col col-sm-1"><c:out value='${Orders.symbol}'/> </div>
	                    <div class="side col col-sm-1" id="side-${Orders.orderId}"><c:out value='${Orders.side}'/></div>
	                    <div class="col col-sm-1 col-centered"><c:out value='${Orders.orderType}'/></div>
	                    <div class="col col-sm-1"><c:out value='${Orders.qualifier}'/></div>
	                    <div class="col col-sm-1"><c:out value='${Orders.traderId}'/></div>
	                    <div class="col col-sm-1"><c:out value='${Orders.qtyPlaced}'/></div>
	                    <div class="col col-sm-1"><c:out value='${Orders.stopPrice}'/></div>
	                    <div class="col col-sm-1"><c:out value='${Orders.limitPrice}'/></div>
	                    <div class="OrderStatus col col-sm-1"><c:out value='${Orders.status}'/></div>
	                    <div class="OrderAccountType col col-sm-1"><center><c:out value='${Orders.accountType}'/></center></div>
	                    <div class="OrderStatus col col-sm-2"><center><c:out value='${Orders.orderDate}'/></center></div>
	               </div>
            </c:forEach>		
			</div>
	</div>

</body>

<script type="text/javascript">
	
var ids = []; 
$( document ).ready(function() {
	   $('.side').each(function() {
 	   var innerHtml = $(this).attr('id').split("-");
        var id = innerHtml[1];
   	   ids.push(id);
	   });
});

 //filter trade.
 $( ".filter" ).change(function () {
   	var filterBy = $(".filter").find(":selected").text().trim().toLowerCase();

     
     if(filterBy == "all"){	
 		 $.each( ids, function( index, value ){
               $("#"+value+"-data").show();                     
        });
 		 return;
 	} 
       
     $.each( ids, function( index, value ){
      	console.log("inside here --" + value);
      	$("#"+value+"-data").hide();
     	if($("#side-" + value).text().trim().toLowerCase() == filterBy){
            $("#"+value+"-data").show();
         }
     });
                
     
 });       
             
</script>


</html>