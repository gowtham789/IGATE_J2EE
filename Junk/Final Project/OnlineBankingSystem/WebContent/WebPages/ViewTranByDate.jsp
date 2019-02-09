<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="WebPages/home.css"/>
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
<form name="frm">
<div id="min">Transaction Details</div>
<br>
<br>
<table align="center" id="view" border="1">
 	<tr>
 		<th >Account Id</th>
 		<th >TransactionId</th>
 		<th >Transaction Description</th>
 		<th >Transaction Date</th>
 		<th >Transaction Amount</th>
 	</tr>
 	<c:forEach items="${trandate}"  var="t">
	     <tr>
	    	<td>${mid}</td>
			<td>${t.transactionId}</td>
			<td>${t.transDesc}</td>
			<td>${t.date}</td>
			<td>${t.transAmt}</td>
			
		</tr>
	 </c:forEach>
</table>
</form>
<br>
<br>
 <a href="ministat">Go Back to previous page</a>
</body>
</html>