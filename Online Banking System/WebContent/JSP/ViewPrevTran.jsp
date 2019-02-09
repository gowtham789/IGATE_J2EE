<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer
 * Functionality: This is a Jsp, which will be shown after selecting account id from mini statement page
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
<form name="frm">
<h2 align="center">Transaction Details</h2>
<table align="center" id="view" border="1">
 	<tr>
 		<th>Account Id</th>
 		<th>TransactionId</th>
 		<th>Transaction Description</th>
 		<th>Transaction Type</th>
 		<th>Transaction Date</th>
 		<th>Transaction Amount</th>
 	</tr>
 	<c:forEach items="${transactions}"  var="t">
	     <tr>
	     	<td>${pid}</td>
			<td>${t.transactionId}</td>
			<td>${t.transDesc}</td>
			<td>${t.transType}</td>
			<td>${t.date}</td>
			<td>${t.transAmt}</td>
			
		</tr>
	 </c:forEach>
</table>
</form>
<br/>
<br>
<br>
 <a href="ministat.obj">Go Back to previous page</a>
</body>
</html>