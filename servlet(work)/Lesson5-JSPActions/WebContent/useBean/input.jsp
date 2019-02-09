<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Enter Employee Details</h1>

<!-- Change action="output3.jsp" to directly send input to JSP  -->

<form action="output3.jsp" method="post">
<table>
  <tr><td>Enter ID</td><td><input type="text" name="eid"/></td></tr>
  <tr><td>Enter Name</td><td><input type="text" name="enm"/></td></tr>
  <tr><td>Enter Salary</td><td><input type="text" name="esl"/></td></tr>
  <tr><td colspan="2"><input type="submit" value="Ok"/></td></tr>
</table>
</form>

</body>
</html>