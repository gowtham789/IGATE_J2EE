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
<h3>This is emp operation page</h3>
<h2>welcome</h2>

<c:out value="${UN}"/>
<hr/>
<a href="EmployeeController?action=DisplayAddEmpPage">Add emp</a></br>
<a href="EmployeeController?action=ListAllEmpPage">delete emp</a></br>
<a href="EmployeeController?action=ListAllEmpPage">list emp</a></br>
<a href="EmployeeController?action=ListAllEmpPage">update emp</a></br>
</body>
</html>