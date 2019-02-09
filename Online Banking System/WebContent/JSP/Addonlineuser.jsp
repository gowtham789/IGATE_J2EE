<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer
 * Functionality: This is a Jsp, which will show form to add online details of the customer
 * Models Used : UserDTO
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
<div id="min">Enter Customer Online Details</div>
<br>
<c:if test="${exists==1 }">
<h2><font color="red">Login Id already exists</font></h2>
</c:if>
<c:if test="${insertfailed==1 }">
<h2><font color="red">Due to technical issues Account not Added......please try again</font></h2>
</c:if>
<br>
<form:form modelAttribute="udto" method="get" action="Insertonline.obj">
	<table align="center" cellpadding="8" cellspacing="8">
		<tr>
		<td>Login Id<font color="red">*</font></td>
		<td><form:input path="userId" required="true" id="id1"/></td>
		<td><form:errors path="userId" cssStyle="color:red"/></td>
		</tr>
		
		<tr>
		<td>Login Password<font color="red">*</font></td>
		<td><form:password path="loginPwd" required="true" id="id1"/></td>
		<td><form:errors path="loginPwd" cssStyle="color:red"/></td>
		</tr>
		
		<tr>
		<td>Transaction Password<font color="red">*</font></td>
		<td><form:password path="transactionPwd" required="true" id="id1"/></td>
		<td><form:errors path="transactionPwd" cssStyle="color:red"/></td>
		</tr>
		
		<tr>
		<td>Secret Question<font color="red">*</font></td>
		<td><form:select path="secretQuest" required="true" id="id1">
		<form:option value="">-Select-</form:option>
		<c:forEach var="Service" items="${user}">
		<form:option value="${Service.secretQuest}">${Service.secretQuest}</form:option>
		</c:forEach>
		</form:select></td>
		<td><form:errors path="secretQuest" cssStyle="color:red"/></td>
		</tr>
		
		<tr>
		<td>Answer<font color="red">*</font></td>
		<td><form:input path="answer" required="true" id="id1"/></td>
		<td><form:errors path="answer" cssStyle="color:red"/></td>
		</tr>
		
		<tr>
		<td><input type="submit" value="Submit" id="button"/></td>
		<td><input type="reset" value="Reset" id="button"/></td>
		</tr>
	</table>
</form:form>
</body>
</html>