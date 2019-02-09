<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer
 * Functionality: This is a Jsp, which will show transactions of particular id or all accounts 
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
	<c:redirect url="LoginRequest.obj"/>
<%} %>
<body  onload="disableclick();">
<div id="min" align="center">Transaction Details</div>
<br>
<div align="center">
<c:if test="${tids==0}"><h1><font color="red">No transactions available</font></h1>
</c:if>
</div>

<c:if test="${tids!=0}">
<table align="center" id="view" border="1">
 	<tr>
 		<th >TransactionId</th>
 		<th >Transaction Description</th>
 		<th >Transaction Type</th>
 		<th >Transaction Date</th>
 		<th >Transaction Amount</th>
 		<th>Account Id</th>
 	</tr>
 	<c:forEach items="${transids}"  var="t">
	     <tr>
			<td>${t.transactionId}</td>
			<td>${t.transDesc}</td>
			<td>${t.transType}</td>
			<td>${t.date}</td>
			<td>${t.transAmt}</td>
			<td>${t.accountId}</td>
			
		</tr>
	 </c:forEach>
</table>
</c:if>
<br>
<br>
<a href="getalltrans.obj" >Click here to go back</a>
</body>
</html>