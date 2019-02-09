<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.igate.dto.PatientBean"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="search" method="post" name="viewdata">
<table>
<tr><th>Patient Id:</th><td><input type="text" name="id"/></td></tr>
<tr><th><input type="submit" value="submit" /></th></tr>
</table>
</form>
<%-- <% PatientBean patient=(PatientBean)session.getAttribute("pat");
if(patient!=null) {%>
<table>
<tr>
<th>PatientId</th>
<th>PatientName</th>
<th>Age</th>
<th>Phone</th>
<th>Description</th>
<th>ConsultationDate</th>
</tr>
<tr>
<td><%= patient.getPatientId()%></td>
<td><%= patient.getPatientName()%></td>
<td><%= patient.getAge()%></td>
<td><%= patient.getPhone()%></td>
<td><%= patient.getDescription()%></td>
<td><%= patient.getConsultationDate()%></td>
</tr>
</table>
<%} %> --%>
<h3><b><a href="home">Home</a></b></h3>
<c:choose>
		<c:when test="${!empty pat}">
			<table border="2" align="center">
				<tr>
					<th><c:out value="PatientId"/></th>
					<th><c:out value="PatientName"/></th>
					<th><c:out value="Age"/></th>
					<th><c:out value="Phone"/></th>
					<th><c:out value="Description"/></th>
					<th><c:out value="ConsultationDate"/></th>
				</tr>

				<tr>
					<td>${pat.patientId}</td>
					<td>${pat.patientName}</td>
					<td>${pat.age}</td>
					<td>${pat.phone}</td>
					<td>${pat.description}</td>
					<td>${pat.consultDate}</td>
				</tr>
			</table>
		</c:when>
	</c:choose>


</body>
</html>