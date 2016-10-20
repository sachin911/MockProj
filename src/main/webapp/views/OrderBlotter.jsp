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
<script type="text/javascript">
	
function edit(i){
	
	var out=document.getElementById('order_id'+i);
console.log(i)
	var message=out.innerHTML;
	console.log(message);
 $.ajax({
	                type: "POST",
	                url: "EditOrderPMc",
	                data: "message=" + message ,
	                success: function(data) {
	                 window.location.href="EditOrderPM.jsp";
	                  
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

<script>

$(document).ready(function() {

    function addRemoveClass(theRows) {

        theRows.removeClass("odd even");
        theRows.filter(":odd").addClass("odd");
        theRows.filter(":even").addClass("even");
    }
    var data=[];
    var rows = $("table#orderBlotter tr:not(:first-child)");
    var side=$(this).find('.OrderSide').html();
    data.push(side);
    addRemoveClass(rows);


    $("#selectField").on("change", function() {

        var selected = this.value;
	
        if (selected != "All") {

            rows.filter("[position=" + selected + "]").show();
            rows.not("[position=" + selected + "]").hide();
            var visibleRows = rows.filter("[position=" + selected + "]");
            addRemoveClass(visibleRows);
        } else {

            rows.show();
            addRemoveClass(rows);

        }
    });
});
</script>


<style>
.btn {
	font-size: 0.9em;
}

.optionsDiv {
	padding-bottom: 10px;
	font-weight: bold;
}
/* 
.odd{
background:#CCFFEB;
}
.even{
background:#99FFD6;
} */
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

	
	<nav class="navbar navbar-default">
      <div class="container-fluid">
         <div class="navbar-header">
            <a class="navbar-brand" href="./PMHome.jsp">Portfolio Manager</a>
         </div>
         <ul class="nav navbar-nav">
             <li><a href="./PMHome.jsp">Home</a></li>
            <li ><a href="./CreateTrade.jsp">Create Order</a></li>
            <li class="active"><a href="ViewOrderBlotter">Order Blotter</a></li>
            <li ><a href="ViewPendingOrder">Pending Orders</a></li>
            <li><a href="GeneralView">History</a></li>
         </ul>
      </div>
    </nav>
  
	<div class="container">
		<div class="well">
			<h2>Order Blotter</h2>
			<div class="panel-group" id="accordion">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="optionsDiv">
							</select> Filter By Side: <select id="selectField">
								<option>All</option>
								<option>Buy</option>
								<option>Sell</option>

							</select>
						</div>

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
							<c:forEach items='${Orders}' var="Orders" varStatus="loop">
								<tr position='${Orders.side}'>
									<td><label><input type="checkbox" id="checkbox"
											name="check"></label></td>
									<td class="OrderId" id="order_id${loop.index +1}"><c:out
											value='${Orders.orderId}' /></td>
									<td><c:out value='${Orders.symbol}' /></td>
									<td><c:out value='${Orders.side}' /></td>
									<td class="OrderStatus"><c:out value='${Orders.status}' /></td>
									<td><c:out value='${Orders.qtyPlaced}' /></td>
									<td><c:out value='${Orders.orderType}' /></td>
									<td><c:out value='${Orders.accountType}' /></td>
									<td>
										<button id="edit${loop.index +1}" type="button"
											class="btn btn-warning" onclick="edit(${loop.index +1})">Edit</button>
									</td>
									<td><button id="orderId1-cancel${loop.index +1}"
											type="button" class="btn btn-danger"
											onclick="cancel(${loop.index +1})">Cancel</button></td>
								</tr>
							</c:forEach>
						</table>
						<button type="submit" class="btn btn-info" data-toggle="collapse"
							id="check" onclick="send()">Send to Trader</button>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>