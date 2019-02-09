<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trainee Form</title>
</head>
<body>
<center>
<h1 style="color:#0066CC">
Welcome to Trainee Management System
</h1>
	<br/><br/>
	
<!--This code below displays the form to add a trainee to the database	-->
<h3>Please Enter the Trainee Details</h3>
<c:url var="myAction" value="/addTrainee1.obj"></c:url> 
	<form:form action="${myAction}" method="post" modelAttribute="trainee1">
	<table bgcolor="#DCDCDC">

		<tr>
			<td>Trainee Id:<span style="color:red;">*</span></td>
			<td><form:input path="traineeId" /></td>
			<td style="color: red;">
			

		</tr>

		<tr>
			<td>Trainee Name:<span style="color:red;">*</span></td>
			<td><form:input path="traineeName" /></td>
			<td style="color: red;"><form:errors path="traineeName"></form:errors></td>

		</tr>

		<tr>
			<td>Trainee Location:<span style="color:red;">*</span></td>
			<td><form:radiobutton path="traineeLocation" value="Chennai" label="Chennai" />
                <form:radiobutton path="traineeLocation" value="Bangalore" label="Bangalore" />
                <form:radiobutton path="traineeLocation" value="Pune" label="Pune" />
                <form:radiobutton path="traineeLocation" value="Mumbai" label="Mumbai" />
                <br/></td>
			<td style="color: red;">
			<form:errors path="traineeLocation"></form:errors></td>

		</tr>

		<tr>
			<td>Trainee Domain:<span style="color:red;">*</span></td>
			<td><form:select path="traineeDomain"> 
				<form:option value="" label="Please Select"/>
				<form:option value="JEE" label="JAVA" />
				<form:option value=".NET" label=".NET" />
				<form:option value="Python" label="Python" />
  				</form:select></td>
			<td style="color: red;"><form:errors path="traineeDomain"></form:errors></td>

		</tr>

		
		<tr>
			<td colspan="2"><input type="submit" name="submit"
				value="Add Trainee"></input></td>
		</tr>
	</table>

</form:form><br>

</body>
</html>