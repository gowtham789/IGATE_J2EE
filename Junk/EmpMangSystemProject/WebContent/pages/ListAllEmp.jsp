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
<h3>record list</h3>
<hr/>
<table border="1">
	<tr>
		<th>Empid</th>
		<th>EmpNAme</th>
		<th>Empsal</th>
		<th>do you want to edit</th>
		<th>do you wan to delete</th>
	</tr>EmpList
	<c:forEach var="empObj" items="${EmpList}">
		<tr>
			<td>${empObj.eid}</td>
			<td>${empObj.ename}</td>
			<td>${empObj.sal}</td>
			<td><a href="EmployeeController?action=DisplayEditEmpPage&empId=${empObj.eid}">Edit emp</a></td>
			<td><a href="EmployeeController?action=DisplayDeleteEmpPage&empId=${empObj.eid}">delete emp</a></td>
		</tr>
	</c:forEach>
</table>
</hr>
<a href="EmployeeController?action=DisplayAddEmpPage">Add emp again</a>
<a href="">log out</a>
</body>
</html>