<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page
	import="org.springframework.context.support.AbstractApplicationContext"%>
<%-- <% response.addHeader( "Refresh", "10"); %> --%>
<%@page import="com.mock.project.config.AppConfig"%>
<%@page
	import="org.springframework.context.annotation.AnnotationConfigApplicationContext"%>
<%@ page import="java.util.List"%>
<%@ page import="com.mock.project.model.Order"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style>
#creat-order-form {
	width: 80%;
	border:
}

.form-input-label {
	margin-bottom: 10px;
}

.form-input-fields {
	width: auto;
	margin-bottom: 10px;
	border-radius: 10px;
	border: 1px solid grey;
	padding: 4px;
}

.form-input-fields input, select {
	border: none;
	background-color: transparent;
}

.form-input-fields select:onfocus {
	border: none;
}

input[type="number"]:disabled {
	background-color: grey;
	border-radius: 10px;
	opacity: 0.3;
}

textarea:focus, select:focus, input:focus {
	outline: none;
}
$dia: 6em;
$outcolor: #fff;
$bdrwidth: 10px;
$time: 0.15s;

</style>

<script>
	var stopPrice;
	var limitPrice;

	function changetextbox(obj) {
		console.log(obj);
		var limit = document.getElementById("limit1");
		var stop = document.getElementById("stop1");
		stop.disabled = (obj.value == "limit" || obj.value == "market");
		limit.disabled = (obj.value == "stop" || obj.value == "market");
		if (obj.value == "limit") {
			limit.value = limitPrice;
			stop.value = "";
		} else if (obj.value == "stop") {
			limit.value = "";
			stop.value = stopPrice;
		} else if (obj.value == "stoplimit") {
			limit.value = limitPrice;
			stop.value = stopPrice;
		} else {
			limit.value = "";
			stop.value = "";
		}
	}

	$(document).ready(function() {
		var hiddenOrderType = document.getElementById("hiddenOrderType").value;
		var hiddenQualifier = document.getElementById("hiddenQualifier").value;
		var hiddenAccountType = document.getElementById("hiddenAccountType").value;
		
		var OrderTypeId = document.getElementById(hiddenOrderType);
		OrderTypeId.selected = true;
		
		var QualifierId = document.getElementById(hiddenQualifier);
		QualifierId.selected = true;
		
		var AccountTypeId = document.getElementById(hiddenAccountType);
		AccountTypeId.selected = true;
		
		stopPrice = document.getElementById("stop1").value;
		limitPrice = document.getElementById("limit1").value;
		var select = document.getElementById("orderType");
		changetextbox(select);
		
		
		$.ajax({
            type: "POST",
            url: "fetchTraderList",
            success: function(data) {
				console.log(data);
            	createTraderNameList(data);
            },
            error:function(jqXHR, textStatus, errorThrown) {
              console.log(textStatus, errorThrown);      
            }
       	});
		
		function createTraderNameList(data){
			var a = data.split(',');
			for(i=0;i<a.length-1;i++){
				var option=document.createElement("option");
				option.value=a[i];
				option.text=a[i];
				document.getElementById("trader").appendChild(option);
			}
		}
		
	});
</script>

<title>Trading Application</title>
</head>

<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="./PMHome.jsp">Portfolio Manager</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="./PMHome.jsp">Home</a></li>
				<li><a href="./CreateTrade.jsp">Create Order</a></li>
				<li><a href="ViewOrderBlotter">Order Blotter</a></li>
				<li><a href="ViewPendingOrder">Pending Orders</a></li>
				<li><a href="GeneralView">History</a></li>
			</ul>
		</div>
	</nav>
	<div id="creat-order-form" class="container well">
		<h2 id="eqorder">Edit Equity Order</h2>
		<%
			Order o = (Order) request.getSession().getAttribute("Orders");
		%>
		<form action="EditOrder" method="post">
			<div class="well">

				<div class="row">
					<div id="" class="form-input-label col col-sm-4">Order Id:</div>
					<div class="form-input-fields col col-sm-8">
						<input type="text" id="orderId" name="orderId1"
							value='<%=o.getOrderId()%>' readonly />
					</div>
				</div>

				<div class="row">
					<div id="" class="form-input-label col col-sm-4">Symbol:</div>
					<div class="form-input-fields col col-sm-8">
						<input type="text" id="symbol" name="symbol1"
							value='<%=o.getSymbol()%>' readonly />
					</div>
				</div>
				<div class="row">
					<div id="" class="form-input-label col col-sm-4">Side:</div>
					<div class="form-input-fields col col-sm-8">
						<input type="text" id="side" name="side1"
							value='<%=o.getSide()%>' readonly/>
					</div>
				</div>

				<div class="row">
					<div id="" class="form-input-label col col-sm-4">Order Type:
					</div>
					<div class="form-input-fields col col-sm-8">
						<select id="orderType" name="orderType1"
							onchange="changetextbox(this)">
							<option value="market" id="market">Market</option>
							<option value="limit" id="limit">Limit</option>
							<option value="stoplimit" id="stoplimit">Stop-Limit</option>
							<option value="stop" id="stop">Stop</option>
						</select>
					</div>
				</div>

				<div class="row">
					<div id="" class="form-input-label col col-sm-4">Order
						Qualifier:</div>
					<div class="form-input-fields col col-sm-8">
						<%-- <input type="text" id="orderqual" name="orderqual1"
							value='<%=o.getQualifier()%>'> --%>
						<select name="orderqual1" id="orderqual">
							<option value="GTD" id="GTD"> GTD</option>
                  			<option value="GTC" id="GTC"> GTC</option>
						</select>
					</div>
					<input type="hidden" id="hiddenOrderType" value='<%=o.getOrderType()%>'/>
					<input type="hidden" id="hiddenQualifier" value='<%=o.getQualifier()%>'/>
					<input type="hidden" id="hiddenAccountType" value='<%=o.getAccountType()%>'/>
				</div>
				<div class="row">
					<div id="" class="form-input-label col col-sm-4">Account
						Type:</div>
					<div class="form-input-fields col col-sm-8">
						<%-- <input type="text" id="acctype" name="acctype1"
							value='<%=o.getAccountType()%>'> --%>
						<select id="acctype" name="acctype1">
							<option value="Cash" id="Cash"> Cash</option>
                  			<option value="Margin" id="Margin"> Margin</option>
						</select>
					</div>
				</div>

				<div class="row">
					<div id="" class="form-input-label col col-sm-4">Quantity:</div>
					<div class="form-input-fields col col-sm-8">
						<input type="number" id="qtyPlaced" name="qtyPlaced1" min="1"
							value='<%=o.getQtyPlaced()%>'>
					</div>
				</div>

				<div class="row">
					<div id="" class="form-input-label col col-sm-4">Trader:</div>
					<div class="form-input-fields col col-sm-8">
						<%-- <input type="text" id="trader" name="trader1"
							value='<%=o.getTraderId()%>'> --%>
						<select id="trader" name="trader1"></select>
					</div>
				</div>

				<div class="row">
					<div id="" class="form-input-label col col-sm-4">Portfolio:</div>
					<div class="form-input-fields col col-sm-8">
						<%-- <input type="text" id="portfolio" name="portfolio1"
							value='<%=o.getPortfolioId()%>'> --%>
						<select id="portfolio" name="portfolio1">
							<option value="Mining">Mining</option>
      						<option value="Banking">Banking</option>
      						<option value="Automobile">Automobile</option>
      						<option value="Energy">Energy</option>
      						<option value="Textile">Textile</option>
      						<option value="Pharma">Pharma</option>
      						<option value="FMCG">FMCG</option>
      						<option value="Cement">Cement</option>
      						<option value="Aluminium">Aluminium</option>
      						<option value="Transportation">Transportation</option>
      						<option value="Other">Other</option>
						</select>
					</div>
				</div>

				<div class="row">
					<div id="stop" class="form-input-label col col-sm-4">Stop
						Price:</div>
					<div class="form-input-fields col col-sm-8">
						<input type="number" id="stop1" name="stop1" step="any"
							value='<%=o.getStopPrice()%>'>
					</div>
				</div>

				<div class="row">
					<div id="limit" class="form-input-label col col-sm-4">Limit
						Price:</div>
					<div class="form-input-fields col col-sm-8">
						<input type="number" id="limit1" name="limit1" step="any"
							value='<%=o.getLimitPrice()%>'>
					</div>
				</div>

				<input type="submit" class="btn btn-default" value="Save" />

			</div>
		</form>

	</div>
</body>
</html>