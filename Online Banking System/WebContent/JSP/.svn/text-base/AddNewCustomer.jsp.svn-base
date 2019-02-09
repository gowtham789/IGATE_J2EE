<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer
 * Functionality: This is a Jsp, which will show a form to Customer Details
 * Models Used : CustomerDTO
 * Restrictions: IGATE PROPRIETARY INFORMATION, FOR IGATE USE ONLY    
 * Creation date: (04/22/16)
 * Modifications:
 * Author:            Date:          Change Description:
 * J2EE2-Group4     04/22/16          Initial Version
 ************************************************************************************** --%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
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
<body>
<div id="min">Enter Customer Details</div>
<br>
<c:if test="${emailexits==1}">
<h2><font color="red">Email Already Exists</font></h2>
</c:if>
<c:if test="${mobileexists==1}">
<h2><font color="red">Mobile Number Already Exists</font></h2>
</c:if>
<c:if test="${pancardexists==1}">
<h2><font color="red">Pancard Already Exists</font></h2>
</c:if>
<br>
<form:form modelAttribute="cdto" method="get" action="Insertcustomer.obj">
	<table align="center" cellpadding="8" cellspacing="8">
		
		<tr>
		<td>Customer Name<font color="red">*</font></td>
		<td><form:input path="custName" required="true" id="id1"/></td>
		<td><form:errors path="custName" cssStyle="color:red"/></td>
		</tr>
	
		<tr>
		<td>Address<font color="red">*</font></td>
		<td><form:textarea rows="3" path="address" required="true" id="id1"/></td>
		<td><form:errors path="address" cssStyle="color:red"/></td>
		</tr>
		
		<tr>
		<td>Email<font color="red">*</font></td>
		<td><form:input path="email" required="true" id="id1"/></td>
		<td><form:errors path="email" cssStyle="color:red"/></td>
		</tr>
		
		<tr>
		<td>PanCard<font color="red">*</font></td>
		<td><form:input path="pancard" required="true" id="id1"/></td>
		<td><form:errors path="pancard" cssStyle="color:red"/></td>
		
		<tr>
		<td>MobileNumber<font color="red">*</font></td>
		<td><form:input path="mobileNumber" required="true" id="id1"/></td>
		<td><form:errors path="mobileNumber" cssStyle="color:red"/></td>
		
		<tr>
		<td><input type="submit" value="Submit" id="button"/></td>
		<td><input type="reset" value="Reset" id="button"/></td>
		</tr>
		
	</table>
</form:form>
</body>
</html>