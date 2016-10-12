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

<script>
 function alert_message(){
	 
	 alert("New Equity Order created!");
	 
 }
</script>
<body>
    <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Portfolio Manager</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#">Trade</a></li>
      <li><a href="#">Blotter</a></li> 
      <li><a href="#">History</a></li> 
    </ul>
  </div>
    
      <h2 style="margin-left:146px;" >Create Equity Order</h2>
 
 <div class="container">

  <div class="panel-group" id="accordion">
    <div class="panel panel-default">
      <div class="panel-heading">
        
       <!--   <div class="container">-->
        <div class="well">
        <form action="#" method="post">
        
        <p> <font size="3"><b>Client Id: </b></font>
         <input type="text" style="margin-left:148px;" required/>
        
        </p>
        
        <p> <font size="3"><b>Symbol: </b></font>
         <input type="text" style="margin-left:153px;" required/>
        
      
        
        </p>
        
         <p> <font size="3"><b>Security Name: </b></font>
         <input type="text" style="margin-left:100px;" required/>
        
        </p>
        
         <p> <font size="3"><b>Side: </b></font>
         <select style="margin-left:177px;" required>
         <option> BUY</option>
         <option> SELL</option>
         
        
         
         </select>
        
        </p>
        <p> <font size="3"><b>Order Type: </b></font>
         <select style="margin-left:125px;" required>
         <option> Market</option>
         <option> Limit</option>
         <option> Stop-Limit</option>
         <option> Stop </option>
         
         
         </select>
        
        </p>
        
        <p> <font size="3"><b>Order Qualifier: </b></font>
         <select style="margin-left:97px;" required>
         <option> Day Order</option>
         <option> GTC</option>
        
         
         </select>
        
        </p>
        
        <p> <font size="3"><b>Trader: </b></font>
         <select style="margin-left:159px;" required>
         <option> Select</option>
         <option> T1</option>
         <option> T2</option>
         <option> T3 </option>
         <option> T4</option>
         
         </select>
        
        </p>
        
        <p> <font size="3"><b>Account Type: </b></font>
         <select style="margin-left:104px;" required>
         <option> Cash</option>
         <option> Margin</option>
         
         
         </select>
        
        </p>
        
        <p> <font size="3"><b>Portfolio: </b></font>
         <select style="margin-left:143px;" required>
         <option> Select</option>
         <option> P1</option>
         <option> P2</option>
         <option> P3 </option>
         <option> P4</option>
         
         </select>
        
        </p>
        
         </p>
        
         <p> <font size="3"><b>Quantity: </b></font>
         <input type="number" style="margin-left:142px;" required/>
        
        </p>
        
         </p>
        
         <p> <font size="3"><b>Stop Price: </b></font>
         <input type="text" style="margin-left:127px;" />
        
        </p>
        
         </p>
        
         <p> <font size="3"><b>Limit Price: </b></font>
         <input type="text" style="margin-left:124px;" />
        
        </p>
        
        
        
        
        
        
        
        </form> 
         </div> 
         </div>
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
    
    
  </div>
</div>
   <button type="button" class="btn btn-default" onclick=alert_message()>CREATE</button>
     <button type="button" class="btn btn-default" >NOTIFY</button>
</div>
</div>
    
        
</nav>
</body>
</html>