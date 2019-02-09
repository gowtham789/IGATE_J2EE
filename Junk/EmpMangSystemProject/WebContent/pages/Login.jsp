<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<hr/><b>this page is visited
<c:out value="${HitCount}"/>:times
<hr/>
<h3>Enter login Details</h3>
<form action="EmployeeController?action=ValidateUser" method="post">

	<table border="1">
	<tr>
	  <td>user name</td>
	  <td><input type="text" name="txtUname" value=""/></td>
	  <td>Error</td>
	</tr>
	<tr>
	  <td>Password</td>
	  <td><input type="password" name="txtPassword" value=""/></td>
	  <td>Error</td>
	</tr>
	<tr>
	  <td><input type="submit" name="btnLogin" value="Login"/></td>
	</tr>
	</table>
</form>
<hr/>
<%
	Cookie cookieArr[]=request.getCookies();
	String cookieName=null;
	String cookieVal=null;
	for(int i=0;i<cookieArr.length;i++)
	{
		cookieName=cookieArr[i].getName();
		cookieVal=cookieArr[i].getValue();
		if(cookieName.equals("HitCount"))
		{
			out.print("hi login.jsp was visited"+Integer.parseInt(cookieVal)+"times");
		}
			
	}
%>
</body>
</html>