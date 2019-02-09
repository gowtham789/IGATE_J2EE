<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.igate.dto.PatientBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="8">
<tr>
<th><c:out value="Patient id"/></th>
<th><c:out value="name"/></th>
<th><c:out value="age"/></th>
<th><c:out value="Phone"/></th>
<th><c:out value="desc"/></th>
<th><c:out value="Consult date"/></th>
</tr>
<c:forEach items="${PatientList}" var="PatientBean"> 
<tr>
<td>${PatientBean.patientId }</td>
<td>${PatientBean.patientName }</td>
<td>${PatientBean.age }</td>
<td>${PatientBean.phone }</td>
<td>${PatientBean.description}</td>
<td>${PatientBean.consultDate}</td>
</tr>





</c:forEach>

</tr>

</table>
<a href="home">Homepage</a>



</body>
</html>