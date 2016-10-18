<% response.addHeader("Refresh","10"); %>
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
        <table class="table"> 
             
            <thead>
              <th></th>
                 <th>ID</th>
                 <th>Symbol</th>
                 <th>Side</th>
                 <th>Timestamp</th>
                 
             </thead>  

     <%int j=0;%>
           <c:forEach items='${Orders}' var="Orders">  
           <%List<Order> l =(List<Order>) request.getAttribute("Orders"); %>
               <div class="panel panel-default">
      <div class="panel-heading">
      <table class="table"> 
             <tr id = "getId();">
                 <td><input type="checkbox"/></td>
                  <td><c:out  value='${Orders.orderId}'/></td>
                <td><c:out  value='${Orders.symbol}'/></td>
               <td><c:out  value='${Orders.side}'/></td>
                <td><c:out  value='${Orders.orderDate}'/></td>
                 <td>
               
                 <h4 class="panel-title">
            <a data-toggle="collapse" data-parent="#accordion" href = "'#a'+j"><button type="button" class="btn btn-default">Details</button></a>
                 </h4></td>
                 <td>
                 <h4 class="panel-title">
            <a data-toggle="collapse" data-parent="#accordion" href="#collapse1-edit"><button type="button" class="btn btn-default">Edit</button></a>
                 </h4></td>
             </tr>  
          
      </div>
        <div id="collapse1-edit" class="panel-collapse collapse">
        <div class="panel-body">Orders present in block</div>
      </div>

      <div id= "'a'+j" class="panel-collapse collapse-in ">
        <div class="panel-body"><table class="table"> 

             
            <thead>
              
                 <th>Status</th>
                 <th>Limit Price</th>
                 <th>Stop Price</th>
                 <th>Total Quantity</th>
                 
             </thead> 
             <%System.out.println(l.get(j).getQtyPlaced()); %>
             <tr>
              <td><%= l.get(j).getStatus() %></td>
                <td><%= l.get(j).getLimitPrice() %></td>
               <td><%= l.get(j).getStopPrice() %></td>
                <td><%= l.get(j).getQtyPlaced() %></td>
                </tr>
                 </table> </div>
      </div>
    </div>
 </table>
 <%j++; %>
      </c:forEach>
   
</div>
   <button type="button" class="btn btn-default">SEND</button>
     <button type="button" class="btn btn-default">CANCEL</button>

</div>
    </div>
        
</nav>
</body>
<script>
function getId(){
	return i++;
}

</script>
</html>