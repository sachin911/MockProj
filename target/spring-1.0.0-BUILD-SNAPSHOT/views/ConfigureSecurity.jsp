<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h3>Broker</h3>
  <ul class="nav nav-pills">
    <li ><a href="BrokerMainScreen.jsp">Home</a></li>
    <li class="active"><a href="ConfigureSecurity.jsp">Configure</a></li>
    <li><a href="ViewFills.jsp">View Fills</a></li>
    <li><a href="Login.jsp">Logout</a></li>

  </ul>
</div>
<div class="container">
<table style="width:100%">
  <tr>
    <th>symbol</th>
    <th>max price spread</th>
    <th>exceuted per order</th>
    <th>  </th>
  </tr>
  <tr>
    <td>goog</td>
    <td>20%</td>
    <td>300</td>
    <td ><button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">edit</button></td>
  </tr>
  <tr>
    <td>appl</td>
    <td>10%</td>
    <td>1000</td>
    <td><button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">edit</button></td>
  </tr>
  <tr>
    <td>mmm</td>
    <td>50%</td>
    <td>500</td>
    <td><button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">edit</button></td>
  </tr>
</table>
</div>
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Edit configuration of Securities</h4>
      </div>
      <div class="modal-body">
        <p>
        <form method="post">
        Ticker: <input type="text" placeholder="Enter ticker">
        Price Spread: <input type="text" placeholder="Enter maximum price spread percentage">
        Maximum Execution: <input type="text" placeholder="Enter maximum number of orders per execution">
        <input type="submit" value="save">
        </form>
        </p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>

</body>
</html>



