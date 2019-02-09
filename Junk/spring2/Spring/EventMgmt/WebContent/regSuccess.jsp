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
<c:url var="action" value="viewEvent.obj" />
	<form:form action="${action}" modelAttribute="cust" method="get">
			<form:input type="hidden" path="name"/>
			<form:errors path="name" style="color: red;"></form:errors>
			<form:input type="hidden" path="eventType"/>
			<form:errors path="eventType" style="color: red;"></form:errors>
			<form:input type="hidden" path="seats"/>
			
	
	<h1>Welcome ${cust.name }</h1><br/>
	<h2>You have Registered for the Event ${cust.eventType}</h2><br/>
	<input type="submit" value="register"/>
	Number Of Seats ${cust.seats}
	</form:form>
</body>
</html>