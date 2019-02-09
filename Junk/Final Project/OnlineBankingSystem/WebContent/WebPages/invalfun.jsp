<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link  rel="stylesheet" href="WebPages/home.css"/>
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
<h2><font color="red">${fundmsg}</font></h2>
<div id="min">Fund Transfer</div>
			<div align="center">
			
			<br>
			<br><br>
	<form name="trans" action="./fundtrans" method="post">
	
	<table>
	<tr>
		<td>Select From Account:</td>
		<td><select name="fromacct">
		<option value="">Select</option>
		<c:forEach var="ids" items="${acctid}">
		<option value="${ids}">${ids}</option>
		</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td>Select To Account:</td>
		<td><select name="toacct">
		<option value="">Select</option>
		<c:forEach var="ids" items="${acctid}">
		<option value="${ids}">${ids}</option>
		</c:forEach>
		</select></td>
	</tr>
	
	<tr>
	<td>Enter Amount to Transfer</td>
	<td><input type="text" name="amount"/></td>
	</tr>
	</table>

<input type="submit" id="button" value="Submit"/>
<br><br><br>
<a href="./MakeTransfer">Make A Transfer</a>
	</form>
	</div>

</body>
</html>