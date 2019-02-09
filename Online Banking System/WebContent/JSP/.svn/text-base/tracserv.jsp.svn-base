<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer
 * Functionality: This is a Jsp, which will showna after clicking check service status
 				  from customer home page and ask customer to select the account id 
 * Models Used : None
 * Restrictions: IGATE PROPRIETARY INFORMATION, FOR IGATE USE ONLY    
 * Creation date: (04/22/16)
 * Modifications:
 * Author:            Date:          Change Description:
 * J2EE2-Group4     04/22/16          Initial Version
 ************************************************************************************** --%>

<head>
<meta charset="ISO-8859-1">
<title></title>
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
<div align="center">
<div id="min">Services Request Status</div>
<br>
<form action="displayservice.obj" name="track" method="post">
<table >

	<tr><td><br></td></tr>
	
	<tr><td><br></td></tr>
	
	<tr>
		<td>Select Account<font color="red">*</font></td>
		<td><select name="Accountid" required>
		<option value="">--Select--</option>
		<c:forEach var="ids" items="${acctid}">
		<option value="<c:out value="${ids.accountId}"/>">
		<c:out value="${ids.accountId}"/></option>
		</c:forEach>
		</select></td>
	</tr>
	
	<tr><td><br></td></tr>
	
	<tr>
	<td><input type="submit" id="button" value="Submit"/></td>
	<td><input type="reset" id="button" value="Reset" /></td>
	</tr>
</table>
</form>
</div>
</body>
</html>