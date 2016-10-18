<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	 <%@ page import="java.util.List,com.mock.project.model.Order" %>
<!DOCTYPE html>
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
    <title>Test Page</title>
</head>
<body>
<style>
	th {
	
	color: blue;
	}

td {
	width : 218px;
	}

</style>
    <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Execution Trader</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="PopulateBB">View Blocks</a></li>

      <li><a href="updateTable">Pending Orders</a></li>

      <li><a href="PopulateTraderHistory">History</a></li> 

    </ul>
  </div>
    <div class="container">
 
  <div class="well">
      <h2>Block Blotter</h2>
 
 
<%int i=0; %>
  <div class="panel-group" id="accordion">

   <!--  <div class="panel panel-default">
      <div class="panel-heading">  -->
        <table class="table" > 

             
            <thead>
              <th></th>
                 <th>ID</th>
                 <th>Symbol</th>
                 <th>Side</th>
                 <th>Time stamp</th>
                 
             </thead>  
             </table>
 <table class="Ordertable">
     <%int j=0;%>

           <c:forEach items='${Blocks}' var="Orders" varStatus="Loop">   
           <%List<Order> l =(List<Order>) request.getAttribute("Blocks"); %>
      <!--          <div class="panel panel-default">
      <div class="panel-heading">  -->
      
             <tr id = "getId();">
                 <td><input type="checkbox"/></td>
                  <td class="orderId"><c:out  value='${Orders.orderId}'/></td>

                <td><c:out  value='${Orders.symbol}'/></td>
               <td><c:out  value='${Orders.side}'/></td>
                <td><c:out  value='${Orders.orderDate}'/></td>
                 
               
                 <td><button id ="detailsButton" class="btn btn-default" onclick="toggleDetails('${Loop.index +1}')">Details</button></td>
                  <td><button id ="editButton" class="btn btn-default" onclick="toggleEdit('${Loop.index +1}')">Edit</button></td></tr>
                
                 
                 <tr id="hideDetailsH${Loop.index +1}" style="display:none;">
                
              
              <th></th>
                 <th>Status</th>
                 <th>Limit Price</th>
                 <th>Stop Price</th>
                 <th>Total Quantity</th>
                 
          </tr>
          
             <tr  id="hideDetailsD${Loop.index +1}" style="display:none;">
             <th></th>
              <td><%= l.get(j).getStatus() %></td>
                <td><%= l.get(j).getLimitPrice() %></td>
               <td><%= l.get(j).getStopPrice() %></td>
                <td><%= l.get(j).getQtyPlaced() %></td>
               </tr>

     
              <tr id="hideEditH${Loop.index +1}" style="display:none;">
                
              
              <th></th>
                 <th>Order ID</th>
                 <th>Limit Price</th>
                 <th>Stop Price</th>
                 <th>Total Quantity</th>
                 <th>PM ID</th>
                 
          </tr>
          
             <tr  id="hideEditD${Loop.index +1}" style="display:none;">
             <th></th>
              <td><%= l.get(j).getOrderId() %></td>
                <td><%= l.get(j).getLimitPrice() %></td>
               <td><%= l.get(j).getStopPrice() %></td>
                <td><%= l.get(j).getQtyPlaced() %></td>
                <td><%= l.get(j).getPmId() %></td>
               </tr>
                 
         
               
           
      </div>

    </div>
 
 <%j++; %>
      </c:forEach>
        </table> 
   
</div>

   <button type="button" class="btn btn-default" id="sendBlock">SEND</button>

     <button type="button" class="btn btn-default">CANCEL</button>

</div>
    </div>
    
     <script>
    
    
    $(document).ready(function(){
    	$('#sendBlock').click(function() {
    		var data=[];
    	$('#sendBlockTable tr').each(function()
    	{
    	if($(this).find("input[type=checkbox]").prop("checked")===true)
    	{
    		
    		
		console.log("sakjs");
    	var out=$(this).find('.blockId').html();
    	console.log(out);
    	data.push(out);
    	}
    	 
    	}
    	);	
    	  console.log(data);  
    	  
    	  $.ajax({
    		  type: "POST",
    		  url: "saveBlock",
    		  dataType: 'json',
    		  data:"data="+data,
    		  success: function(data) {
    		    console.log("data is sent");
    		  }
    		});
    	  
    	  
    	});
    	});
    
    
    
    </script>
        
</nav>
</body>
<script>
function getId(){
	return i++;
}

function toggleDetails(i) {
	if( document.getElementById("hideDetailsH"+i).style.display=='none' ){
	       document.getElementById("hideDetailsH"+i).style.display = 'table-row'; // set to table-row instead of an empty string
	    }else{
	       document.getElementById("hideDetailsH"+i).style.display = 'none';
	    }
    
    if( document.getElementById("hideDetailsD"+i).style.display=='none' ){
       document.getElementById("hideDetailsD"+i).style.display = 'table-row'; // set to table-row instead of an empty string
    }else{
       document.getElementById("hideDetailsD"+i).style.display = 'none';
    }
    }

function toggleEdit(i) {
	if( document.getElementById("hideEditH"+i).style.display=='none' ){
	       document.getElementById("hideEditH"+i).style.display = 'table-row'; // set to table-row instead of an empty string
	    }else{
	       document.getElementById("hideEditH"+i).style.display = 'none';
	    }
    
    if( document.getElementById("hideEditD"+i).style.display=='none' ){
       document.getElementById("hideEditD"+i).style.display = 'table-row'; // set to table-row instead of an empty string
    }else{
       document.getElementById("hideEditD"+i).style.display = 'none';
    }
    }

</script>
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
 	});
 
 
    
    </script>
</html>