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
<title>Create Order</title>
</head>

<script>
	function alert_message() {

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
				<li class="active"><a href="CreateTrade.jsp">Create Order</a></li>
				<li><a href="OrderBlotter.jsp">Order Blotter</a></li>
				<li><a href="PMHistory.jsp">History</a></li>
			</ul>
		</div>
	</nav>
	<h2 style="margin-left: 146px;">Create Equity Order</h2>

	<div class="container">

		<div class="panel-group" id="accordion">
			<div class="panel panel-default">
				<div class="panel-heading">

					<!--   <div class="container">-->
					<div class="well">
						<form action="CreateOrder">
							<p>
								<font size="3"><b>Symbol: </b></font> <input type="text"
									name="symbol" style="margin-left: 153px;" required />
							</p>
							<p>
								<font size="3"><b>Side: </b></font> <select
									style="margin-left: 177px;" name="side" required>
									<option value="Buy">BUY</option>
									<option value="Sell">SELL</option>
								</select>
							</p>
							<p>
								<font size="3"><b>Order Type: </b></font> <select
									name="orderType" style="margin-left: 125px;" required>
									<option value="Market">Market</option>
									<option value="Limit">Limit</option>
									<option value="Stop-Limit">Stop-Limit</option>
									<option value="Stop">Stop</option>
								</select>
							</p>
							<p>
								<font size="3"><b>Order Qualifier: </b></font> <select
									name="qualifier" style="margin-left: 97px;" required>
									<option value="Day Order">Day Order</option>
									<option value="GTC">GTC</option>
								</select>
							</p>
							<!-- <p>
									<font size="3"><b>Trader: </b></font> <select name="traderId"
										style="margin-left: 159px;" required>
										<option value="T1">T1</option>
										<option value="T2">T2</option>
										<option value="T3">T3</option>
										<option value="T4">T4</option>
									</select>
								</p> -->
							<p>
								<font size="3"><b>Trader: </b></font> <input type="text"
									name="traderId" style="margin-left: 159px;" />

							</p>
							<p>
								<font size="3"><b>Account Type: </b></font> <select
									name="accountType" style="margin-left: 104px;" required>
									<option value="Cash">Cash</option>
									<option value="Margin">Margin</option>
								</select>
							</p>
							<!-- <p>
									<font size="3"><b>Portfolio: </b></font> <select
										name="portfolioId" style="margin-left: 143px;" required>
										<option value="P1">P1</option>
										<option value="P2">P2</option>
										<option value="P3">P3</option>
										<option value="P4">P4</option>
									</select>
								</p> -->
							<p>
								<font size="3"><b>Portfolio: </b></font> <input type="number"
									name="portfolioId" style="margin-left: 143px;" required />
							</p>
							<p>
								<font size="3"><b>Quantity: </b></font> <input type="number"
									name="qtyPlaced" style="margin-left: 142px;" required />
							</p>
							<p>
								<font size="3"><b>Stop Price: </b></font> <input type="text"
									name="stopPrice" style="margin-left: 127px;" />
							</p>
							<p>
								<font size="3"><b>Limit Price: </b></font> <input type="text"
									name="limitPrice" style="margin-left: 124px;" />
							</p>
							<input type="submit" class="btn btn-default" value="Create" />
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
	</div>
</body>
</html>
