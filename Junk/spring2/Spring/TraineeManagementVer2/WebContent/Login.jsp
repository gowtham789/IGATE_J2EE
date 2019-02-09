<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<c:url var="myAction" value="Loginuser.obj" />

<form:form method="post" modelAttribute="login" action="${myAction}">
<table>
<tr>
<td>UserName:</td>
<td><form:input type="text" path="user" name="uname"/></td>
</tr>

<tr>
<td>Password:</td>
<td><form:password path="password" name="pwd"/></td>
</tr>

<tr>
<td colspan="2" align="right"><input type="submit" value="Login"/></td>
</tr>

</table>
</form:form>
</body>
</html>