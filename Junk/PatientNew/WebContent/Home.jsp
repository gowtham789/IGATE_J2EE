<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="grey">
<center>
<h1>Welcome to Patient Management System</h1>
<a href="viewPatients">View All Patient</a>
<br/>
<a href="viewById">View Patient By Id</a>

<br><br>

<a href="add">Add Patient</a>

<br><br>

<a href="log">Logout</a>

<%
Integer count = (Integer) session.getAttribute("tracker.count");
if (count == null)
	count = new Integer(1);
else
	count = new Integer(count.intValue() + 1);

session.setAttribute("tracker.count", count);
%>


<h4>No of times you have logged in is <%=session.getAttribute("tracker.count") %></h4>

</center>
</body>
</html>