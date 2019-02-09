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
<c:url var="myAction" value="/addEmp1.obj" />

<form:form action="${myAction}" modelAttribute="add1" method="get">
EmpId <form:input path="empId" type="text"/><br/>
	  
Name <form:input path="name" type="text"/><br/>
	 <form:errors path="name" cssStyle="color:red"/> 
	 
DOB <form:input path="dob" type="text"/><br/>
	<form:errors path="dob" cssStyle="color:red"/> 

Salary<form:input path="salary" type="text"/><br/>
	 
	  
Location <form:select path="location">
		<option value="hyd">Hyderabad</option>
		<option value="ban">Bangalore</option>
		<option value="pune">Pune</option>
		<option value="chn">Chennai</option>
		</form:select>
		
<input type="submit" value="Add"/>
</form:form>
</body>
</html>