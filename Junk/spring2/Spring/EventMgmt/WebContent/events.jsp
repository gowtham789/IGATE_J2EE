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
	<table align="center">
	<c:url var="action" value="book.obj" />
	<form:form action="${action}" modelAttribute="cust" method="get">
			<form:input type="hidden" path="name"/>
			<form:errors path="name" style="color: red;"></form:errors>
			<form:input type="hidden" path="eventType"/>
			<form:errors path="eventType" style="color: red;"></form:errors>
			<form:input type="hidden" path="seats"/>
	
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Location</th>
			<th>Type</th>
		</tr>
			<c:forEach items="${list}" var="e">
				<tr>
					<td>${e.eventId }</td>
					<td>${e.eventname }</td>
					<td>${e.location }</td>
					<td>${e.eventType }</td>
					
					
	
					<td><input type="submit" name="submit" value="${e.eventId}"/></td>
			
				</tr>
			</c:forEach>
		</form:form>
	</table>
</body>
</html>