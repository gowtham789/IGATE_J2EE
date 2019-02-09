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
<h1>  Welcome ${user.name} </h1>
<br>
<h2>You have registered for event ${user.eventtype}</h2><br>
<a href="view">View Events</a><br>
<h2>Number of Seats Opted ${user.numofseats}</h2><br>
</center>
</body>
</html>