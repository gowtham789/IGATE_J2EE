<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>success</title>
</head>
<body align="center">
	<h2>Your firm is successfully registered.</h2>
	<br />
	<h2>Activate your account with following activation code</h2>
	<br>
	<c:out value="${actcode}"></c:out>
	<br />
	<a href="RegisterController?action=ShowHomePage">Home</a>
</body>
</html>