<%@ page language="java" contentType="text/html; charset=UTF-8"
       pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
       href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
       src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
       src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
                           <li><a href="PMHome.jsp">Home Page</a></li>
                           <li class="active"><a href="CreateTrade.jsp">Create Trader</a></li>
                           <li><a href="OrderBlotter.jsp">Order Blotter</a></li>
                           <li><a href="PMHistory.jsp">History</a></li>
                     </ul>
              </div>

              <h2 style="margin-left: 146px;">Create Equity Order</h2>

              <div class="container">

                     <div class="panel-group" id="accordion">
                           <div class="panel panel-default">
                                  <div class="panel-heading">

                                         <!--   <div class="container">-->
                                         <div class="well">
                                                <form action="CreateOrder" >

                                                       <p>
                                                              <font size="3"><b>Symbol: </b></font> <input type="text" name = "symbol"
                                                                     style="margin-left: 153px;" required />
                                                       </p>
                                                       <p>
                                                              <font size="3"><b>Side: </b></font> <select
                                                                     style="margin-left: 177px;" required>
                                                                     <option name="side" value="Buy">BUY</option>
                                                                     <option name ="side" value="Sell">SELL</option>
                                                              </select>
                                                       </p>
                                                       <p>
                                                              <font size="3"><b>Order Type: </b></font> <select
                                                                     style="margin-left: 125px;" required>
                                                                     <option name="orderType" value="Market">Market</option>
                                                                     <option name="orderType" value="Limit">Limit</option>
                                                                     <option name="orderType" value="Stop-Limit">Stop-Limit</option>
                                                                     <option name="orderType" value="Stop">Stop</option>
                                                              </select>
                                                       </p>
                                                       <p>
                                                              <font size="3"><b>Order Qualifier: </b></font> <select
                                                                     style="margin-left: 97px;" required>
                                                                     <option name="qualifier" value="Day Order">Day Order</option>
                                                                     <option name="qualifier" value="GTC">GTC</option>
                                                              </select>
                                                       </p>
                                                       <p>
                                                              <font size="3"><b>Trader: </b></font> <select
                                                                     style="margin-left: 159px;" required>
                                                                     <option>Select</option>
                                                                     <option>T1</option>
                                                                     <option>T2</option>
                                                                     <option>T3</option>
                                                                     <option>T4</option>
                                                              </select>
                                                       </p>
                                                       <p>
                                                              <font size="3"><b>Account Type: </b></font> <select
                                                                     style="margin-left: 104px;" required>
                                                                     <option name="accountType" value="Cash">Cash</option>
                                                                     <option name="accountType" value="Margin">Margin</option>
                                                              </select>
                                                       </p>
                                                       <p>
                                                              <font size="3"><b>Portfolio: </b></font> <select
                                                                     style="margin-left: 143px;" required>
                                                                     <option>Select</option>
                                                                     <option>P1</option>
                                                                     <option>P2</option>
                                                                     <option>P3</option>
                                                                     <option>P4</option>
                                                              </select>
                                                       </p>
                                                       </p>
                                                       <p>
                                                              <font size="3"><b>Quantity: </b></font> <input type="number" name="qtyPlaced"
                                                                     style="margin-left: 142px;" required />
                                                       </p>

                                                       </p>

                                                       <p>
                                                              <font size="3"><b>Stop Price: </b></font> <input type="text" name="stopPrice"
                                                                     style="margin-left: 127px;" />

                                                       </p>

                                                       </p>

                                                       <p>
                                                              <font size="3"><b>Limit Price: </b></font> <input type="text" name="limitPrice"
                                                                     style="margin-left: 124px;" />

                                                       </p>
                                                       <input type="submit" class="btn btn-default" value="Create"/>
                                                </form>
                                         </div>
                                  </div>
                           </div>
                     </div>
                     
              </div>
              </div>


       </nav>
       
</body>
</html>
