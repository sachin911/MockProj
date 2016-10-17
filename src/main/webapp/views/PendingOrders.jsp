
<% response.addHeader("Refresh","100"); %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="com.mock.project.model.Order"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ page isELIgnored="false" %>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
     
      <li ><a href="BlockBlotter.jsp">View Blocks</a></li>
      <li class="active"><a href="PendingOrders.jsp" id="pending_orders" value="pending_orders">Pending Orders</a></li>
      
      <li><a href="TraderHistory.jsp">History</a></li>
    </ul>
  </div>

  

<div class="container">
 <div class="well">
  <h2>Pending Orders</h2>
  <p>You can select multiple orders to create a block</p>
  
  <%-- <form:form id="yourForm" action="/views/fetchOrder" method="POST" modelAttribute="functionList"> --%>
      <div class="Recommendations">
      <div style="height:300px;overflow-y:scroll;;">
    <div class="checkbox">
        
    <table class="table table-bordered" id="PendingOrderTable">
    <thead>
      <tr>
         <th></th>
        
        
        <th>SYMBOL</th>
          <th>SIDE</th>
        <th>QUANTITY</th>
          <th>LIMIT PRICE</th>
        <th>STOP PRICE</th>
        <th>OPEN PRICE</th>
          <th>ALLOCATED QTY.</th>
        <th>STATUS</th>
        <th>MANAGER</th>
        
          <th>ACCOUNT TYPE</th>
        <th>PORT ID</th>
        <th>ORDER ID</th>
      </tr>
    </thead>
        <tbody>
			<c:forEach items='${Orders}' var="Orders">     
   

			<tr>
			<td> <label><input type="checkbox" id="check" name="check" class="checkboxClick"></label></td>
			 <td ><c:out value='${Orders.symbol}'/></td> -
			 <td class="orderSide"><c:out value='${Orders.side}'/></td>
			  <td><c:out value='${Orders.qtyPlaced}'/></td>
			  <td><c:out value='${Orders.limitPrice}'/></td>
			  <td><c:out value='${Orders.stopPrice}'/></td>
			   <td><c:out value='${Orders.price}'/></td>
			      <td><c:out value='${Orders.qtyExecuted}'/></td>
			         <td class="orderStatus"><c:out value='${Orders.status}'/></td>
			            <td><c:out value='${Orders.pmId}'/></td>
			               <td><c:out value='${Orders.accountType}'/></td>
			                  <td><c:out value='${Orders.portfolioId}'/></td>
			                     <td class="orderId"><c:out value='${Orders.orderId}'/></td>
			                     
			         
			         
			         
			     
				
			</tr>
			</c:forEach>
		
        </tbody></table></div></div></div>
        <script>
    
    
    $(document).ready(function(){
    	$('#add').click(function() {
    		var data=[];
    	$('#PendingOrderTable tr').each(function()
    	{
    	if($(this).find("input[type=checkbox]").prop("checked")===true)
    	{
    		
    		
		console.log("sakjs");
    	var out1=$(this).find('.orderId').html();
    	//var out2=$(this).find('.orderSymbol').html();
    	//var out3=$(this).find('.orderStatus').html();
    	//var out4=$(this).find('.orderSide').html();
    	console.log(out1);
    	/*console.log(out2);
    	console.log(out3);
    	console.log(out4);*/
    	data.push(out1);
    	//data.push(out2);
    	//data.push(out3);
    	//data.push(out4);
    	}
    	 
    	}
    	);	
    	  console.log(data);  
    	  
    	  $.ajax({
    		  type: "POST",
    		  url: "fetchOrder5",
    		  dataType: 'json',
    		  data:"data="+data,
    		  success: function(data) {
    		    console.log("data is sent");
    		  }
    		});
    	  
    	  
    	});
    	});
    
    
    
    </script>

    <script>
    function alert_message() {
        alert("Your block has been successfully created");
        
    } 
    </script>
      <button type="button" class="btn btn-primary" onclick=alert_message() id=demo">Create Block</button>

      <button type="submit" class="btn btn-info" data-toggle="collapse" data-target="#demo" id="add">Add to Block
      </button>
      <%-- </form:form> --%>
      <div id="demo" class="collapse">
        
   The Recommendations for blocks should be displayed here
          <div class="Recommendations">
          <div style="height:200px;overflow-y:scroll;;">
           <table class="table table-bordered">
    <thead>
      <tr>
         <th></th>
        
        <th>BLOCK ID</th>
        <th>TOTAL QUANTITY</th>
        <th>EXECUTED QTY.</th>
        <th>OPEN QTY.</th>
        <th>LIMIT PRICE</th>
        <th>STOP PRICE</th>
        <th>STATUS</th>

      </tr>
    </thead>
          <tbody>
      <tr>
        <td> <label><input type="checkbox" value=""></label></td>
        <td>234</td>
        <td>1000</td>
        <td>345</td>
        <td>222</td>
        <td>12</td>
        <td>34</td>
        <td>NEW</td>
    
      </tr>
        </tbody></table>
                </div></div>
           <button type="button" class="btn btn-primary">OK</button>

</div>
    </div>
        </div>
 </div>
 </nav>
</body>
</html>



