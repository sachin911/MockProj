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
           <table class="table">
           <div>   
           <c:forEach items='${Blocks}' var="Blocks">   
            <tr>
                 <td><c:out value='${Blocks.symbol}'/></td>
                 <td><a data-toggle="collapse" data-toggle = "#i" href ="#"><c:out value='${Blocks.side}'/></a></td>
                 <td><c:out value='${Blocks.total_quantity}'/></td>
                 <td><c:out value='${Blocks.executed_quantity}'/></td>
                 <td><c:out value='${Blocks.stop_price}'/></td>
                 <td><c:out value='${Blocks.limit_price}'/></td>
                 <td></td>
                 <td><c:out value='${Blocks.status}'/></td>
                 <td><c:out value='${Blocks.executed_date}'/></td>
                </tr>
            </c:forEach>
         		</table>
               <div id="i" class="collapse">
            
        <div class="panel-body">Orders present in block</div>
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
        function generateId () {return "id" + Math.random().toString(16).slice(2)};
        
        </script>
     </html>