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
<title>Order Blotter</title>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Portfolio Manager</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="PMHome.jsp">Home Page</a></li>
				<li><a href="">Create Trader</a></li>
				<li class="active"><a href="#">Order Blotter</a></li>
				<li><a href="">History</a></li>
			</ul>
		</div>
		<div class="container">
			<div class="well">
				<h2>Order Blotter</h2>
				<div class="panel-group" id="accordion">
					<div class="panel panel-default">
						<div class="panel-heading">
							<table class="table">
								<tr>
									<th></th>
									<th>Order ID</th>
									<th>Symbol</th>
									<th>Name</th>
									<th>Side</th>
									<th>Status</th>
									<th>Quantity</th>
									<th>Type</th>
									<th></th>
									<th></th>
								</tr>
								<tr>
									<td><input type="checkbox" /></td>
									<td>123</td>
									<td>GOOG</td>
									<td>Google</td>
									<td>Sell</td>
									<td>New</td>
									<td>210</td>
									<td>Limit</td>
									<td>
									<a href=""><button type="button" class="btn btn-default">Edit</button></a>
									</td>
									<td>
									<a href=""><button type="button" class="btn btn-default">Cancel</button></a>
									</td>
								</tr>

								<tr>
									<td><input type="checkbox" /></td>
									<td>123</td>
									<td>GOOG</td>
									<td>Google</td>
									<td>Sell</td>
									<td>New</td>
									<td>210</td>
									<td>Limit</td>
									<td>
									<a href=""><button type="button" class="btn btn-default">Edit</button></a>
									</td>
									<td>
									<a href=""><button type="button" class="btn btn-default">Cancel</button></a>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
				<button type="button" class="btn btn-default">Send to
					Trader</button>
			</div>
		</div>
	</nav>
</body>
</html>