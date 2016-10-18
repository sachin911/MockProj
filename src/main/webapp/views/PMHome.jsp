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
<title>PM Home</title>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Portfolio Manager</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="PMHome.jsp">Home Page</a></li>		
				<li><a href="CreateTrade.jsp">Create Order</a></li>
				<li><a href="OrderBlotter.jsp">Order Blotter</a></li>
				<li><a href="PMHistory.jsp">History</a></li>


			</ul>
		</div>
		<div class="container">

			<div class="well">
				<h2>Portfolio</h2>

				<div class="container">

					<div class="panel-group" id="accordion">
						<div class="panel panel-default">
							<div class="panel-heading">

								<table class="table">

									<tr>
										<td>ID: 123</td>
										<td>IT Industry</td>
										<td>Profit/Loss</td>
										<td>
											<h4 class="panel-title">
												<a data-toggle="collapse" data-parent="#accordion"
													href="#collapse1"><button type="button"
														class="btn btn-default">+</button></a>
											</h4>
										</td>
									</tr>
								</table>
							</div>
							<div id="collapse1-edit" class="panel-collapse collapse">
								<div class="panel-body">Positions in portfolio</div>
							</div>
							<div id="collapse1" class="panel-collapse collapse ">
								<div class="panel-body">See Positions</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<table class="table">

									<tr>
										<td>ID: 1234</td>
										<td>Pharma Industry</td>
										<td>Profit/Loss</td>

										<td>
											<h4 class="panel-title">
												<a data-toggle="collapse" data-parent="#accordion"
													href="#collapse2"><button type="button"
														class="btn btn-default">+</button></a>
											</h4>
										</td>

									</tr>
								</table>
							</div>
							<div id="collapse2-edit" class="panel-collapse collapse">
								<div class="panel-body">Positions in portfolio</div>
							</div>
							<div id="collapse2" class="panel-collapse collapse">
								<div class="panel-body">See positions</div>
							</div>

						</div>
					</div>
	</nav>
</body>
</html>