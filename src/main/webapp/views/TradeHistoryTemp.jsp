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
    <title>Trader History</title>
</head>
<body style="font-family:courier;">

 <style>
.optionsDiv {
padding-bottom:10px;
font-weight:bold;
}

.odd{

}
.even{

}
</style> 

<!--  .td { width = "10%" } -->
   <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="TraderHome.jsp">Execution Trader</a>
    </div>
    <ul class="nav navbar-nav">
      <li ><a href="PopulateBB">View Blocks</a></li>

      <li><a href="updateTable">Pending Orders</a></li>

      <li class="active"><a href="PopulateTraderHistory">History</a></li> 

    </ul>
  </div>
   </nav>   
    <div class="container">
        
    <div class="well">
      <h2><strong>Trader History</strong></h2><br/>
        <div class="optionsDiv"> Filter By Side: <select id="selectField">
                              <option>All</option>
                              <option>Buy</option>
                              <option>Sell</option>
                              
                              </select></div> 
 

  <div class="panel-group" style = "width: 1060px">
    <div class="panel panel-default">
      
             </div>
      </div>
           
           </td>
        <div class="panel-group" style = "width: 1060px"> 
    <div class="panel panel-default">
      <div class="panel-heading">
      <div style="height:500px;overflow:auto;">
           <table class="table" id="blockHistoryTable">
           <div>   
           <th>Block ID</th>
           <th>Symbol</th>
            <th>Side</th>
            <th>Total Quantity</th>
            <th>Allocated Quantity</th>
            <th>Stop Price</th>
            <th>Limit Price</th>
            <th>Executed Price</th>
            <th>Status</th>
            <th>Date</th>
           
           <c:forEach items='${Blocks}' var="Blocks" varStatus="Loop">   
            <tr position='${Blocks.side }' >
            	<td class="blockId"><c:out value='${Blocks.blockId}'/></td>
                 <td><c:out value='${Blocks.symbol}'/></td>
                 <td><c:out value='${Blocks.side}'/></a></td>
                 <td><c:out value='${Blocks.qtyPlaced}'/></td>
                 <td><c:out value='${Blocks.qtyExecuted}'/></td>
                 <td><c:out value='${Blocks.stopPrice}'/></td>
                 <td><c:out value='${Blocks.limitPrice}'/></td>
                 <td>'${Blocks.executed_price}'</td>
                 <td><c:out value='${Blocks.status}'/></td>
                 <td><c:out value='${Blocks.executedDate}'/></td>
                
                 </tr>  </c:forEach>
                 <tr id="hideDetailsH${Loop.index +1}" style="display:none;">
                
              <table class="orderTable" id="hideDetailsD${Loop.index +1}" style="display:none;">
            <thead>
                 <th>Status</th>
                 <th>Limit Price</th>
                 <th>Stop Price</th>
                 <th>Total Quantity</th>
            </thead>     
         
          
            
             	<c:forEach items='${Orders}' var="Orders" >   
            <tr>
            	 <td><c:out value='${Orders.status}'/></td>
			  <td><c:out value='${Orders.limitPrice}'/></td>
			  <td><c:out value='${Orders.stopPrice}'/></td>
			  
			      <td><c:out value='${Orders.qtyExecuted}'/></td>
			     
               </tr>
                 </c:forEach>
               
           
         		</table> </tr>
              </table>
              </div>
      </div>
      </div>

            </div>
      </div>
    
         
        
	
	
         

        </div>
        
        
        
        
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
               document.getElementById("hideDetailsD"+i).style.display = 'table'; // set to table-row instead of an empty string
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
        <script>
        $(document).ready(function() {

            function addRemoveClass(theRows) {

                theRows.removeClass("odd even");
                theRows.filter(":odd").addClass("odd");
                theRows.filter(":even").addClass("even");
            }
            var data=[];
            var rows = $("table#blockHistoryTable tr:not(:first-child)");
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
                    addRemoveClass(rows);

                }
                
                
                 
               
                
               

            });
        }); 
       
        </script>
     </html>