<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:url var="myAction" value="retrieveTrainee.obj"></c:url>
<form:form action="${myAction}" method="post" modelAttribute="Add">
	<center>
	<h2>Enter the Trainee ID</h2>
	<br>
	<form:input path="traineeId"></form:input> <br>
	<input type="submit" value="Search" /></center>
</form:form>

<c:if test="${isFirst!=true}">
	<h2 align="center">Trainee Information</h2>
	
	<table border="1" align="center">
		<tr>
			<th bgcolor="bisque">Trainee Id</th>
			<th bgcolor="bisque">Trainee Name</th>
			<th bgcolor="bisque">Trainee Domain</th>
			<th bgcolor="bisque">Trainee Location</th>
		</tr>
		<tr>
			<td><c:out value="${dBean.traineeId}" /></td>
			<td><c:out value="${dBean.traineeName}" /></td>
			<td><c:out value="${dBean.traineeDomain}" /></td>
			<td><c:out value="${dBean.traineeLocation}" /></td>
		</tr>
		<tr>
			<td colspan="5" align="center"><a href="showLogin.obj.obj">Click
			Here To Go to Home</a></td>
		</tr>
	</table>

</c:if>
</body>
</html>