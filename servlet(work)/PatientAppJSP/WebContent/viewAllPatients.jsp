<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.cg.tc.dto.PatientDto"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	List<PatientDto> pList=(List<PatientDto>)session.getAttribute("patientList");
%>
 <table border="1">
<tr>
<td>PatientId</td>
<td>PatientName</td>
<td>Age</td>
<td>Phoneno</td>
<td>Description</td>
<td>Date</td>
</tr>

<%--  <% for(PatientDto patient:pList)
	{%>
<tr>	
<td><%= patient.getPatientId() %></td>
<td><%=	patient.getPatientName() %></td>
<td><%=	patient.getAge()  %></td>
<td><%=	patient.getPhoneNo()  %></td>
<td><%= patient.getDescription() %></td>
<td><%=	patient.getConsultationDate() %></td>
</tr>
<% } %>

</table> --%>

<c:forEach var="PatientDto" items="${patientList }">
<tr>
<td>${PatientDto.patientId }</td>
<td>${PatientDto.patientName }</td>
<td>${PatientDto.age }</td>
<td>${PatientDto.phoneNo }</td>
<td>${PatientDto.description }</td>
<td>${PatientDto.consultationDate }</td>
</tr>
</c:forEach>
</table>
<a href="home">Home</a>
</body>
</html>