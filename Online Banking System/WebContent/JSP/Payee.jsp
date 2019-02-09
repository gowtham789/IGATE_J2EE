<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer
 * Functionality: This is a Jsp, which will shown after clciking make a transfer from fund transfer page
 				  and this page will ask the user to select id to get his payee details and displayed
 				  in this page after getting payee and ask the user to transfer money after selecting payee
 * Models Used : None
 * Restrictions: IGATE PROPRIETARY INFORMATION, FOR IGATE USE ONLY    
 * Creation date: (04/22/16)
 * Modifications:
 * Author:            Date:          Change Description:
 * J2EE2-Group4     04/22/16          Initial Version
 ************************************************************************************** --%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payee Page</title>
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
	<c:redirect url="LoginRequest.obj"/>
<%} %>
<body  onload="disableclick();">

<div id="min">Get Your Payee and Transfer Fund</div>

<br>

<c:if test="${insuff==1}">
<h2><font color="red">You Dont Have Sufficient Fund to transfer money</font></h2>
</c:if>

<c:if test="${count==0}">
<div align="center">
<form action="getMyPayees.obj" method="post">
	<table>
		<tr>
			<td>Select Account<font color="red">*</font></td>
			<td><select name="fromacct" required>
			<option value="">Select</option>
			<c:forEach var="ids" items="${acctid}">
			<option value="<c:out value="${ids.accountId}"/>"><c:out value="${ids.accountId}"/></option>
			</c:forEach>
			</select></td>
		</tr>
		<tr><td colspan="2"><br></td></tr>
		<tr><td colspan="2"><br></td></tr>
		<tr><td colspan="2" align="center"><input type="submit" id="button" value="GetPayee"/></td></tr>
	</table>
<br>
</form>
<div align="center"><a href="AddPayee.obj" >Add Payee</a></div>
<br>
<br>
</div>
<a href="fundtransfer.obj">Go Back </a>
</c:if>


<c:if test="${count==1}">
<div align="center">
<h2>Your Account and Your Payee Account</h2>
<form action="fundtrans.obj" method="post">
<table>
	<tr>
		<td>Selected Account Id<font color="red">*</font></td>
		<td><input type="text" value="${selectid}" readonly="readonly" name="fromacct"/></td>
	</tr>
	<tr>
		<td>Payee Account Id<font color="red">*</font></td>
		<td><select name="toacct" required>
		<option value="">Select</option>
		<c:forEach var="pids" items="${payid}">
		<option value="<c:out value="${pids.payeeId}"/>"><c:out value="${pids.payeeId}"/></option>
		</c:forEach>
		</select></td>
	</tr>
	<tr>
	<td>Enter Amount to Transfer<font color="red">*</font></td>
	<td><input type="text" name="amount" pattern="[0-9]+" 
	oninvalid="this.setCustomValidity('Enter Valid amount')"
			onchange="this.setCustomValidity('')" maxlength="6" required/></td>
	</tr>
	<tr><td colspan="2"><br></td></tr>
	<tr><td colspan="2"><br></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" id="button" value="Transfer"/></td></tr>
	<tr><td><br></td></tr>	
</table>
</form>
</div>
<br>
<br>
<a href="MakeTransfer.obj">Go Back </a>
</c:if>


<c:if test="${count==2}">
<h1>You Dont Have Any Payees Please add a payee to transfer money</h1>
<div align="center"><a href="AddPayee.obj" >Add Payee</a></div>
<br>
<br>
<a href="fundtransfer.obj" >Go Back </a>
</c:if>
</body>
</html>