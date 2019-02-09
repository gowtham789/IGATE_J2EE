<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer
 * Functionality: This is a Jsp, which will show Account summary of the current user and to select account 
 				  To get balance
 * 
 * Models Used : None
 *  
 * Restrictions: IGATE PROPRIETARY INFORMATION, FOR IGATE USE ONLY    
 * Creation date: (04/22/16)
 * Modifications:
 * Author:            Date:          Change Description:
 * J2EE2-Group4     04/22/16          Initial Version
 ************************************************************************************** --%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Summary Page</title>
<link rel="stylesheet" href="JSP/Home.css"/>
</head>
<%if(session.getAttribute("user")==null)
	{%>
	<c:redirect url="LoginRequest.obj"/>
<%} %>
<body>

<h2>Welcome ${user}</h2>
<br>
<div id="min">Select Account to Get Balance</div>
<div align="center">
<form action="getbal.obj" method="get">
<br>
<table >
<tr><td><br></td></tr>
<tr>
<td>Select Account<font color="red">*</font></td>
<td><select name="accountId" required="true">
<option value="">--Select--</option>
<c:forEach var="ids" items="${acctid}">
	<option value="<c:out value="${ids.accountId}"/>"><c:out value="${ids.accountId}"/></option>
	</c:forEach>
</select></td></tr>
<tr><td><br></td></tr>
<tr><td><br></td></tr>
<tr><td><input type="submit" id="button" value="GetBalance"/></td></tr>
</table>

</form>
</div>

</body>
</html>