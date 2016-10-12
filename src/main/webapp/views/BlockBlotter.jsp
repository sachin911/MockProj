<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Test Page</title>
</head>
<body>
    <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Execution Trader</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">View Blocks</a></li>
      <li><a href="Pending_orders.jsp">Pending Orders</a></li>
      <li><a href="#">History</a></li> 
    </ul>
  </div>
    <div class="container">
 
  <div class="well">
      <h2>Block Blotter</h2>
 
 <div class="container">

  <div class="panel-group" id="accordion">
    <div class="panel panel-default">
      <div class="panel-heading">
        
         <table class="table">
             
             <tr>
                 <td><input type="checkbox"/></td>
                 <td>ID: 123</td>
                 <td>Symbol: GOOG</td>
                 <td>Side:Sell</td>
                 <td>Timestamp:12:23</td>
                 <td>
                 <h4 class="panel-title">
            <a data-toggle="collapse" data-parent="#accordion" href="#collapse1"><button type="button" class="btn btn-default">+</button></a>
                 </h4></td>
                 <td>
                 <h4 class="panel-title">
            <a data-toggle="collapse" data-parent="#accordion" href="#collapse1-edit"><button type="button" class="btn btn-default">Edit</button></a>
                 </h4></td>
             </tr>  
            </table>  
      </div>
        <div id="collapse1-edit" class="panel-collapse collapse">
        <div class="panel-body">Orders present in block</div>
      </div>
      <div id="collapse1" class="panel-collapse collapse ">
        <div class="panel-body">Block Details</div>
      </div>
    </div>
    <div class="panel panel-default">
      <div class="panel-heading">
         <table class="table">
             
             <tr>
                 <td><input type="checkbox"/></td>
                 <td>ID: 123</td>
                 <td>Symbol: GOOG</td>
                 <td>Side:Sell</td>
                 <td>Timestamp:12:23</td>
                 <td>
                 <h4 class="panel-title">
            <a data-toggle="collapse" data-parent="#accordion" href="#collapse2"><button type="button" class="btn btn-default">+</button></a>
                 </h4></td>
                 <td>
                 <h4 class="panel-title">
            <a data-toggle="collapse" data-parent="#accordion" href="#collapse2-edit"><button type="button" class="btn btn-default">Edit</button></a>
                 </h4></td>
             </tr>  
            </table>  
    </div>
        <div id="collapse2-edit" class="panel-collapse collapse">
        <div class="panel-body">Orders present in block</div>
      </div>
        <div id="collapse2" class="panel-collapse collapse">
        <div class="panel-body">Block Details</div>
      </div>
    
  </div>
</div>
   <button type="button" class="btn btn-default">SEND</button>
     <button type="button" class="btn btn-default">CANCEL</button>
</div>
</div>
    
        
</nav>
</body>
</html>