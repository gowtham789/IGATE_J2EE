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
<h3>Update imp info...</h3>
<c:set var="ee" value="${EmpObj}"></c:set>

<form action="EmployeeController?action=EditEmpInfo" method="post">
Eid<input type="text" name="txtEid" value="${ee.eid}" readonly/><br/>
Edit name<input type="text" name="txtEname" value="${ee.ename}" /><br/>
Edit salary<input type="text" name="txtEsal" value="${ee.sal}" /><br/>
<input type="submit" name="btnUpdate" value="update emp info"/>
</form>

</body>
</html>