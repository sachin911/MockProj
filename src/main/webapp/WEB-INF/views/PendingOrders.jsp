<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
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
      <li class="active"><a href="PendingOrders.jsp">Pending Orders</a></li>
      <li><a href="TraderHistory.jsp">History</a></li>
    </ul>
  </div>
</nav>
  

<div class="container">
 <div class="well">
  <h2>PENDING ORDERS</h2>
  <p>You can select multiple orders to create a block</p>
  
  <form>
      <div class="Recommendations">
      <div style="height:300px;overflow-y:scroll;;">
    <div class="checkbox">
        
    <table class="table table-bordered">
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
      <tr>
          <td> <label><input type="checkbox" value=""></label></td>
        <td>GOOGLE</td>
        <td>BUY</td>
        <td>1000</td>
          <td>345</td>
        <td>222</td>
        <td>12</td>
          <td>34</td>
          <td>NEW</td>
        <td>P.K.GUPTA</td>
        <td>NORMAL</td>
          <td>1344</td>
          <td>123445</td>
            </tr>
            
             <tr>
          <td> <label><input type="checkbox" value=""></label></td>
        <td>GOOGLE</td>
        <td>BUY</td>
        <td>1000</td>
          <td>345</td>
        <td>222</td>
        <td>12</td>
          <td>34</td>
          <td>NEW</td>
        <td>P.K.GUPTA</td>
        <td>NORMAL</td>
          <td>1344</td>
          <td>123445</td>
            </tr>
            
             <tr>
          <td> <label><input type="checkbox" value=""></label></td>
        <td>GOOGLE</td>
        <td>BUY</td>
        <td>1000</td>
          <td>345</td>
        <td>222</td>
        <td>12</td>
          <td>34</td>
          <td>NEW</td>
        <td>P.K.GUPTA</td>
        <td>NORMAL</td>
          <td>1344</td>
          <td>123445</td>
            </tr>
            
             <tr>
          <td> <label><input type="checkbox" value=""></label></td>
        <td>GOOGLE</td>
        <td>BUY</td>
        <td>1000</td>
          <td>345</td>
        <td>222</td>
        <td>12</td>
          <td>34</td>
          <td>NEW</td>
        <td>P.K.GUPTA</td>
        <td>NORMAL</td>
          <td>1344</td>
          <td>123445</td>
            </tr>
             <tr>
          <td> <label><input type="checkbox" value=""></label></td>
        <td>GOOGLE</td>
        <td>BUY</td>
        <td>1000</td>
          <td>345</td>
        <td>222</td>
        <td>12</td>
          <td>34</td>
          <td>NEW</td>
        <td>P.K.GUPTA</td>
        <td>NORMAL</td>
          <td>1344</td>
          <td>123445</td>
            </tr>
        </tbody></table></div></div></div>
        
    </form>
    <script>
    function alert_message() {
        alert("Your block has been successfully created");
        
    } 
    </script>
      <button type="button" class="btn btn-primary" onclick=alert_message() id=demo">Create Block</button>

      <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">Add to Block
      </button>
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
</body>
</html>



