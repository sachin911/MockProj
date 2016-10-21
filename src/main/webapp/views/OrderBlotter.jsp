<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page
        import="org.springframework.context.support.AbstractApplicationContext"%>
<%
        response.addHeader("Refresh", "10");
%>
<%@page import="com.mock.project.config.AppConfig"%>
<%@page
        import="org.springframework.context.annotation.AnnotationConfigApplicationContext"%>
<%@ page import="java.util.List"%>
<%@ page import="com.mock.project.model.Order"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
   <title>Order Blotter</title>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <link rel="stylesheet" href="https://rawgit.com/Govind-jha/online-resources/master/pm-order-blotter.css">
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
                                <li class="active"><a href="ViewOrderBlotter">Order Blotter</a></li>
                                <li><a href="ViewPendingOrder">Pending Orders</a></li>
                                <li><a href="GeneralView">History</a></li>
                        </ul>
                </div>
        </nav>
    
    <div class="container">
        
        <h2 id="order-blotter-title">
            Order Blotter         
            <button id="orderId-send" type="button" class="btn btn-success">Send to Trader</button>
         	<label style="margin-left:50px; font-size:18px;" >Filter by Side: </label>      
			<select class="filter" style="font-size:18px;">
			   	<option>All</option>
			    <option>Buy</option>
			    <option>Sell</option>
			</select> 
        </h2>
        
          
        
        <div id="order-blotter-container">
            <!-- order in blotter -->    
            <div class="row well" id="order-blotter-headers">
                <div class="col col-sm-1"></div>
                <div class="col col-sm-1"> Order ID </div>
                <div class="col col-sm-1"> Symbol </div>
                <div class="col col-sm-1"> Side</div>
                <div class="col col-sm-1 col-centered"> Type</div>
                <div class="col col-sm-1"> Qualifier</div>
                <div class="col col-sm-1"> Trader</div>
                <div class="col col-sm-1"> Quantiy</div>
                <div class="col col-sm-1">Stop </div>
                <div class="col col-sm-1">Limit </div>
                <div class="col col-sm-1"> </div>
                <div class="col col-sm-1"> </div>
            </div>
            
            <div class="row well" id="order-blotter-data">
                
                <!-- order 1 -->
                
            <c:forEach items='${Orders}' var="Orders" varStatus="loop">   
                <div class="row " id="${Orders.orderId}-data" position='${Orders.side}'>
                    <div class="col col-sm-1"> <label><input type="checkbox" id="${Orders.orderId}" name="check"></label> </div>
                    <div class="OrderId col col-sm-1" id="order_id"><c:out value='${Orders.orderId}'/></div>
                    <div class="col col-sm-1"><c:out value='${Orders.symbol}'/> </div>
                    <div class="side col col-sm-1" id="side-${Orders.orderId}"><c:out value='${Orders.side}'/></div>
                    <div class="col col-sm-1 col-centered"><c:out value='${Orders.orderType}'/></div>
                    <div class="OrderStatus" style="display:none;"><c:out value='${Orders.status}'/></div>
                    <div class="col col-sm-1"><c:out value='${Orders.qualifier}'/></div>
                    <div class="col col-sm-1"><c:out value='${Orders.traderId}'/></div>
                    <div class="col col-sm-1"><c:out value='${Orders.qtyPlaced}'/></div>
                    <div class="col col-sm-1"><c:out value='${Orders.stopPrice}'/></div>
                    <div class="col col-sm-1"><c:out value='${Orders.limitPrice}'/></div>
                    <div class="col col-sm-1"> <button id="edit-${Orders.orderId}" type="button" class="edit btn btn-warning" onclick="edit()">Edit</button></div>
                    <div class="col col-sm-1"> <button id="cancel-${Orders.orderId}" type="button" class="cancel btn btn-danger" onclick="cancel()">Cancel</button> </div>
                </div>
            </c:forEach>

            </div>
                        
        </div>        
    </div>
    
    <script type="text/javascript">
        //Send trade to the trader.
        $("#orderId-send").click( function()
        {		
        	
                var data = [];
                $('#order-blotter-container input:checked').each(function() {
                    data.push($(this).attr('id'));
                });
               
                
                $.ajax({
                        type: "POST",
                        url: "SendToTrader",
                        data: "data="+data ,
                        success: function(data) {
                          console.log("data is sent");
                       	 alert("trade sent successfully");
                       	window.history.go(0);
                        },
                             error:function(jqXHR, textStatus, errorThrown) {
                               console.log(textStatus, errorThrown);
                             
                        }
                      });
                
           });
        
        // Edit an order.
        $(".edit").click( function(){
                var id = ($(this).attr('id')).split("-");
                // This is the id of the order to be edited.
                var message = id[1];
                $.ajax({
                     type: "POST",
                     url: "EditOrderPMc",
                     data: "message=" + message ,
                     success: function(data) {
                      window.location.href="EditOrderPM.jsp";
                       
                     },
                          error:function(jqXHR, textStatus, errorThrown) {
                            console.log(textStatus, errorThrown);
                          
                     }
                 });            
        });

                
        // Cancel an order.
       $(".cancel").click( function(){
                var id = ($(this).attr('id')).split("-");
                // This is the id of the order to be cancelled.
                var message = id[1];
                alert("Order "+message +" cancelled");
                $.ajax({
                     type: "POST",
                     url: "DeleteOrder",
                     data: "message=" + message ,
                     success: function(data) {
                    	 window.history.go(0);
                     console.log("data is sent");
                   },
                        error:function(jqXHR, textStatus, errorThrown) {
                          console.log(textStatus, errorThrown);                        
                  }
                 });            
        });
        
       var ids = []; 
       $( document ).ready(function() {
    	   $('.side').each(function() {
	    	   var innerHtml = $(this).attr('id').split("-");
	           var id = innerHtml[1];
	      	   ids.push(id);
    	   });
       });
       
        //filter trade.
        $( ".filter" ).change(function () {
          	var filterBy = $(".filter").find(":selected").text().trim().toLowerCase();
 
            
            if(filterBy == "all"){	
        		 $.each( ids, function( index, value ){
                      $("#"+value+"-data").show();                     
               });
        		 return;
        	} 
              
            $.each( ids, function( index, value ){
             	console.log("inside here --" + value);
             	$("#"+value+"-data").hide();
            	if($("#side-" + value).text().trim().toLowerCase() == filterBy){
                   $("#"+value+"-data").show();
                }
            });
                       
            
        });             
    </script>
   
</body>
</html>
