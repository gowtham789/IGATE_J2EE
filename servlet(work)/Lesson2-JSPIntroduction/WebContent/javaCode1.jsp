<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <h1>How to embed Java in JSP - 1</h1>
 
 <%
    out.print("<br/>Calculating sum of two numbers:");
    int number1=100;
    int number2=200;
    out.print("<br/>Number -1 "+number1);
    out.print("<br/>Number -2 "+number2);
    int sum=number1+number2;
    out.print("<br/>Sum "+sum);

 %>

</body>
</html>