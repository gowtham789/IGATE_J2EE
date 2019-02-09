<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="1">
<tr>
<th><c:out value="Event Id"/></th>
<th><c:out value="Event Name"/></th>
<th><c:out value="Location"/></th>
</tr>
<c:forEach var="Events" items="${viewEvents}">
<tr>

<td> <c:out value="${Events.eventid}"/></td>
<td><c:out value="${Events.eventname}"/></td>
<td><c:out value="${Events.location}"/></td>
<td><a href="viewbook?id=${Events.eventid}">BOOK</a></td>
</tr>
</c:forEach>
</table>

<a href="home">Go To Home Page</a>

</body>
</html>