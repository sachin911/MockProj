<!DOCTYPE html>
<html>
   <head>
         <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <style>
   #creat-order-form{
    width:80%;
    border: 
}
.form-input-label{
    margin-bottom: 10px;
}
.form-input-fields{
    width:auto;
    margin-bottom: 10px;
    border-radius: 10px;
    border: 1px solid grey;
    padding:4px;
}
.form-input-fields input, select{
    border:none;
    background-color: transparent;
}
.form-input-fields select:onfocus{
    border: none;
}
input[type="number"]:disabled {
    background-color:grey;
    border-radius: 10px;
    opacity: 0.3;
}
textarea:focus, select:focus, input:focus{
    outline: none;
}
$dia: 6em;
$outcolor: #fff;
$bdrwidth: 10px;
$time: 0.15s;
   </style>
   <script>
   function changetextbox(obj)
   {  
         var limit = document.getElementById("limit");
        var stop = document.getElementById("stop");
       	
           stop.disabled =(obj.value == "limit" || obj.value == "market");
           limit.disabled =(obj.value == "stop" || obj.value == "market");
       
   }
   function alert_message(){
       alert("New Equity Order created!");
}

</script>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
      <title>Trading Application</title>
     </head>
   <body>
      <nav class="navbar navbar-default">
         <div class="container-fluid">
            <div class="navbar-header">
               <a class="navbar-brand" href="#">Portfolio Manager</a>
            </div>
            <ul class="nav navbar-nav">
               <li><a href="PMHome.jsp">Home Page</a></li>
               <li class="active"><a href="CreateTrade.jsp">Create Order</a></li>
               <li><a href="OrderBlotter.jsp">Order Blotter</a></li>
               <li><a href="PMHistory.jsp">History</a></li>
            </ul>
         </div>
      </nav>
       <div id="creat-order-form" class="container well">
         <h2 id="eqorder" >Edit Equity Order</h2>
            <!--   <div class="container">-->
            <form action="editOrder" method="post" >
               
                <div class="row">
                <div id="" class="form-input-label col col-sm-4"> Order Id: </div>
                <div class="form-input-fields col col-sm-8"><input type="text" id="orderId" value='${Order.orderID}' disabled/></div>
               
                <div id="" class="form-input-label col col-sm-4"> Symbol: </div>
               <div class="form-input-fields col col-sm-8"><input type="text" id="symbol" value='${Order.symbol}' disabled/></div>
                  
                <div id="" class="form-input-label col col-sm-4"> Side: </div>
               <div class="form-input-fields col col-sm-8"><input type = "text" id="side" value='${Order.side}' disabled>
              </div>
                
                <div id="" class="form-input-label col col-sm-4"> Order Type: </div>
               <div class="form-input-fields col col-sm-8"><input type = "text" id="ordertype" value='${Order.orderType}'>
               </div>
                
                <div id="" class="form-input-label col col-sm-4"> Order Qualifier: </div>
               <div class="form-input-fields col col-sm-8"><input type="text" id="orderqual" value='${Order.qualifier}'>
                  </div>
                  
                <div id="" class="form-input-label col col-sm-4"> Account Type: </div>
               <div class="form-input-fields col col-sm-8"><input type="text" id="orderqual" value='${Order.accountType}'>
                  </div>
                <div id="" class="form-input-label col col-sm-4"> Quantity: </div>
               <div class="form-input-fields col col-sm-8"><input type="text" id="orderqual" value='${Order.qtyPlaced}'>
                  </div>
                <div id="" class="form-input-label col col-sm-4"> Trader: </div>
               <div class="form-input-fields col col-sm-8"><input type="text" id="trader" value='${Order.traderId}'>
                 </div>
                <div id="" class="form-input-label col col-sm-4"> Portfolio: </div>
               <div class="form-input-fields col col-sm-8"><input type = "text" id="portfolio" value='${Order.portfolioId}'>
                   </div>
                <div id="" class="form-input-label col col-sm-4"> Stop Price: </div>
               <div class="form-input-fields col col-sm-8"><input type="number" id="stop" value='${Order.stopPrice}'></div>
                 <div id="" class="form-input-label col col-sm-4"> Limit Price: </div>
               <div class="form-input-fields col col-sm-8"><input type="number" id="limit" value='${Order.limitPrice}'></div>
                   </div>
             <input type="submit" class="btn btn-default"  value="Save"/>
             </div>
            </form>
         </div>
 </body>
</html>
