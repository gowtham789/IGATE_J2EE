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

<h2>Booking Id : ${bookingId}</h2>
<br>
<h2>  You Have Successfully Booked Tickets For :${event1.eventid }  </h2><br>
<h2>    Name : ${user.name}</h2>

<br>
<h2>   Event Name : ${event1.eventname }</h2>
<br>
<h2>   Location : ${event1.location }</h2>
<br>
<h2>     NUmber of seats : ${user.numofseats }</h2>
<a href="home">Go To Home Page</a>
</body>
</html>