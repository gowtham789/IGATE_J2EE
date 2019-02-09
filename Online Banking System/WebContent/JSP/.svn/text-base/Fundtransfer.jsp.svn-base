<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer
 * Functionality: This is a Jsp, where it is asked to accept from and to account to transfer fund,\
 				  how much money to be transfered
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

	<div id="min">Fund Transfer</div>
			
	<div align="center">
			
	<br>
	<h3>Here You can transfer fund to your own account</h3>		
	<br>
	<c:if test="${fundmsg==1}">
	<h3><font color="red">Money cannot be transferred to same account</font></h3>
	</c:if>
	<c:if test="${fundmsg==2}">
	<h3><font color="red">Please Enter Valid amount</font></h3>
	</c:if>
	<c:if test="${insuff==1}">
	<h3><font color="red">Insufficient Balance please check balance and try again</font></h3>
	</c:if>
	<c:if test="${id==0}">
	<h3><font color="red">Fund not Transferred Please try again</font></h3>
	</c:if>
	<c:if test="${fund==0}">
	<h3><font color="red">Fund not Transferred Please try again..</font></h3>
	</c:if>
	<c:if test="${transpass==0}">
	<h3><font color="red">Entered Wrong Transaction Password please try again...</font></h3>
	</c:if>
	
	<form name="trans" action="fundtrans.obj" method="post">
	
	<table>
	<tr>
		<td>Select From Account<font color="red">*</font></td>
		<td><select name="fromacct" required>
		<option value="">Select</option>
		<c:forEach var="ids" items="${acctid}">
		<option value="<c:out value="${ids.accountId}"/>"><c:out value="${ids.accountId}"/></option>
		</c:forEach>
		</select></td>
	</tr>
	
	<tr><td><br></td></tr>
	<tr>
		<td>Select To Account<font color="red">*</font></td>
		<td><select name="toacct" required>
		<option value="">Select</option>
		<c:forEach var="ids" items="${acctid}">
		<option value="<c:out value="${ids.accountId}"/>"><c:out value="${ids.accountId}"/></option>
		</c:forEach>
		</select></td>
	</tr>
	
	<tr><td><br></td></tr>
	
	<tr>
	<td>Enter Amount to Transfer<font color="red">*</font></td>
	<td><input type="text" name="amount" pattern="[0-9]+" 
	oninvalid="this.setCustomValidity('Enter Valid amount')"
			onchange="this.setCustomValidity('')" maxlength="6" required/></td>
	</tr>
	<tr><td><br></td></tr>
	

	<tr><td><input type="submit" id="button" value="Submit"/></td>
	<td><input type="reset" id="button" value="Reset"/></td></tr>
	</table>
	<br>
	<br>
	<h3>Click below link to transfer fund to others account of same bank</h3>	
	<br>
	<a href="MakeTransfer.obj">Make A Transfer</a>
	</form>
	</div>
</body>
</html>