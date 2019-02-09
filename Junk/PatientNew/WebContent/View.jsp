<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.igate.dto.PatientBean" %>

<%@ page import="java.util.ArrayList" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="View" method="post">
<table>
<tr>
<td>PatientId:</td></tr>
<tr><td><input type="text" name="pid"/></td></tr>
<tr><td><input type="submit" value="submit" /></td></tr>
</table>
</form>
<% PatientBean pdto = (PatientBean) session.getAttribute("details"); %>
<% if(pdto.getPatientId()!=0)

{%>

<table>
<tr>
<th>patientId </th>
<th>patientName</th>
<th>Age</th>
<th>PhoneNumber</th>
<th>Description</th>
<th>Consultation_Date</th>
</tr>
<tr>
<td><%=pdto.getPatientId() %></td>
<td><%=pdto.getPatientName() %></td>
<td><%=pdto.getAge() %></td>
<td><%=pdto.getPhone() %></td>
<td><%=pdto.getDescription() %></td>
<td><%=pdto.getConsultDate()%>
</td>
</tr>
</table>
<%} %>

<a href="Home">Homepage</a>



</body>
</html>