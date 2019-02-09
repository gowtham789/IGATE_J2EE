<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer
 * Functionality: This is a Jsp, which will have links for bank related pages like aboutus,help etc
 * Models Used : None
 * Restrictions: IGATE PROPRIETARY INFORMATION, FOR IGATE USE ONLY    
 * Creation date: (04/22/16)
 * Modifications:
 * Author:            Date:          Change Description:
 * J2EE2-Group4     04/22/16          Initial Version
 ************************************************************************************** --%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link  rel="stylesheet" href="JSP/Home.css"/>
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
	<c:redirect url="LoginRequest.obj"></c:redirect>
<%} %> 
<body  onload="disableclick();">
<br>
<table align="center">

	<tr>
	
	<td>Mybank&copy; Copyright</td>
	<td>&nbsp;</td>
	<td><a href="Aboutus.obj" target="right">AboutUs</a></td>
	<td>&nbsp;</td>
	<td><a href="Services.obj" target="right">Services</a></td>
	<td>&nbsp;</td>
	<td><a href="Contactus.obj" target="right">ContactUs</a></td>
	<td>&nbsp;</td>
	<td><a href="Help.obj" target="right">Help</a></td>
	<td>&nbsp;</td>
	
	<td><a href="Logout.obj" target="_top">Logout</a></td>
	
	</tr>

</table>
</body>
</html>