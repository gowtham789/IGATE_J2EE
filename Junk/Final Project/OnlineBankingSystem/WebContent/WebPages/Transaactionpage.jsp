<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link  rel="stylesheet" href="Webpages/home.css"/>
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
	<c:redirect url="/LoginRequest"/>
<%} %>
<body  onload="disableclick();">
<div id="min" align="center">Transaction Details</div>
<br>
<table align="center" id="view" border="1">
 	<tr>
 		<th >TransactionId</th>
 		<th >Transaction Description</th>
 		<th >Transaction Date</th>
 		<th >Transaction Amount</th>
 		<c:if test="${tids==1}"><th>Account Id</th></c:if>
 	</tr>
 	<c:forEach items="${transids}"  var="t">
	     <tr>
			<td>${t.transactionId}</td>
			<td>${t.transDesc}</td>
			<td>${t.date}</td>
			<td>${t.transAmt}</td>
			<c:if test="${tids==1}"><td>${t.accountId}</c:if>
			
		</tr>
	 </c:forEach>
</table>
<br>
<br>
<a href="./getalladmin" >Click here to go back</a>
</body>
</html>