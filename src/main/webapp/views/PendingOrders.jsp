<% response.addHeader("Refresh","100"); %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="com.mock.project.model.Order"%>
    <%@ page import="com.mock.project.model.Block"%>
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
      <a class="navbar-brand" href="#">Execution Trader</a>
    </div>
    <ul class="nav navbar-nav">
     
      <li ><a href="PopulateBB">View Blocks</a></li>
      <li class="active"><a href="updateTable" id="pending_orders" value="pending_orders">Pending Orders</a></li>
      
      <li><a href="PopulateTraderHistory">History</a></li>
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
    		  type: "GET",
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

		        </tbody></table></div></div></div>
        


    <script>
    
    
    $(document).ready(function(){
    	$('#createBlock').click(function() {
    		var data=[];
    	$('#PendingOrderTable tr').each(function()
    	{
    	if($(this).find("input[type=checkbox]").prop("checked")===true)
    	{
    		
    		
		console.log("sakjs");
    	var out=$(this).find('.orderId').html();
    	console.log(out);
    	data.push(out);
    	}
    	 
    	}
    	);	
    	  console.log(data);  
    	  
    	  $.ajax({
    		  type: "POST",
    		  url: "fetchOrder2",
    		  dataType: 'json',
    		  data:"data="+data,
    		  success: function(data) {
    		    console.log("data is sent");
    		  }
    		});
    	  
    	  
    	});
    	
    	
    	
    	$('#sub').click(function() {
    		console.log("teststs");
    		var data=[];
    	$('#recommendedBlocks tr').each(function()
    	{
    	if($(this).find("input[type=checkbox]").prop("checked")===true)
    	{
    		
    		
    	console.log("sakjdsaass");
    	var out=$(this).find('.blockid').html();
    	console.log(out);
    	data.push(out);
    	}
    	 
    	}
    	);	
    	  console.log(data);  
    	  
    	  $.ajax({
    		  type: "GET",
    		  url: "fetchOrder6",
    		  dataType: 'json',
    		  data:"data="+data,
    		  success: function(data) {
    		    console.log("data is sent");
    		  }
    		});
    	  
    	  
    	});

    	});
    
    
    
    </script>
      <button type="button" class="btn btn-primary" id="createBlock">Create Block</button>

      <button type="submit" class="btn btn-info" data-toggle="collapse" data-target="#demo" id="add">Add to Block
      </button>
      <%-- </form:form> --%>
      <script>
      
      function LoadData() {
    var myDataTable = $("#recommendedBlocks").jsp("<table><thead></thead><tbody></tbody></table>");
    $("table",myDataTable).dataTable({});
}
$(document).ready(function() {
    $("#recommendedBlocks").click(LoadData);
    LoadData();
});
</script>
       <div id="demo" class="collapse"> 
        
   The Recommendations for blocks should be displayed here
          <div class="Recommendations">
          <div style="height:200px;overflow-y:scroll;;">
           <table class="table table-bordered" id="recommendedBlocks">
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
      <c:forEach items='${Blocks}' var="Blocks">   
        
			<tr>
			
			  <td> <label><input type="checkbox" id="checks" name="checks" class="checkboxClicks"></label></td>
			  <td class="blockid"><c:out value='${Blocks.blockId}'/></td>
		 <td><c:out value='${Blocks.total_quantity}'/></td>
			  <td><c:out value='${Blocks.executed_quantity}'/></td>
			  <td><c:out value='${Blocks.total_quantity-blocks.executed_quantity}'/></td>
			  <td><c:out value='${Blocks.limit_price}'/></td>
			  <td><c:out value='${Blocks.stop_price}'/></td>
			  <td><c:out value='${Blocks.status}'/></td> 
		
			</tr>
			</c:forEach> 
        </tbody></table>
                </div></div>
          <button type="submit" class="btn btn-info" id="sub">OK
      </button>

</div>


 <!-- <script>
    
    
    $(document).ready(function(){
    	console.log(":asd")
    	$('#ok').click(function() {
    		console.log(":asd")
    		var data1=0;
    	$('#recommendedBlocks tr').each(function()
    	{
    	if($(this).find("input[type=checkbox]").prop("checked")===true)
    	{
    		
    		
		console.log("hi");
    	var data1=$(this).find('.blockid').html();
    	//var out2=$(this).find('.orderSymbol').html();
    	//var out3=$(this).find('.orderStatus').html();
    	//var out4=$(this).find('.orderSide').html();
    	console.log(data1);
    	/*console.log(out2);
    	console.log(out3);
    	console.log(out4);*/
    	
    	//data.push(out2);
    	//data.push(out3);
    	//data.push(out4);
    	}
    	 
    	}
    	);	
    	  console.log(data1);  
    	  
    	  $.ajax({
    		  type: "GET",
    		  url: "fetchOrder6",
    		  dataType: 'json',
    		  data:"data1="+data1,
    		  success: function(data1) {
    		    console.log("data is sent");
    		  }
    		});
    	  
    	  
    	});
    	});
    
    
    
    </script> -->
    </div>
       </div> 
 </div>
 </nav>
</body>
</html>



