<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:url var="action" value="insertCustomer.obj" />
	<form:form action="${action}" modelAttribute="cust" method="get">
	<table align="center" border="1">
		<tr>
			<td>Name : </td>
			<td><form:input path="name"/></td>
			<td><form:errors path="name" style="color: red;"></form:errors><br/></td>
		</tr>
		<tr>
			<td>Event Type : </td>
			<td><form:select path="eventType">	
			<c:forEach items="${eventType}" var="e">
				<option value="${e.eventType}">${e.eventType}</option>
			</c:forEach>
			</form:select></td>
			<td><form:errors path="eventType" style="color: red;"></form:errors><br/></td>
		</tr>
		
		<tr>
			<td>Number Of seats : </td>
			<td><form:input path="seats"/></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="register"/></td>
		</tr>
	</table>
	</form:form>
</body>
</html>