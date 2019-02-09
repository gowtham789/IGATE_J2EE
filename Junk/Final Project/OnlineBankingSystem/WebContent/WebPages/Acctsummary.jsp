<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Summary Page</title>
<link rel="stylesheet" href="WebPages/home.css"/>
</head>
<body>

<h2>Welcome ${user}</h2>
<br>
<div id="min">Select Account to Get Balance</div>
<div align="center">
<form action="./getbal" method="get">
<br>
<table >
<tr><td><br></td></tr>
<tr>
<td>Select Account<font color="red">*</font></td>
<td><select name="Accountid" required>
<option value="">--Select--</option>
<c:forEach var="ids" items="${acctid}">
	<option value="<c:out value="${ids}"/>"><c:out value="${ids}"/></option>
	</c:forEach>
</select></td></tr>
<tr><td><br></td></tr>
<tr><td><br></td></tr>
<tr><td><input type="submit" id="button" value="GetBalance"/></td></tr>
</table>

</form>
</div>

</body>
</html>