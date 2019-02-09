<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer
 * Functionality: This is a Jsp, which will show after clicking mini statement link and,
 				  this will accept account id to get transactions
 * Models Used : None
 * Restrictions: IGATE PROPRIETARY INFORMATION, FOR IGATE USE ONLY    
 * Creation date: (04/22/16)
 * Modifications:
 * Author:            Date:          Change Description:
 * J2EE2-Group4     04/22/16          Initial Version
 ************************************************************************************** --%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<div id="min">MiniStatement/DetailedStatement</div><br><br>
<center>

<h2 align="center">Get Last 10 Transactions Here</h2>
<br>
<form action="ViewPrevTran.obj" method="post">
<table>
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
	<tr><td colspan="2" align="center"><br></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" id="button" value="Submit"/></td></tr>
</table>
<br>
</form>
<br>
 <h2 align="center">Click Below Link To Get Detailed Transactions </h2>
 <br>
 <br><a href="ViewOldTran.obj">Click Here</a>
</center>

</body>
</html>