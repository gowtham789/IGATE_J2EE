<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border='1'>
 <tr><th colspan='2'>Employee Info (Populate and display)</th></tr>
 <jsp:useBean id="employee" class="com.igate.dto.Employee" scope="application"/>
 <jsp:setProperty property="eid" value="200" name="employee"/>
 <jsp:setProperty property="enm" value="Uma" name="employee"/>
 <jsp:setProperty property="esl" value="55555.55" name="employee"/>
 <tr><td>ID</td><td><jsp:getProperty name="employee" property="eid"/></td></tr>
 <tr><td>Name</td><td><jsp:getProperty name="employee"  property="enm"/></td></tr>
 <tr><td>Salary</td><td><jsp:getProperty name="employee" property="esl"/></td></tr>
</table>




</body>
</html>