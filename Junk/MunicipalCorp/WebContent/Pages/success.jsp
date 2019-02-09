<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.time.LocalDateTime"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>account activated</title>
</head>
<body>
	<h1>
		Your account activated successfully on
		<%
		LocalDateTime current = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter
				.ofPattern("dd-MM-yyyy hh:mm:ss");
		String date = current.format(formatter);
	%>
		<%=date%>

	</h1>
	<br />
	<a href="RegisterController?action=ShowHomePage">Home</a>
</body>
</html>