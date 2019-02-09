<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer
 * Functionality: This is a Jsp, which will be shown for admin to get transaction,
 				  of particular account to be selected from this page
 * Models Used : None
 * Restrictions: IGATE PROPRIETARY INFORMATION, FOR IGATE USE ONLY    
 * Creation date: (04/22/16)
 * Modifications:
 * Author:            Date:          Change Description:
 * J2EE2-Group4     04/22/16          Initial Version
 ************************************************************************************** --%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel="stylesheet" href="JSP/Home.css"/>
<title>Insert title here</title>
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
<h1>Select Account to get transaction</h1>
<form action="gettransacs.obj" method="get">

<table >
	<tr><td><br></td></tr>
	
	<tr>
	<td>Select Account:</td>
	<td><select name="Accountid" required><font color="red">*</font>
	<option value="">--Select--</option>
	<c:forEach var="ids" items="${allids}">
	<option value="<c:out value="${ids.accountId}"/>"><c:out value="${ids.accountId}"/></option>
	</c:forEach>
	</select></td>
	</tr>
	
	<tr><td><br></td></tr>
	
	<tr><td align="center" colspan="2"><input type="submit" id="button" value="Submit"/></td></tr>
</table>
<br>
<br>
<br>
<a href="getalltransaction.obj">Click here to get all transactions of all accounts</a>
</form>
</div>
</body>
</html>