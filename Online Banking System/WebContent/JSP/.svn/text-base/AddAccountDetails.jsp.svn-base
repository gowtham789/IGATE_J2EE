<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer
 * Functionality: This is a Jsp, which will show form to add account details
 * Models Used : AccountDTO
 * Restrictions: IGATE PROPRIETARY INFORMATION, FOR IGATE USE ONLY    
 * Creation date: (04/22/16)
 * Modifications:
 * Author:            Date:          Change Description:
 * J2EE2-Group4     04/22/16          Initial Version
 ************************************************************************************** --%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
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
<style type="text/css">
#id1
{
border-radius:10px; 
}
#min
{
	font-family:times new roman;
	font-style: italic;
	font-weight: bold;
	font-size:25px;
	border-radius:15px;
	width:100%;
	text-align:center;
	margin-top: 50px;
	background-color: #a4a4a4;
}
#button
{
	border-radius:15px;
	width: 100px;
	height:40px;
	font-family:Monotype Corsiva;
	font-weight:bold;
	font-size:20px;
	background-color:#c4ffff;
}
</style>
</head>
<%if(session.getAttribute("user")==null)
	{%>
	<c:redirect url="LoginRequest.obj"/>
<%} %>
<body>
<div id="min">Enter Customer Account Details</div>
<br>
<c:if test="${bal==1 }">
<h2><font color="red">Balance Should be greater than Zero</font></h2>
</c:if>
<br>
<form:form modelAttribute="adto" method="get" action="Insertacc.obj">
		<table align="center" cellpadding="8" cellspacing="8">
			<tr>
			<td>AccountBalance <font color="red">*</font></td>
			<td><form:input path="accountBalance" id="id1" required="true" pattern="[0-9]+"
			oninvalid="this.setCustomValidity('Enter Valid Amount')"
				onchange="this.setCustomValidity('')"/></td>
			<td><form:errors path="accountBalance" cssStyle="color:red"/></td>
			</tr>
			
			<tr>
			<td>Account Type <font color="red">*</font></td>
			<td><form:select path="accountType" id="id1" required="true">
			<form:option value="">--Select--</form:option>
			<form:option value="SAVINGS">Savings</form:option>
			</form:select></td>
			<td><form:errors path="accountType" cssStyle="color:red"/></td>
			</tr>
			
			<tr>
			<td><input type="submit" value="Submit" id="button"/></td>
			<td><input type="reset" value="Reset" id="button"/></td>
			</tr>
		</table>
</form:form>
</body>
</html>