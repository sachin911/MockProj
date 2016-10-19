<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
	 <%@ page import="java.util.List" %>
    <%@ page import="com.mock.project.model.Block"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
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
    <!-- hello -->
    <title>Test Page</title>
</head>
<body>
<!--  .td { width = "10%" } -->
    <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand">Execution Trader</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="PopulateBB">View Blocks</a></li>
      <li><a href="updateTable">Pending Orders</a></li>
      <li class="active"><a href="PopulateTraderHistory">History</a></li>  
    </ul>
  </div>
    <div class="container">
        
    <div class="well">
      <h2>Trader History</h2>
 

  <div class="panel-group" style = "width: 1060px">
    <div class="panel panel-default">
      <div class="panel-heading">
          
        <table class="table">
           
            <th>Symbol</th>
            <th>Side</th>
            <th>Total Quantity</th>
            <th>Allocated Quantity</th>
            <th>Stop Price</th>
            <th>Limit Price</th>
            <th>Executed Price</th>
            <th>Status</th>
            <th>Date</th>
           
       </table>
       </div>
             </div>
      </div>
           
           </td>
        <div class="panel-group" style = "width: 1060px"> 
    <div class="panel panel-default">
      <div class="panel-heading">
           <table class="table" id="blockHistoryTable">
           <div>   
           <c:forEach items='${Blocks}' var="Blocks" varStatus="Loop">   
            <tr>
            	<td class="blockId"><c:out value='${Blocks.blockId}'/></td>
                 <td><c:out value='${Blocks.symbol}'/></td>
                 <td><c:out value='${Blocks.side}'/></a></td>
                 <td><c:out value='${Blocks.qtyPlaced}'/></td>
                 <td><c:out value='${Blocks.qtyExecuted}'/></td>
                 <td><c:out value='${Blocks.stopPrice}'/></td>
                 <td><c:out value='${Blocks.limitPrice}'/></td>
                 <td></td>
                 <td><c:out value='${Blocks.status}'/></td>
                 <td><c:out value='${Blocks.executedDate}'/></td>
                 <td><button id ="detailsButton${Loop.index +1}" class="btn btn-default" onclick="toggleDetails('${Loop.index +1}')">Details</button></td>
                 <tr id="hideDetailsH${Loop.index +1}" style="display:none;">
                
              <table class="orderTable" id="hideDetailsD${Loop.index +1}" style="display:none;">
              <th></th>
                 <th>Status</th>
                 <th>Limit Price</th>
                 <th>Stop Price</th>
                 <th>Total Quantity</th>
                 
          </tr>
          
            
             	<c:forEach items='${Orders}' var="Orders" >   
            <tr>
            	 <td><c:out value='${Orders.status}'/></td>
			  <td><c:out value='${Orders.limitPrice}'/></td>
			  <td><c:out value='${Orders.stopPrice}'/></td>
			  
			      <td><c:out value='${Orders.qtyExecuted}'/></td>
			     
               </tr>
                 </c:forEach>
                
            </c:forEach>
         		</table>
              </table>
      </div>
      </div>

            </div>
      </div>
    
         
        
	
	
         

        </div>
        
        
        <div class="query">
          <input id="q" placeholder="Search" autocomplete="off">
          <a class="submit"><span class="header-sprite icon-search"></span></a>
        </div>
        <button type="button" class="btn btn-info">Filter</button>
        
        </div>
        <script>
        
       
        	
        </script>
        <script>
        
        function LoadData() {
            var myDataTable = $(".orderTable").jsp("<table><thead></thead><tbody></tbody></table>");
            $("table",myDataTable).dataTable({});
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
            var data=[];
        	
        		
        		
    		
        	var out1=$("#blockHistoryTable tr").find('.blockId').html();
        	console.log(out1);
        	data.push(out1);
        	
        	$.ajax({
      		  type: "GET",
      		  url: "fetchOrderInBlock",
      		  dataType: 'json',
      		  data:"data="+data,
      		  success: function(data) {
      		    console.log("data is sent");
      		  }
      		});
        	 
        	LoadData();
        	
            }
       
        </script>
     </html>