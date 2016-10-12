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
<style>
table {
    border-collapse: separate;
    border-spacing: 0 1em;
}
</style>
</head>
<body>

<div class="container">
  <h3>Broker</h3>
  <ul class="nav nav-pills">
    <li class="active"><a href="#">Home</a></li>
    <li><a href="ConfigureSecurity.jsp">Configure</a></li>
    <li><a href="ViewFills.jsp">View Fills</a></li>
  </ul>
</div>
<div class="container">
<table style="width:100%">
  <tr>
    <th>symbol</th>
    <th>type</th>
    <th>status</th>
  </tr>
  <tr>
    <td>goog</td>
    <td>market</td>
    <td>open</td>
  </tr>
  <tr>
    <td>appl</td>
    <td>limit</td>
    <td>partial</td>
  </tr>
  <tr>
    <td>mmm</td>
    <td>stop</td>
    <td>completed</td>
  </tr>
</table>
</div >
 <div class="container">
<form method="post"> 
<input type="submit" value="stop" class=".selectedButton">
</form>
</div>
</body>
</html>



