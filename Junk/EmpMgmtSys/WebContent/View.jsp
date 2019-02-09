<%@page import="com.igate.dto.Employee"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
	<h1>Welcome To Employee Management System</h1>
	<h3>
		You have logged in as
		<%=session.getAttribute("uname")%></h3>

	<table border=5>
		<tr>
			<td>Emp Id</td>
			<td>Name</td>
			<td>Salary</td>
			<td>Designation</td>
		</tr>
	<%-- Using JSTL --%>
	 <c:forEach var="emp" items="${employees}">
	     <tr>
			<td>${emp.empid }</td>
			<td>${emp.ename}</td>
			<td>${emp.salary }</td>
			<td>${emp.desig }</td>
			<td><a href="Delete?id=${emp.empid}">Delete</a></td>
		</tr>
	 
	 </c:forEach>

		<%-- using scriplets
		<%
			List<Employee> empList = (ArrayList) session.getAttribute("employees");
			for (Employee e : empList) {
		%>
		<tr>
			<td><%=e.getEmpid()%></td>
			<td><%=e.getEname()%></td>
			<td><%=e.getSalary()%></td>
			<td><%=e.getDesig()%></td>
			<td><a href="Delete?id=<%=e.getEmpid() %>">Delete</a></td>
		</tr>
		<%
			}
		%> --%>
	</table>
</body>
</html>