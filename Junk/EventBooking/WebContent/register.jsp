<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>register</title>
</head>
<body bgcolor="grey">
<h1 align="center">Register Form</h1>
<form action="addDetails" name="add" method="post">
<table border="2" align="center" width="40%">
		
				<tr>
					<td>Name :</td>
					<td><input type="text" name="uname" /></td>
				</tr>
			<tr>
					<td> Event type:</td>
					
					<td><select name="etype">
				<option value="">Select</option>
				<c:forEach var="Events" items="${eventType}">

				<option value="${Events.eventtype}">${Events.eventtype}</option>
				</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td> Number Of Seats:</td>
				<td><input type="text" name="seats" /></td>
			</tr>
			
			<tr><td><input type="submit" value="Register"/></td></tr>
			
	
		</table>
	
	
	</form>
<h1 align="center">No of users registered: ${user1}</h1>



</body>
</html>