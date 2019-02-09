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
<body bgcolor="skyblue">
<h1 align="center">Enter Trainee Details</h1>

<c:url var="myAction" value="/addTrainee.obj" />

<form:form action="${myAction}" modelAttribute="Add" method="post">
<table align="center">
<tr><td>Enter EmpId:    </td><td> <form:input path="traineeId" type="text"/></td></tr>
								  
<tr><td>Enter Name:     </td><td> <form:input path="traineeName" type="text"/>
									 <form:errors path="traineeName"/></td></tr>

<tr><td>Trainee Location: </td><td> <form:radiobutton path="traineeLocation" label="Chennai" value="Chennai"/>
									<form:radiobutton path="traineeLocation" label="Banglore" value="Banglore"/>
									<form:radiobutton path="traineeLocation" label="Pune" value="Pune"/>
									<form:radiobutton path="traineeLocation" label="Mumbai" value="Mumbai"/>
					      </td></tr>
<tr>
<td> Trainee Domain: </td>
	<td><form:select path="traineeDomain">
			<form:option value="" label="Please Select"/>
			<form:options items="${domainList}"/>
	    </form:select></td>
</tr>

<tr>
<td><input type="submit" value="Add Trainee" name="add"/></td>
</tr>
</table>
</form:form>
</body>
</html>