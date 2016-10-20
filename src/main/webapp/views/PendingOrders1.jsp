
<% response.addHeader("Refresh","30"); %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.mock.project.model.Order"%>
<%@ page import="com.mock.project.model.Block"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ page isELIgnored="false"%>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
.optionsDiv {
padding-bottom:10px;
font-weight:bold;
}

.odd{}
.even{}

</style>
<title>Pending Orders</title>
  
</head>
<body>


<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Execution Trader</a>
    </div>
    <ul class="nav navbar-nav">
     
      <li ><a href="PopulateBB">View Blocks</a></li>
      <li class="active"><a href="updateTable" id="pending_orders" value="pending_orders">Pending Orders</a></li>
      
      <li><a href="PopulateTraderHistory">History</a></li>
    </ul>
  </div>

  

<div class="container">
<div class="well">
  <h2>Pending Orders</h2><br/>
  
  <div class="optionsDiv"><strong> Filter By Side: </strong><select id="selectField">
                              <option>All</option>
                              <option>Buy</option>
                              <option>Sell</option>
                              
                              </select></div>      


  
 
      <div class="Recommendations">
      <div style="height:300px;overflow-y:scroll;;">
    <div class="checkbox">
        
    <table class="table" id="PendingOrderTable">
    <tbody>
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
 
        

                       

                                                                     <c:forEach items='${Orders}' var="Orders">


                                                                            <tr position='${Orders.side }' >

                                                                                    <td><label><input type="checkbox" id="check"
                                                                                                    name="check" class="checkboxClick"></label></td>
                                                                                    <td><c:out value='${Orders.symbol}' /></td> 
                                                                                    <td ><c:out value='${Orders.side}' /></td>

                                                                                    <td><c:out value='${Orders.qtyPlaced}' /></td>
                                                                                    <td><c:out value='${Orders.limitPrice}' /></td>
                                                                                    <td><c:out value='${Orders.stopPrice}' /></td>
                                                                                    <td><c:out value='${Orders.price}' /></td>
                                                                                    <td><c:out value='${Orders.qtyExecuted}' /></td>
                                                                                    <td class="orderStatus"><c:out value='${Orders.status}' /></td>
                                                                                    <td><c:out value='${Orders.pmId}' /></td>
                                                                                    <td><c:out value='${Orders.accountType}' /></td>

                                                                                    <td><c:out value='${Orders.portfolioId}' /></td>

                                                                                    <td class="orderId"><c:out value='${Orders.orderId}' /></td>






                                                                            </tr>

                                                                     </c:forEach>


                                                             </tbody>
               

                                                     </table>
                                                                                                                                                                         
                                                                                            <button type="button" class="btn btn-success btn-sm" id="createBlock">Create
                       Block</button>

               <button type="submit" class="btn btn-info btn-sm"
                       data-toggle="collapse" data-target="#demo" id="add">Add to
                       Block</button>
                                                                            
                                                                            
                                              </div>
                                      </div>
                               </div>
                               <script>

    
    

    
    
    </script>

                               </tbody>
                               </table>
                       </div>
               </div>
               </div>



               <script>

    
    
    $(document).ready(function(){
        $('#createBlock').click(function() {
               var data=[];
        $('#PendingOrderTable tr').each(function()
        {
        if($(this).find("input[type=checkbox]").prop("checked")===true)
        {
               
               
               console.log("sakjs");
        var out=$(this).find('.orderId').html();
        console.log(out);
        data.push(out);
        }
         
        }
        );      
          console.log(data);  
          
          $.ajax({
                 type: "POST",
                 url: "createBlock",
                 dataType: 'json',
                 data:"data="+data,
                 success: function(data) {
                   console.log("data is sent");
                 }
               });
          
          alert("Order Added to Block");
          ref();
        });
       });
    
    function ref() {
    	window.location="updateTable";
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
            var rows = $("table#PendingOrderTable tr:not(:first-child)");
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

        
         <script>
        $(document).ready(function(){
               $('#add').click(function() {
                       var data1=[];
                       var data2=[];
                       var data3=[];
                       var random=false;
                       var replace = true;
                   $('#PendingOrderTable tr').each(function()
                   {
                         if($(this).find("input[type=checkbox]").prop("checked")===true)
                         {
                       
                       random=true;
               console.log("sakjs");
               var out1=$(this).find('.orderId').html();
               var out2=$(this).find('.orderSymbol').html();
               var out3=$(this).find('.orderSide').html();
               
               data1.push(out1);
               data2.push(out2);
               data3.push(out3);
               
               var firstelement1=data1[0];
               var firstelement2=data2[0];
               var firstelement3=data3[0];
               
               for(var i = 1; i < data1.length; i++)
               {
                   if(data2[i] != firstelement2 || data3[i] != firstelement3)
                   {
                       replace = false;
                       break;
                   }
               }
                         }
                   });

               if(replace)
               {
                       $.ajax({
                         type: "GET",
                         url: "recommendBlock",
                         dataType: 'json',
                         data:"data="+data1,
                         success: function(data1) {
                           console.log("data is sent");
                         }
                       });
                       alert("Order Added to Block");
                       ref();
               }
               else
               {
                       alert("please select order of same side and symbol");
               }
               
               
                   if(random==false){
                       alert("please select some order");
                   }
               });
               });
        
        
        
        </script>

                      <!--   </tbody></table></div></div> -->
            
        
          <script>
        
          $(document).ready(function(){
        $('#sub').click(function() {
               console.log("teststs");
               var data=[];
               var test=false;
        $('#recommendedBlocks tr').each(function()
        {
        if($(this).find("input[type=checkbox]").prop("checked")===true)
        {
               
               
        console.log("sakjdsaass");
        var out=$(this).find('.blockid').html();
        console.log(out);
        data.push(out);
        test=true;
        }
         
        }
        );      
          console.log(data);  
          if(test){
               alert("The order has been successfully added");
        
          $.ajax({
                 type: "GET",
                 url: "fetchOrder6",
                 dataType: 'json',
                 data:"data="+data,
                 success: function(data) {
                   console.log("data is sent");
                
                 }
               });
          }
          else
                 {
                 alert("Please select some block");
                 }
          
        });
               });

    
    </script>



     
     
      <script>

      
      function LoadData() {
    var myDataTable = $("#recommendedBlocks").jsp("<table><thead></thead><tbody></tbody></table>");
    $("table",myDataTable).dataTable({});
}
$(document).ready(function() {
    $("#recommendedBlocks").click(LoadData);
    LoadData();
})
</script>

       <div id="demo" class="collapse"> 
        
          <div class="Recommendations">
          <div style="height:200px;overflow-y:scroll;;">
           <table class="table" id="recommendedBlocks">
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
      <c:forEach items='${Blocks}' var="Blocks">   
        
                       <tr>
                       
                         <td> <label><input type="checkbox" id="checks" name="checks" class="checkboxClicks"></label></td>
                         <td class="blockid"><c:out value='${Blocks.blockId}'/></td>
               <td><c:out value='${Blocks.qtyPlaced}'/></td>
                         <td><c:out value='${Blocks.qtyExecuted}'/></td>
                         <td><c:out value='${Blocks.qtyPlaced-Blocks.qtyExecuted}'/></td>
                         <td><c:out value='${Blocks.limitPrice}'/></td>
                         <td><c:out value='${Blocks.stopPrice}'/></td>
                         <td><c:out value='${Blocks.status}'/></td> 
               
                       </tr>
                       </c:forEach> 
        </tbody></table>
                </div></div>
          <button type="submit" class="btn btn-info btn-sm" id="sub">OK
      </button>


               </div>


               <!-- <script>
    
    
    $(document).ready(function(){
        console.log(":asd")
        $('#ok').click(function() {
               console.log(":asd")
               var data1=0;
        $('#recommendedBlocks tr').each(function()
        {
        if($(this).find("input[type=checkbox]").prop("checked")===true)
        {
               
               
               console.log("hi");
        var data1=$(this).find('.blockid').html();
        //var out2=$(this).find('.orderSymbol').html();
        //var out3=$(this).find('.orderStatus').html();
        //var out4=$(this).find('.orderSide').html();
        console.log(data1);
        /*console.log(out2);
        console.log(out3);
        console.log(out4);*/
        
        //data.push(out2);
        //data.push(out3);
        //data.push(out4);
        }
         
        }
       );      
          console.log(data1);  
          
          $.ajax({
                 type: "GET",
                 url: "fetchOrder6",
                 dataType: 'json',
                 data:"data1="+data1,
                 success: function(data1) {
                   console.log("data is sent");
                 }
               });
          
          
        });
        });
    
    
    
    </script> -->
               </div>
               </div>
               </div>
        </nav>
</body>
</html>
