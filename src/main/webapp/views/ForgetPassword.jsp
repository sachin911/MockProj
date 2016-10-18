<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Change Password</h1>
<table align="center">
<form method="post" action="changepassword">
<tr><td>Username:</td></tr><tr><td><input type="text" name="username"/></td></tr>
<tr><td>SecretKey:</td></tr><tr><td><input type="text" name="secret_key"/></td></tr>
<tr><td>NewPassword:</td></tr><tr><td><input type="password" name="newpass"/></td></tr>
<tr><td>ConfirmPassword:</td></tr><tr><td><input type="password" name="confirmpass" /></td></tr>
<tr><td></td></tr><tr><td><input type="submit" name="submit" value="submit"/></td></tr>
</form>


</table>

</body>
</html>