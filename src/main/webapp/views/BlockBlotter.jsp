<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	 <%@ page import="java.util.List,com.mock.project.model.Block,com.mock.project.model.Order,com.mock.project.service.OrderService,com.mock.project.service.OrderServiceImpl,org.springframework.context.support.AbstractApplicationContext,org.springframework.context.annotation.AnnotationConfigApplicationContext,com.mock.project.config.AppConfig" %>
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
    <title>Home</title>
</head>
<body style="font-family:courier;">
<style>
.optionsDiv {
padding-bottom:10px;
font-weight:bold;
}



</style>
    <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="TraderHome.jsp">Execution Trader</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="PopulateBB">View Blocks</a></li>

      <li><a href="updateTable">Pending Orders</a></li>

      <li><a href="PopulateTraderHistory">History</a></li> 

    </ul>
  </div>
   </nav>   
    <div class="container">
 
  <div class="well">
      <h2><strong>Block Blotter</strong></h2><br/>
       <div class="optionsDiv"> Filter By Side: <select id="selectField">
                              <option>All</option>
                              <option>Buy</option>
                              <option>Sell</option>
                              
                              </select></div>   
                              <%int j=0;%> <%int i=0; %>
 <c:forEach items='${Blocks}' var="Blocks" varStatus="Loop">
 

  <!-- <div class="panel-group" id="accordion"> -->

    <div class="panel panel-default">
      <div class="panel-heading"> 
      
 <table class="table" id="sendBlockTable">
     
<tr class="table-header">
              <th></th>
                 <th>Block ID</th>
                 <th>Symbol</th>
                 <th>Side</th>
                 <th>Time stamp</th>
                 <th>Order Type</th>
                 <th>Limit Price</th>
                 <th>Stop Price</th>
                 <th>Total Quantity</th>
          </tr>
         
            
           <%List<Block> l =(List<Block>) request.getAttribute("Blocks");
           System.out.println(l);%>
      <!--          <div class="panel panel-default">
      <div class="panel-heading">  -->
      
             <tr id = "getId();" class="table-header">
                 <td><input type="checkbox"/></td>
                  <td class="blockId"><c:out  value='${Blocks.blockId}'/></td>

                <td><c:out  value='${Blocks.symbol}'/></td>
               <td><c:out  value='${Blocks.side}'/></td>
                <td><c:out  value='${Blocks.orderDate}'/></td>
                <td><c:out  value='${Blocks.orderType}'/></td>
                     <% if(l.get(j).getLimitPrice()==0 && l.get(j).getStopPrice()==0) {%>
                 <td>-</td>
               <td>-</td>

               <% } else {%>
                <td><c:out  value='${Blocks.limitPrice}'/></td>
               <td><c:out  value='${Blocks.stopPrice}'/></td>
               <%} %>
                 <td><c:out  value='${Blocks.qtyPlaced}'/></td>
                 
               
                 <%-- <td><button id ="detailsButton" class="btn btn-sm btn-info" onclick="toggleDetails('${Loop.index +1}')">Details</button></td> --%>
                  <td><button id ="editButton" class="btn btn-sm btn-info" onclick="toggleEdit('${Loop.index +1}')">Edit</button></td></tr>
               </tr> 
                 
           <%--       <tr id="hideDetailsH${Loop.index +1}" style="display:none;" position = "notShownByFilter">
                
              
              <th>Block Details :</th>
                 <th>Status</th>
                 <th>Limit Price</th>
                 <th>Stop Price</th>
                 <th>Total Quantity</th>
                 
          </tr> --%>
         <% 
         AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
         container.registerShutdownHook();
       
         OrderService orderService = container.getBean(OrderService.class); 
         
         
          System.out.println(l.get(j).getBlockId());
          List<Order> orders = orderService.findOrders(l.get(j).getBlockId()); %> 
          <%-- 
             <tr  id="hideDetailsD${Loop.index +1}" style="display:none;" position = "notShownByFilter">
             <td></td>
          <td><%= l.get(j).getStatus() %></td>
                <td><%= l.get(j).getLimitPrice() %></td>
               <td><%= l.get(j).getStopPrice() %></td>
                <td><%= l.get(j).getQtyPlaced() %></td>
               </tr> --%>
     		<table class="table">
              <tbody id="hideEditD${Loop.index +1}" style="display:none;" position = "notShownByFilter">
                <tr>
             	
              <th></th>
                 <th>Order ID</th>
                 <th>Limit Price</th>
                 <th>Stop Price</th>
                 <th>Total Quantity</th>
                 <th>PM ID</th>
                 <th>Portfolio ID</th>
                 
                 <th><button type="button" class="btn btn-danger btn-sm" id="cancelOrder${Loop.index +1}">Remove</button></th>
                 
        
             <th></th>
              </tr>
         
           <!--  <tbody id="hideEditD${Loop.index +1}" style="display:none;" position = "notShownByFilter"> -->
             <% for(int k=0;k<orders.size();k++) {%>
             
             <tr id="hideEditD" style = "background-color: Cornsilk" >
              <td><input type="checkbox" class="sjahdjassads"/></td>
              <td class = orderIdForCancel><%= orders.get(k).getOrderId() %></td>
              <%System.out.println(orders.get(k).getOrderType()); 
              boolean b;%>
               <% if(b = orders.get(k).getOrderType()=="market") { System.out.println(b);%>
                <td><%=orders.get(k).getLimitPrice() %></td>
               <td><%= orders.get(k).getStopPrice() %></td>
               <% } else {%>
               <td>-</td>
               <td>-</td>
               <%} %>
                <td><%= orders.get(k).getQtyPlaced() %></td>
                <td><%= orders.get(k).getPmId() %></td>
                  <td><%= orders.get(k).getPortfolioId() %></td> 
               </tr>
		<% } %>
		</tbody>
		</table>
		   
              <%--   <td><%= l.get(j).getPmId() %></td> --%>
            
              
                 
         
               
           
     
 
 <%j++; %>
 <thead></thead>
   
        </table> 
        
      
</div>



</div>
   </c:forEach>
   <button type="button" class="btn btn-sm btn-success" id="sendBlock">SEND</button>

     <button type="button" class="btn btn-sm btn-danger" id="removeBlock">REMOVE BLOCK</button>
   	
    </div>
    
    </div>
    
    <script>
    $("button[id^='editButton']").click(function(){
		
		$('.orderCheckBox').attr('checked', false);
			
		});
	
	
	
	$("button[id^='cancelOrder']").click(function(){
		var data=[];
		$("tr[id^='hideEditD']").each(function()
				{
			if($(this).find("input[type=checkbox]").prop("checked")===true){
				
				var out=$(this).find('.orderIdForCancel').html();
		    	console.log(out);
				data.push(out);
				
			}
			
			
				}
				
		
		
		);
	
		$.ajax({
    		  type: "POST",
    		  url: "cancelOrder",
    		  dataType: 'json',
    		  data:"data="+data,
    		  success: function(data) {
    		    console.log("data is sent");
    		  }
    		});
		alert("Order removed")
   	  ref();
		});

	
	


    </script>
     <script>
    
     $(document).ready(function(){
     	
     });
     
     function ref(){
    	 window.location="PopulateBB";
     }
     
     </script>
     <script>
    
    $(document).ready(function(){
    	
    
    	
    	
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
		/* if( document.getElementById("hideEditH"+i).style.display=='none' ){
		       document.getElementById("hideEditH"+i).style.display = 'table-row'; // set to table-row instead of an empty string
		    }else{
		       document.getElementById("hideEditH"+i).style.display = 'none';
		    } */
	    
	    if( document.getElementById("hideEditD"+i).style.display=='none' ){
	       document.getElementById("hideEditD"+i).style.display = 'table-row'; // set to table-row instead of an empty string
	    }else{
	       document.getElementById("hideEditD"+i).style.display = 'none';
	    }
	    }

	
	
	 $(document).ready(function() {
		 $('#removeBlock').click(function() {
		     	
	  			
  			
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
	     		  type: "GET",
	     		  url: "removeBlock",
	     		  dataType: 'json',
	     		  data:"data="+data,
	     		  success: function(data) {
	     		    console.log("data is sent");
	     		  }
	     		});
	     	 alert("Block removed")
	     	  ref();
	     	});
		 
		 
		 $('#sendBlock').click(function() {
		    	
		 		
	    		location.href="PopulateBB";	
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
	    	  alert("Blocks sent successfully");
	    	  ref();
	    	});
	    	
	    	$(document).on("click","#cancelOrder",function(){
	    		
	    		$("tr[id^='hideEditD']").each(function() {
	    			console.log("test");
	    		});
	    		
	    	});

	     function addRemoveClass(theRows) {

	         theRows.removeClass("odd even");
	         theRows.filter(":odd").addClass("odd");
	         theRows.filter(":even").addClass("even");
	     }
	     var data=[];
	     var rows = $("table#sendBlockTable tr:not(:first-child)");
	     var side=$(this).find('.orderSide').html();
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
	             rows.filter("[position=notShownByFilter]").hide();
	             addRemoveClass(rows);

	         }
	         
	         
	          
	        
	         
	        

	     });
	 }); 

 
 
    
    </script>
</html>