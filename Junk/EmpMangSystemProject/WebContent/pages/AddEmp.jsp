
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Insert emp info</h3>
	<form action="EmployeeController?action=addEmp" method="post">
	EmpId:<input type='text' name='txtEmpId' value='<c:out value="${EmpId}"></c:out>'
	readonly/><br/>
	EmpName:<input type="text" name="TxtEmpName" value=""/><br/>
	EmpSal:<input type="text" name="TxtEmpSal" value=""/><br/>
	<input type="submit" name="btnAddEmp" value="AddEmp">
	 
	
	</form>
</body>
</html>