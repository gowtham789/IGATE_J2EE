<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer
 * Functionality: This is a Jsp, which will show service status of the customer upon selecting the account id
 * Models Used : None
 * Restrictions: IGATE PROPRIETARY INFORMATION, FOR IGATE USE ONLY    
 * Creation date: (04/22/16)
 * Modifications:
 * Author:            Date:          Change Description:
 * J2EE2-Group4     04/22/16          Initial Version
 ************************************************************************************** --%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>service status</title>
<link rel="stylesheet" href="JSP/Home.css"/>
<script type="text/javascript">
	document.onmousedown=disableclick;
	function disableclick()
	{
	//location.replace("http://localhost:8080/OnlineNetBanking/Loginserv");
	if(event.button==2)
		{
		
		alert("Right Click Disabled for security purpose");
		return false;
		}
	}
</script>

</head>
<%if(session.getAttribute("user")==null)
	{%>
	<c:redirect url="LoginRequest.obj"/>
<%} %>
<body  onload="disableclick();">
<center>
<h2 >Account Id Selected is ${trakid}</h2>
<br>
<div id="min">The Service Status For the Selected Id Are</div>
<br>
<br>
<table border="1">
<tr>
<th>Service Id</th>
<th>Status</th>
<th>Account Id</th>
<th>Service Description</th>
<th>Service Raised Date</th>
</tr>
<c:forEach var="service" items="${servdetails}">
<tr>

<td> <c:out value="${service.serviceId}"/></td>
<td><c:out value="${service.serviceStatus}"/></td>
<td><c:out value="${service.accountId}"/></td>
<td><c:out value="${service.serviceDesc}"/></td>
<td><c:out value="${service.serviceRaisedDate}"/></td>
</tr>
</c:forEach>
</table>

<br>
<br>
<a href="track.obj">Go Back</a>
</center>
</body>
</html>