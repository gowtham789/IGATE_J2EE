<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trainee Application</title>
</head>
<body>
<center>
<h1 style="color: #0066CC">Trainee Management System</h1>
</center>
<c:url var="myAction" value="viewDelete.obj"></c:url>
<form:form action="${myAction}" method="post" modelAttribute="trainee1">
	<center>
	<h2>Please Enter the Trainee ID</h2>
	<br>
	<form:input path="traineeId"></form:input> <br>
	<input type="submit" value="Delete" /></center>
</form:form>

<c:if test="${isFirst!=true}">
	<u>
	<h2 align="center">Trainee Information</h2>
	</u>
	<c:url var="myAction" value="delConfirm.obj"></c:url>
	<form:form action="${myAction}" method="post" modelAttribute="trainee1">
	<table border=1>
	<tr>
		<th bgcolor="bisque">Trainee Id</th>
		<th bgcolor="bisque">Trainee Name</th>
		<th bgcolor="bisque">Trainee Location</th>
		<th bgcolor="bisque">Trainee Domain</th>

	</tr>
	<tr>
			<td><c:out value="${trainee.traineeId}" /></td>
			<input type="hidden" name="id" value="${trainee.traineeId}"/>
			<td><c:out value="${trainee.traineeName}" /></td>
			<td><c:out value="${trainee.traineeLocation}" /></td>
			<td><c:out value="${trainee.traineeDomain}" /></td>
		
		</tr>
		<tr>
	<td><input type="submit" value="delete"/></td>
		</tr>
		<tr><td colspan="5" align="center"><a href="log.obj">Click
			Here To Go to Home</a></td></tr>
	
</table>

</form:form>

</c:if>

</body>
</html>