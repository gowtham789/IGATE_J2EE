<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!public boolean validate(String username,String password)
{
	if(username.equals("chnsiptrg4") && password.equals("igate@1234"))
	{
		return true;
	}
	else
	{
		return false;
	}
}
%>
<%boolean flag=validate(request.getParameter("uname"),request.getParameter("pwd"));
if(flag==true)
{%>
	<%@include file="success.jsp"%>
<%}
else
{%>
	<%@include file="Error.jsp"%>
<%}%>

</body>
</html>