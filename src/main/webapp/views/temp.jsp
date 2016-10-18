<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.List" %>
    <%@ page import="com.mock.project.model.Order"%>
    <%@ page import="com.mock.project.model.Block"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <table class="table table-bordered">
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
      <%-- <c:forEach items='${Blocks}' var="Blocks">    --%>
        
			<tr>
			recomen
			  <td> <label><input type="checkbox" id="check" name="check" ></label></td>
			  <td><c:out value='${Blocks.blockId}'/></td>
			  <td><c:out value='${blocks.qtyPlaced}'/></td>
			  <td><c:out value='${blocks.qtyExecuted}'/></td>
			  <td><c:out value='${blocks.qtyPlaced-blocks.qtyExecuted}'/></td>
			  <td><c:out value='${blocks.limitPrice}'/></td>
			  <td>teest</td>
			  <td><c:out value='${blocks.status}'/></td>
		
			</tr>
			<%-- </c:forEach>  --%>
        </tbody></table>
</body>
</html>