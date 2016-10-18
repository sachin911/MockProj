
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
   <title>Order History</title>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <link rel="stylesheet" href="./css/pm-pending-order.css">
    
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    
   <!-- Navigation Bar -->
   <nav class="navbar navbar-default">
      <div class="container-fluid">
         <div class="navbar-header">
            <a class="navbar-brand" href="./PMHome.jsp">Portfolio Manager</a>
         </div>
         <ul class="nav navbar-nav">
             <li><a href="./PMHome.jsp">Home</a></li>
            <li><a href="./CreateTrade.jsp">Create Order</a></li>
            <li ><a href="./OrderBlotter.jsp">Order Blotter</a></li>
            <li ><a href="./PendingOrder.jsp">Pending Orders</a></li>
            <li class="active"><a href="./PMHistory.jsp">History</a></li>
         </ul>
      </div>
    </nav>
    
    <div class="container">
        <h2 id="pending-order-title">Order History</h2>
        <div id="pending-order-container">
            <!-- order in blotter -->    
            <div class="row well" id="pending-order-headers">
                <div class="col col-sm-1"> Order ID </div>
                <div class="col col-sm-1"> Symbol </div>
                <div class="col col-sm-1"> Side</div>
                <div class="col col-sm-2 col-centered"> Type</div>
                <div class="col col-sm-1"> Qualifier</div>
                <div class="col col-sm-1"> Trader</div>
                <div class="col col-sm-1"> Quantiy</div>
                <div class="col col-sm-1">Stop </div>
                <div class="col col-sm-1">Limit </div>
                <div class="col col-sm-1">Status </div>
                 <div class="col col-sm-1">Portfolio </div>
                <!--<div class="col col-sm-1">Account Type </div>
                <div class="col col-sm-1">Order Date </div>-->


                
            </div>
            
            <div class="row well" id="pending-order-data">
                <!-- order 1 -->
                <div class="row " id="orderid1-data">
                    <div class="col col-sm-1"> <label> 1211</label> </div>
                    <div class="col col-sm-1"> AAPL </div>
                    <div class="col col-sm-1"> BUY</div>
                    <div class="col col-sm-2 col-centered"> MARKET</div>
                    <div class="col col-sm-1"> GTC</div>
                    <div class="col col-sm-1"> T1</div>
                    <div class="col col-sm-1"> 1000</div>
                    <div class="col col-sm-1"> - </div>
                    <div class="col col-sm-1"> -  </div>
                     <div class="col col-sm-1"> New </div>
                    <div class="col col-sm-1"> P1  </div>
                     <!-- <div class="col col-sm-1"> Cash  </div>
                    <div class="col col-sm-1"> -  </div>-->
                    
                </div>
                
                <!-- order 2 -->
                <div class="row " id="orderid2-data">
                    <div class="col col-sm-1"> <label><label>1232</label> </div>
                    <div class="col col-sm-1"> DELL </div>
                    <div class="col col-sm-1"> SELL</div>
                    <div class="col col-sm-2 col-centered"> LIMIT</div>
                    <div class="col col-sm-1"> GTC</div>
                    <div class="col col-sm-1"> T2</div>
                    <div class="col col-sm-1"> 500</div>
                    <div class="col col-sm-1"> - </div>
                    <div class="col col-sm-1">32.05 </div>
                     <div class="col col-sm-1"> Open </div>
                    <div class="col col-sm-1"> P2 </div>
<!--
                      <div class="col col-sm-1"> Margin  </div>
                    <div class="col col-sm-1"> - </div>
-->
                    
                </div>
                
                <!-- order 3 -->
                <div class="row " id="orderid3-data">
                    <div class="col col-sm-1"> <label><label> 1542</label> </div>
                    <div class="col col-sm-1"> SKODA </div>
                    <div class="col col-sm-1"> BUY</div>
                    <div class="col col-sm-2 col-centered"> STOP-LIMIT</div>
                    <div class="col col-sm-1"> GTC</div>
                    <div class="col col-sm-1"> T1</div>
                    <div class="col col-sm-1"> 1200</div>
                    <div class="col col-sm-1">25.02 </div>
                    <div class="col col-sm-1">32.65 </div>
                     <div class="col col-sm-1"> Open </div>
                    <div class="col col-sm-1"> P3  </div>
                      <!--<div class="col col-sm-1"> Cash  </div>
                    <div class="col col-sm-1"> -  </div>-->
                   
                   
                </div>
                
            </div>
                        
        </div>        
    </div>
   
</body>
</html>